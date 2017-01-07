// пример JTextField и JLabel
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
  <applet code="SimpleDemo" width=500 height=500>
  </applet>
*/

public class SimpleDemo extends JApplet {
	JLabel jl;
	JTextField jtf;

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

    // определяем порядок расположения элементов
    setLayout(new FlowLayout());
    
    // создаем метку
    JLabel jl = new JLabel("Введите текст", JLabel.CENTER);
    // помещаем ее на апплет
    add(jl);

    // теперь создаем текстовое поле и тоже выкладываем его на апплет
    jtf = new JTextField(15);
    add(jtf);
    // и регистрируем обработчик события (отображаем введенный текст в строке состояния)
    jtf.addActionListener((ae) -> showStatus(jtf.getText()));

  }
}