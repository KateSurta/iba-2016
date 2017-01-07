// ������ ������������� JScrollPane.
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
        System.out.println("������ �������� ������� " + exc);
      }
    }

    private void makeGUI() {

      // ������� 400 (���������) ������ � ��������� �� �� ������
      JPanel jp = new JPanel();
      jp.setLayout(new GridLayout(20, 20));
      int b = 0;

      for(int i = 0; i < 20; i++) {
        for(int j = 0; j < 20; j++) {
          jp.add(new JButton("������ " + b));
          ++b;
        }
      }

      // ������� �������������� ������, ��������� �� � �������� ��������� ������ � ��������
      JScrollPane jsp = new JScrollPane(jp);

      // ��������� �������������� ������ � ��������� �������� ������
      add(jsp, BorderLayout.CENTER);
    }
  }