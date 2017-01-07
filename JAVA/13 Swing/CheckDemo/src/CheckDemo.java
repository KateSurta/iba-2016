// пример использования JCheckbox.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
  <applet code="CheckDemo" width=270 height=50>
  </applet>
*/

public class CheckDemo extends JApplet
implements ItemListener {
  JLabel jlab;

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
      System.out.println("Ошибка создания апплета " + exc);
    }
  }

  private void makeGUI() {

    // определяем порядок расположения элементов
    setLayout(new FlowLayout());

    // создаем и добавляем чекбоксы на апплет
    // и регистрируем его же как обработчик событий ItemEvent
    JCheckBox cb = new JCheckBox("C");
    cb.addItemListener(this);
    add(cb);

    cb = new JCheckBox("C++");
    cb.addItemListener(this);
    add(cb);
    
    cb = new JCheckBox("Java");
    cb.addItemListener(this);
    add(cb);

    cb = new JCheckBox("Perl");
    cb.addItemListener(this);
    add(cb);

    // создаем метку
    jlab = new JLabel("Выберите язык");
    add(jlab);
  }

  // Обработка событий от всех чекбоксов
  public void itemStateChanged(ItemEvent ie) {
	// определяем, кто "выстрелил" - извлекаем из события
    JCheckBox cb = (JCheckBox) ie.getItem();

    // определяем текущее состояние элемента и выводим сообщение
    if(cb.isSelected())
      jlab.setText(cb.getText() + " лучший!");
    else
      jlab.setText(cb.getText() + " не лучший :(");
  }
}