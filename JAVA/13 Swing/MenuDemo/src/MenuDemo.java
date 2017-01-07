// ������������ ��������� ���� MenuDemo

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemo implements ActionListener {

  JLabel jlab;
  // ������� ����
  JMenuBar jmb;
  // ������ ������������
  JToolBar jtb;
  // ����������� ����
  JPopupMenu jpu;
  // actions - "��������" ��� ���� � ������
  DebugAction setAct;
  DebugAction clearAct;
  DebugAction resumeAct;

  // ����������� - ��������� ���������������� ������
  MenuDemo() {
    // ������� ��������� �������� ������ (JFrame)
	// ���������� ���������� �� ���������, ��������� ������ ��������� � ������
    JFrame jfrm = new JFrame("Menu Demo");
    jfrm.setSize(360, 200);

    // ��� �������� ���������� - ��������� ��� ������
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // ����� ��� ����������� ���������� ������ ����
    jlab = new JLabel();

    // ������� ������� ����
    jmb = new JMenuBar();

    // ������� ���� File
    makeFileMenu();

    // ������� ��������
    makeActions();

    // ������� ������ ������������
    makeToolBar();

    // ������� ���� Options
    makeOptionsMenu();

    // ������� ���� Help
    makeHelpMenu();

    // ������� ����������� ���� Edit
    makeEditPUMenu();

    // ��������� �������� ������� ���� ��� ����������� ������������ ����
    // (����������� ��������� ��� �����)
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

    // �������� ����� � ����� ����
    jfrm.add(jlab, SwingConstants.CENTER);

    // ��������� ������ ������������...
    jfrm.add(jtb, BorderLayout.NORTH);
    // ...������� ����...
    jfrm.setJMenuBar(jmb);

    // � ���������� ����
    jfrm.setVisible(true);
  }

  // ����������� ������� ���� (����� Debug - ��� ���� �����)
  public void actionPerformed(ActionEvent ae) {
    // �������� �������� ���������� ������
    String comStr = ae.getActionCommand();

    // ���� ��� Exit, ��������� ���������
    if(comStr.equals("Exit")) System.exit(0);

    // ���� ��� - ���������� ��������� ����� � �����
    jlab.setText("������ ����� " + comStr);
  }
 
  // ���������� ����� �������� ��� ������� Debug
  class DebugAction extends AbstractAction {
    public DebugAction(String name, Icon image, int mnem, int accel, String tTip) {
      // �������� ������������ �����������, ����� ��������� ������� ������, ��������� � ��������
      super(name, image);
      putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
      putValue(MNEMONIC_KEY, new Integer(mnem));
      putValue(SHORT_DESCRIPTION, tTip);
    }

    // ��������� ������� ����� � ����, � ������ ������ ������������ 
    // (������ ��� �������� Debug!)
    public void actionPerformed(ActionEvent ae) {
      // ����������, ��� ������
      String comStr = ae.getActionCommand();
      jlab.setText("������ ����� " + comStr);

      // ����������� ��������� ������� Set � Clear Breakpoint
      if(comStr.equals("Set Breakpoint")) {
        clearAct.setEnabled(true);
        setAct.setEnabled(false);
      } else if(comStr.equals("Clear Breakpoint")) {
        clearAct.setEnabled(false);
        setAct.setEnabled(true);
      }
    }
  }
  
  
  // ����� ��� �������� ���� File
  void makeFileMenu() {
	// ������� ���� � ����������
    JMenu jmFile = new JMenu("File");
    jmFile.setMnemonic(KeyEvent.VK_F);

    // ������� ������ � �������� ���������
    JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);
    jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

    JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
    jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

    JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
    jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
    
    JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
    jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

    // ��������� ������ � ����
    jmFile.add(jmiOpen);
    jmFile.add(jmiClose);
    jmFile.add(jmiSave);
    jmFile.addSeparator();
    jmFile.add(jmiExit);
    // ��������� ���� � ������� ����
    jmb.add(jmFile);

    // ������������ ��������� ��� ������� ���� File (��� ����� � ����������)
    jmiOpen.addActionListener(this);
    jmiClose.addActionListener(this);
    jmiSave.addActionListener(this);
    jmiExit.addActionListener(this);
}


  // ������� ���� Options
  void makeOptionsMenu() {
	// ������� ���� ����
    JMenu jmOptions = new JMenu("Options");

    // ������� ������� Colors
    JMenu jmColors = new JMenu("Colors");

    // ������� ������ � ����������
    JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
    JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
    JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");

    // ��������� ������ � ����
    jmColors.add(jmiRed);
    jmColors.add(jmiGreen);
    jmColors.add(jmiBlue);
    jmOptions.add(jmColors);

    // ������� ������� Priority
    JMenu jmPriority = new JMenu("Priority");

    // ������� ������-�������������
    JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High", true);
    JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");
    // ����������� ������-������������� � ������
    ButtonGroup bg = new ButtonGroup();
    bg.add(jmiHigh);
    bg.add(jmiLow);
    // � ��������� �� � ������� Priority
    jmPriority.add(jmiHigh);

    
    // ������ ��������� ������� � ����
    jmPriority.add(jmiLow);
    jmOptions.add(jmPriority);


    // ������� ������� Debug � �������������� ��������
    JMenu jmDebug = new JMenu("Debug");
    JMenuItem jmiSetBP = new JMenuItem(setAct);
    JMenuItem jmiClearBP = new JMenuItem(clearAct);
    JMenuItem jmiResume = new JMenuItem(resumeAct);

    jmDebug.add(jmiSetBP);
    jmDebug.add(jmiClearBP);
    jmDebug.add(jmiResume);

    // ��������� ������� Debug � ���� Options 
    jmOptions.add(jmDebug);

    // ��������� ����� Reset
    JMenuItem jmiReset = new JMenuItem("Reset");
    jmOptions.addSeparator();
    jmOptions.add(jmiReset);

    // � ������� �������� ���� Options � ������� ����
    jmb.add(jmOptions);

    // �� ������ ���������������� ��������� ��� �������!
    jmiRed.addActionListener(this);
    jmiGreen.addActionListener(this);
    jmiBlue.addActionListener(this);
    jmiHigh.addActionListener(this);
    jmiLow.addActionListener(this);
    jmiReset.addActionListener(this);
  }

  // ���� Help - ���� ��� ����
  void makeHelpMenu() {
    JMenu jmHelp = new JMenu("Help");

    // ��������� �������� ��� �����
    ImageIcon icon = new ImageIcon("AboutIcon.gif");
    // ������� ��� �����
    JMenuItem jmiAbout = new JMenuItem("About", icon);
    jmiAbout.setToolTipText("���� � ���������");
    // ���������� ����� � ����, � ���� - � ������� ����
    jmHelp.add(jmiAbout);
    jmb.add(jmHelp);
    // �� �������� ��� �������� �������!
    jmiAbout.addActionListener(this);
  }

  // ������ ���������� - ������ �������� ��� ���� Debug
  void makeActions() {
    // ������ �������� ��� ������
    ImageIcon setIcon = new ImageIcon("setBP.gif");
    ImageIcon clearIcon = new ImageIcon("clearBP.gif");
    ImageIcon resumeIcon = new ImageIcon("resume.gif");

    // ������� ���� ��������
    setAct =
      new DebugAction("Set Breakpoint",
                      setIcon,
                      KeyEvent.VK_S,
                      KeyEvent.VK_B,
                      "���������� ����������.");

    clearAct =
      new DebugAction("Clear Breakpoint",
                      clearIcon,
                      KeyEvent.VK_C,
                      KeyEvent.VK_L,
                      "����� ����������");

    resumeAct =
      new DebugAction("Resume",
                      resumeIcon,
                      KeyEvent.VK_R,
                      KeyEvent.VK_R,
                      "����������� ����������");

    // ���������� ��������� ����� Clear Breakpoint
    clearAct.setEnabled(false);
  }

  // ������� ������ ������ Debug
  void makeToolBar() {
    // ������� ������
    JButton jbtnSet = new JButton(setAct);
    JButton jbtnClear = new JButton(clearAct);
    JButton jbtnResume = new JButton(resumeAct);

    // ������ ���� ������
    jtb = new JToolBar("Breakpoints");

    // ������ ������ �� ������
    jtb.add(jbtnSet);
    jtb.add(jbtnClear);
    jtb.add(jbtnResume);
  }
  
  
  
  // ������� ����������� ���� Edit
  void makeEditPUMenu() {
	// ������� ������ ������������ ����
    jpu = new JPopupMenu();

    // ������� ��� ������
    JMenuItem jmiCut = new JMenuItem("Cut");
    JMenuItem jmiCopy = new JMenuItem("Copy");
    JMenuItem jmiPaste = new JMenuItem("Paste");

    // ������ ������ � ����
    jpu.add(jmiCut);
    jpu.add(jmiCopy);
    jpu.add(jmiPaste);

    // � ������������ ��� ��� ���������
    jmiCut.addActionListener(this);
    jmiCopy.addActionListener(this);
    jmiPaste.addActionListener(this);
  }

  public static void main(String args[]) {
    // ������� ����� ���������....
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new MenuDemo();
      }
    });
  }
}