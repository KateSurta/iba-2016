// пример использования JScrollPane.
import java.awt.*;
import javax.swing.*;
/*
  <applet code="ScrollDemo" width=300 height=250>
  </applet>
*/

public class ScrollDemo extends JApplet {

  public void init() {
    try {
      SwingUtilities.invokeAndWait(
        new Runnable() {
          public void run() {
              makeGUI();
            }
          }
        );
      } catch (Exception exc) {
        System.out.println("Ошибка загрузки апплета " + exc);
      }
    }

    private void makeGUI() {

      // создаем 400 (четыреста) кнопок и добавляем их на панель
      JPanel jp = new JPanel();
      jp.setLayout(new GridLayout(20, 20));
      int b = 0;

      for(int i = 0; i < 20; i++) {
        for(int j = 0; j < 20; j++) {
          jp.add(new JButton("Кнопка " + b));
          ++b;
        }
      }

      // создаем прокручиваемую панель, передавая ей в качестве параметра панель с кнопками
      JScrollPane jsp = new JScrollPane(jp);

      // добавляем прокручиваемую панель в контейнер верхнего уровня
      add(jsp, BorderLayout.CENTER);
    }
  }