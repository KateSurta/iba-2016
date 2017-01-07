// пример Swing-апплета

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// естественно, тег-оболочка
/*
This HTML can be used to launch the applet:

<applet code="SwingApplet" width=220 height=90>
</applet>
*/

public class SwingApplet extends JApplet {
  // делаем кнопки и метку переменными класса - так удобнее
  JButton jbtnAlpha;
  JButton jbtnBeta;
  JLabel jlab;

  // инициализация
  public void init() {
    try {
      SwingUtilities.invokeAndWait(new Runnable () {
        public void run() {
          makeGUI(); // замена метода paint() из классических AWT-апплетов
        }
      });
    } catch(Exception exc) {
      System.out.println("Ошибка запуска апплета: "+ exc);
    }
  }
  
  // сам метод отрисовки
  private void makeGUI() {

    // устанавливаем порядок размещения элементов
    setLayout(new FlowLayout());

    // создаем объекты кнопок
    jbtnAlpha = new JButton("Alpha");
    jbtnBeta = new JButton("Beta");
    
    // и добавляем приемники их событий
    jbtnAlpha.addActionListener( (ae) -> jlab.setText("Нажата Alpha!"));
    jbtnBeta.addActionListener( (ae) -> jlab.setText("Нажата Beta!"));

    // выносим кнопки на апплет 
    add(jbtnAlpha);
    add(jbtnBeta);

    // создаем объект метки и выносим ее на апплет 
    jlab = new JLabel("Нажмите какую-нибудь кнопку");
    add(jlab);
   }
}