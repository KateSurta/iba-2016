// ������ ������������� JComboBox.
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

	  String rivers[] = { "�����", "���", "�����", "��������" };

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
	      System.out.println("������ �������� ������� " + exc);
	    }
	  }

	  private void makeGUI() {
	    setLayout(new FlowLayout());

	    // ������� ����� � ����������� �� ������
	    jcb = new JComboBox<String>(rivers);
	    add(jcb);
	    // ������� ������ ��� ��������� �������
	    jcb.addActionListener((ae) -> jlab.setText((String) jcb.getSelectedItem())); 
	    
	    // ����� ��� ����������� ������
	    jlab = new JLabel("�������� ����");
	    add(jlab);
	}
}

