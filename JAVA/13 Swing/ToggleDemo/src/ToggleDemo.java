// работа с фиксируемой кнопкой
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
  <applet code="ToggleDemo" width=200 height=80>
  </applet>
*/

public class ToggleDemo extends JApplet {

  // объекты для метки и кнопки
  JLabel jlab;
  JToggleButton jtbn;

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
        System.out.println("Ошибка запуска апплета " + exc);
      }
    }

    private void makeGUI() {

      // определяем порядок расположения компонентов
      setLayout(new FlowLayout());

      // создаем метку
      jlab = new JLabel("Кнопка выкл.");

      // создаем кнопку
      jtbn =  new JToggleButton("Вкл/Выкл");

      // добавляем обработчик
      jtbn.addItemListener(new ItemListener() {
        public void itemStateChanged(ItemEvent ie) {
          if(jtbn.isSelected())
            jlab.setText("Кнопка вкл.");
          else
            jlab.setText("Кнопка выкл.");
        }

      });

      // Add the toggle button and label to the content pane.
      add(jtbn);
      add(jlab);
    }
  }