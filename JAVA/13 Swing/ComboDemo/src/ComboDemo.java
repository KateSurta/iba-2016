// пример использования JComboBox.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
  <applet code="ComboDemo" width=300 height=200>
  </applet>
*/
public class ComboDemo extends JApplet {
	
	  JLabel jlab;
	  JComboBox<String> jcb;

	  String rivers[] = { "Двина", "Буг", "Неман", "Свислочь" };

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
	    setLayout(new FlowLayout());

	    // создаем комбо и выкладываем на апплет
	    jcb = new JComboBox<String>(rivers);
	    add(jcb);
	    // создаем лямбду для обработки события
	    jcb.addActionListener((ae) -> jlab.setText((String) jcb.getSelectedItem())); 
	    
	    // метка для отображения выбора
	    jlab = new JLabel("Выберите реку");
	    add(jlab);
	}
}

