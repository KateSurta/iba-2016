// Demonstrate JTabbedPane.
import javax.swing.*;
/*
  <applet code="TabsDemo" width=400 height=100>
  </applet>
*/

public class TabsDemo extends JApplet {

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
      System.out.println("Can't create because of " + exc);
    }
  }

  private void makeGUI() {

	// создаем переключаемую панель и заполняем ее контейнерами, определенными ниже
    JTabbedPane jtp = new JTabbedPane();
    jtp.addTab("Города", new CitiesPanel());
    jtp.addTab("Страны", new CountriesPanel());
    jtp.addTab("Реки", new RiversPanel());
    add(jtp);
  }
}

// контейнер "Города"
class CitiesPanel extends JPanel {

public CitiesPanel() {
 JButton b1 = new JButton("Минск");
 add(b1);
 JButton b2 = new JButton("Витебск");
 add(b2); 
 JButton b3 = new JButton("Гродно");
 add(b3);
 JButton b4 = new JButton("Брест");
 add(b4);
}
}

// контейнер "Страны"
class CountriesPanel extends JPanel {

public CountriesPanel() {
 JCheckBox cb1 = new JCheckBox("Беларусь");
 add(cb1);
 JCheckBox cb2 = new JCheckBox("Россия");
 add(cb2);
 JCheckBox cb3 = new JCheckBox("Литва");
 add(cb3);
}
}

// контейнер "Реки"
class RiversPanel extends JPanel {

public RiversPanel() {
 JComboBox<String> jcb = new JComboBox<String>();
 jcb.addItem("Свислочь");
 jcb.addItem("Неман");
 jcb.addItem("Буг");
 jcb.addItem("Двина");
 add(jcb);
}
}