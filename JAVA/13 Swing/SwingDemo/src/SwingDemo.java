// каркас Swing-приложения

// подключаем библиотеки
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class SwingDemo {

  // компонент-метка
  JLabel jlab;

  // основные действия - в конструкторе
  SwingDemo() {

    // создаем контейнер верхнего уровня (JFrame)
    JFrame jfrm = new JFrame("Простое Swing-приложение");
    // определяем порядок расположения компонентов на нем
    jfrm.setLayout(new FlowLayout());
    // и устанавливаем его размер
    jfrm.setSize(200, 100);

    // реакция на закрытие окна - завершить приложение
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    // две кнопки - Альфа и Бета
    JButton jbtnAlpha = new JButton("Alpha");
    JButton jbtnBeta = new JButton("Beta");

    // приемник событий от кнопки Альфа
    jbtnAlpha.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jlab.setText("Нажата Alpha!");
      }
    });

    // приемник событий от кнопки Бета
    jbtnBeta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jlab.setText("Нажата Beta!");
      }
    });
    
    // любители лямбда-выражений могут сделать так (согласитесь - компактнее):
    // jbtnAlpha.addActionListener( (ae) -> jlab.setText("Нажата Alpha!"));
    // jbtnBeta.addActionListener( (ae) -> jlab.setText("Нажата Beta!"));

    
    // добавляем кнопки в контейнер
    jfrm.add(jbtnAlpha);
    jfrm.add(jbtnBeta);
    
    // создаем и добавляем метку туда же
    jlab = new JLabel("Нажмите какую-нибудь кнопку");
    jfrm.add(jlab);

    // и отображаем его всем желающим
    jfrm.setVisible(true);
  }

  // точка входа
  public static void main(String args[]) {
    // в GUI-приложении надо выполнять обработку событий
	// главный поток исполнения этого не умеет - нужен отдельный поток диспетчеризации событий
	// потому создаем анонимный запускаемый поток и помещаем в него наше приложение
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingDemo();
      }
    });
  }
}