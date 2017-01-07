// ������ ������������� JList.
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/*
  <applet code="ListDemo" width=200 height=120>
  </applet>
*/

public class ListDemo extends JApplet {
  JList<String> jlst;
  JLabel jlab;
  JScrollPane jscrlp;

  // ������� ������ ���������
  String Cities[] = { "�����", "�������", "������",
                      "������", "�����", "�������"};

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

    // ������� JList (�� ������ �������������� ������)
    jlst = new JList<String>(Cities);

    // ����������� ������ � ����� ������������� ������
    jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    // ���������� ��� � ������ ���������
    jscrlp = new JScrollPane(jlst);

    // � ������������� �� ������
    jscrlp.setPreferredSize(new Dimension(120, 90));

    // ����� ��� ����������� ����������� ������
    jlab = new JLabel("�������� �����");

    // ��������� ���������� ������� ��� ������
    jlst.addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent le) {
        // �������� ����� "������������" ��������
        int idx = jlst.getSelectedIndex();
        // ���������� ��������� ������ 
        if(idx != -1)
          jlab.setText("������ �����: " + Cities[idx]);
        else // ������ �� ������� - ������� ��� ���
          jlab.setText("�������� �����");

      }
    });

    // ��������� ������ �� ������� � ����� �� ������
    add(jscrlp);
    add(jlab);
  }
}