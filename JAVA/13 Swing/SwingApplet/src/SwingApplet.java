// ������ Swing-�������

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// �����������, ���-��������
/*
This HTML can be used to launch the applet:

<applet code="SwingApplet" width=220 height=90>
</applet>
*/

public class SwingApplet extends JApplet {
  // ������ ������ � ����� ����������� ������ - ��� �������
  JButton jbtnAlpha;
  JButton jbtnBeta;
  JLabel jlab;

  // �������������
  public void init() {
    try {
      SwingUtilities.invokeAndWait(new Runnable () {
        public void run() {
          makeGUI(); // ������ ������ paint() �� ������������ AWT-��������
        }
      });
    } catch(Exception exc) {
      System.out.println("������ ������� �������: "+ exc);
    }
  }
  
  // ��� ����� ���������
  private void makeGUI() {

    // ������������� ������� ���������� ���������
    setLayout(new FlowLayout());

    // ������� ������� ������
    jbtnAlpha = new JButton("Alpha");
    jbtnBeta = new JButton("Beta");
    
    // � ��������� ��������� �� �������
    jbtnAlpha.addActionListener( (ae) -> jlab.setText("������ Alpha!"));
    jbtnBeta.addActionListener( (ae) -> jlab.setText("������ Beta!"));

    // ������� ������ �� ������ 
    add(jbtnAlpha);
    add(jbtnBeta);

    // ������� ������ ����� � ������� �� �� ������ 
    jlab = new JLabel("������� �����-������ ������");
    add(jlab);
   }
}