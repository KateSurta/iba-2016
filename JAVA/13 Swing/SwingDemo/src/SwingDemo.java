// ������ Swing-����������

// ���������� ����������
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class SwingDemo {

  // ���������-�����
  JLabel jlab;

  // �������� �������� - � ������������
  SwingDemo() {

    // ������� ��������� �������� ������ (JFrame)
    JFrame jfrm = new JFrame("������� Swing-����������");
    // ���������� ������� ������������ ����������� �� ���
    jfrm.setLayout(new FlowLayout());
    // � ������������� ��� ������
    jfrm.setSize(200, 100);

    // ������� �� �������� ���� - ��������� ����������
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    // ��� ������ - ����� � ����
    JButton jbtnAlpha = new JButton("Alpha");
    JButton jbtnBeta = new JButton("Beta");

    // �������� ������� �� ������ �����
    jbtnAlpha.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jlab.setText("������ Alpha!");
      }
    });

    // �������� ������� �� ������ ����
    jbtnBeta.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        jlab.setText("������ Beta!");
      }
    });
    
    // �������� ������-��������� ����� ������� ��� (����������� - ����������):
    // jbtnAlpha.addActionListener( (ae) -> jlab.setText("������ Alpha!"));
    // jbtnBeta.addActionListener( (ae) -> jlab.setText("������ Beta!"));

    
    // ��������� ������ � ���������
    jfrm.add(jbtnAlpha);
    jfrm.add(jbtnBeta);
    
    // ������� � ��������� ����� ���� ��
    jlab = new JLabel("������� �����-������ ������");
    jfrm.add(jlab);

    // � ���������� ��� ���� ��������
    jfrm.setVisible(true);
  }

  // ����� �����
  public static void main(String args[]) {
    // � GUI-���������� ���� ��������� ��������� �������
	// ������� ����� ���������� ����� �� ����� - ����� ��������� ����� ��������������� �������
	// ������ ������� ��������� ����������� ����� � �������� � ���� ���� ����������
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new SwingDemo();
      }
    });
  }
}