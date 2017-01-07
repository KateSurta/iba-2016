// демонстрация всяческих меню MenuDemo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemo implements ActionListener {

  JLabel jlab;
  // главное меню
  JMenuBar jmb;
  // панель инструментов
  JToolBar jtb;
  // всплывающее меню
  JPopupMenu jpu;
  // actions - "комбайны" для меню и кнопок
  DebugAction setAct;
  DebugAction clearAct;
  DebugAction resumeAct;

  // конструктор - выполняем подготовительную работу
  MenuDemo() {
    // создаем контейнер верхнего уровня (JFrame)
	// используем компоновку по умолчанию, указываем только заголовок и размер
    JFrame jfrm = new JFrame("Menu Demo");
    jfrm.setSize(360, 200);

    // при закрытии приложения - завершаем его работу
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // метка для отображения выбранного пункта меню
    jlab = new JLabel();

    // создаем главное меню
    jmb = new JMenuBar();

    // создаем меню File
    makeFileMenu();

    // создаем действия
    makeActions();

    // создаем панель инструментов
    makeToolBar();

    // создаем меню Options
    makeOptionsMenu();

    // создаем меню Help
    makeHelpMenu();

    // создаем всплывающее меню Edit
    makeEditPUMenu();

    // добавляем приемник событий мыши для отображения всплывающего меню
    // (генератором выступает сам фрейм)
    jfrm.addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        if(me.isPopupTrigger())
          jpu.show(me.getComponent(), me.getX(), me.getY());
      }
      public void mouseReleased(MouseEvent me) {
        if(me.isPopupTrigger())
          jpu.show(me.getComponent(), me.getX(), me.getY());
      }
    });

    // помещаем метку в центр окна
    jfrm.add(jlab, SwingConstants.CENTER);

    // добавляем панель инструментов...
    jfrm.add(jtb, BorderLayout.NORTH);
    // ...главное меню...
    jfrm.setJMenuBar(jmb);

    // и отображаем окно
    jfrm.setVisible(true);
  }

  // обработчики пунктов меню (кроме Debug - там своя кухня)
  public void actionPerformed(ActionEvent ae) {
    // получаем название выбранного пункта
    String comStr = ae.getActionCommand();

    // если это Exit, закрываем программу
    if(comStr.equals("Exit")) System.exit(0);

    // если нет - отображаем выбранные пункт в метке
    jlab.setText("Выбран пункт " + comStr);
  }
 
  // внутренний класс действия для пунктов Debug
  class DebugAction extends AbstractAction {
    public DebugAction(String name, Icon image, int mnem, int accel, String tTip) {
      // вызываем родительский конструктор, потом добавляем горячую кнопку, мнемонику и описание
      super(name, image);
      putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
      putValue(MNEMONIC_KEY, new Integer(mnem));
      putValue(SHORT_DESCRIPTION, tTip);
    }

    // обработка событий сразу и меню, и кнопки панели инструментов 
    // (только для действий Debug!)
    public void actionPerformed(ActionEvent ae) {
      // определяем, что нажали
      String comStr = ae.getActionCommand();
      jlab.setText("Выбран пункт " + comStr);

      // переключаем состояние пунктов Set и Clear Breakpoint
      if(comStr.equals("Set Breakpoint")) {
        clearAct.setEnabled(true);
        setAct.setEnabled(false);
      } else if(comStr.equals("Clear Breakpoint")) {
        clearAct.setEnabled(false);
        setAct.setEnabled(true);
      }
    }
  }
  
  
  // метод для создания меню File
  void makeFileMenu() {
	// создаем меню с мнемоникой
    JMenu jmFile = new JMenu("File");
    jmFile.setMnemonic(KeyEvent.VK_F);

    // создаем пункты с горячими клавишами
    JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);
    jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

    JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
    jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

    JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
    jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
    
    JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
    jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

    // добавляем пункты в меню
    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    // добавляем меню в главное меню
    jmb.add(jmFile);

    // регистрируем приемники для пунктов меню File (сам класс и обработает)
    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);
}


  // создаем меню Options
  void makeOptionsMenu() {
	// создаем само меню
    JMenu jmOptions = new JMenu("Options");

    // создаем подменю Colors
    JMenu jmColors = new JMenu("Colors");

    // создаем пункты с чекбоксами
    JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
    JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
    JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");

    // добавляем пункты в меню
    jmColors.add(jmiRed);
    jmColors.add(jmiGreen);
    jmColors.add(jmiBlue);
    jmOptions.add(jmColors);

    // создаем подменю Priority
    JMenu jmPriority = new JMenu("Priority");

    // создаем пункты-переключатели
    JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High", true);
    JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");
    // объекдиняем кнопки-переключатели в группу
    ButtonGroup bg = new ButtonGroup();
    bg.add(jmiHigh);
    bg.add(jmiLow);
    // и добавляем их в подменю Priority
    jmPriority.add(jmiHigh);

    
    // теперь добавляем подменю в меню
    jmPriority.add(jmiLow);
    jmOptions.add(jmPriority);


    // создаем подменю Debug с использованием действий
    JMenu jmDebug = new JMenu("Debug");
    JMenuItem jmiSetBP = new JMenuItem(setAct);
    JMenuItem jmiClearBP = new JMenuItem(clearAct);
    JMenuItem jmiResume = new JMenuItem(resumeAct);

    jmDebug.add(jmiSetBP);
    jmDebug.add(jmiClearBP);
    jmDebug.add(jmiResume);

    // добавляем подменю Debug в меню Options 
    jmOptions.add(jmDebug);

    // Добавляем пункт Reset
    JMenuItem jmiReset = new JMenuItem("Reset");
    jmOptions.addSeparator();
    jmOptions.add(jmiReset);

    // и наконец помещаем меню Options в главное меню
    jmb.add(jmOptions);

    // не забыть зарегистрировать приемники для пунктов!
    jmiRed.addActionListener(this);
    jmiGreen.addActionListener(this);
    jmiBlue.addActionListener(this);
    jmiHigh.addActionListener(this);
    jmiLow.addActionListener(this);
    jmiReset.addActionListener(this);
  }

  // меню Help - куда без него
  void makeHelpMenu() {
    JMenu jmHelp = new JMenu("Help");

    // добавляем картинку для пункт
    ImageIcon icon = new ImageIcon("AboutIcon.gif");
    // создаем сам пункт
    JMenuItem jmiAbout = new JMenuItem("About", icon);
    jmiAbout.setToolTipText("Инфа о программе");
    // встраиваем пункт в меню, а меню - в главное меню
    jmHelp.add(jmiAbout);
    jmb.add(jmHelp);
    // не забываем про приемник событий!
    jmiAbout.addActionListener(this);
  }

  // теперь интересное - строим действия для меню Debug
  void makeActions() {
    // грузим картинки для кнопок
    ImageIcon setIcon = new ImageIcon("setBP.gif");
    ImageIcon clearIcon = new ImageIcon("clearBP.gif");
    ImageIcon resumeIcon = new ImageIcon("resume.gif");

    // создаем сами действия
    setAct =
      new DebugAction("Set Breakpoint",
                      setIcon,
                      KeyEvent.VK_S,
                      KeyEvent.VK_B,
                      "Установить брейкпойнт.");

    clearAct =
      new DebugAction("Clear Breakpoint",
                      clearIcon,
                      KeyEvent.VK_C,
                      KeyEvent.VK_L,
                      "Снять брейкпойнт");

    resumeAct =
      new DebugAction("Resume",
                      resumeIcon,
                      KeyEvent.VK_R,
                      KeyEvent.VK_R,
                      "Возобновить исполнение");

    // изначально отключить пункт Clear Breakpoint
    clearAct.setEnabled(false);
  }

  // создаем панель кнопок Debug
  void makeToolBar() {
    // создаем кнопки
    JButton jbtnSet = new JButton(setAct);
    JButton jbtnClear = new JButton(clearAct);
    JButton jbtnResume = new JButton(resumeAct);

    // теперь сама панель
    jtb = new JToolBar("Breakpoints");

    // грузим кнопки на панель
    jtb.add(jbtnSet);
    jtb.add(jbtnClear);
    jtb.add(jbtnResume);
  }
  
  
  
  // создаем всплывающее меню Edit
  void makeEditPUMenu() {
	// создаем объект всплывающего меню
    jpu = new JPopupMenu();

    // создаем его пункты
    JMenuItem jmiCut = new JMenuItem("Cut");
    JMenuItem jmiCopy = new JMenuItem("Copy");
    JMenuItem jmiPaste = new JMenuItem("Paste");

    // грузим пункты в меню
    jpu.add(jmiCut);
    jpu.add(jmiCopy);
    jpu.add(jmiPaste);

    // и регистрируем для них приемники
    jmiCut.addActionListener(this);
    jmiCopy.addActionListener(this);
    jmiPaste.addActionListener(this);
  }

  public static void main(String args[]) {
    // наконец можно запустить....
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MenuDemo();
      }
    });
  }
}