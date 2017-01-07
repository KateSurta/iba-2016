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

	// ������� ������������� ������ � ��������� �� ������������, ������������� ����
    JTabbedPane jtp = new JTabbedPane();
    jtp.addTab("������", new CitiesPanel());
    jtp.addTab("������", new CountriesPanel());
    jtp.addTab("����", new RiversPanel());
    add(jtp);
  }
}

// ��������� "������"
class CitiesPanel extends JPanel {

public CitiesPanel() {
 JButton b1 = new JButton("�����");
 add(b1);
 JButton b2 = new JButton("�������");
 add(b2); 
 JButton b3 = new JButton("������");
 add(b3);
 JButton b4 = new JButton("�����");
 add(b4);
}
}

// ��������� "������"
class CountriesPanel extends JPanel {

public CountriesPanel() {
 JCheckBox cb1 = new JCheckBox("��������");
 add(cb1);
 JCheckBox cb2 = new JCheckBox("������");
 add(cb2);
 JCheckBox cb3 = new JCheckBox("�����");
 add(cb3);
}
}

// ��������� "����"
class RiversPanel extends JPanel {

public RiversPanel() {
 JComboBox<String> jcb = new JComboBox<String>();
 jcb.addItem("��������");
 jcb.addItem("�����");
 jcb.addItem("���");
 jcb.addItem("�����");
 add(jcb);
}
}