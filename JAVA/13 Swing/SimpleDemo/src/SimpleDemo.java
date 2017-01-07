// ������ JTextField � JLabel
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
      System.out.println("������ �������� ������� " + exc);
    }
  }

  private void makeGUI() {

    // ���������� ������� ������������ ���������
    setLayout(new FlowLayout());
    
    // ������� �����
    JLabel jl = new JLabel("������� �����", JLabel.CENTER);
    // �������� �� �� ������
    add(jl);

    // ������ ������� ��������� ���� � ���� ����������� ��� �� ������
    jtf = new JTextField(15);
    add(jtf);
    // � ������������ ���������� ������� (���������� ��������� ����� � ������ ���������)
    jtf.addActionListener((ae) -> showStatus(jtf.getText()));

  }
}