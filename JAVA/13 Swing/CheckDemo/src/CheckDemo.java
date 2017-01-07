// ������ ������������� JCheckbox.
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
      System.out.println("������ �������� ������� " + exc);
    }
  }

  private void makeGUI() {

    // ���������� ������� ������������ ���������
    setLayout(new FlowLayout());

    // ������� � ��������� �������� �� ������
    // � ������������ ��� �� ��� ���������� ������� ItemEvent
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

    // ������� �����
    jlab = new JLabel("�������� ����");
    add(jlab);
  }

  // ��������� ������� �� ���� ���������
  public void itemStateChanged(ItemEvent ie) {
	// ����������, ��� "���������" - ��������� �� �������
    JCheckBox cb = (JCheckBox) ie.getItem();

    // ���������� ������� ��������� �������� � ������� ���������
    if(cb.isSelected())
      jlab.setText(cb.getText() + " ������!");
    else
      jlab.setText(cb.getText() + " �� ������ :(");
  }
}