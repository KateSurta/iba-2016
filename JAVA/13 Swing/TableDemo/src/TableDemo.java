// ������ JTable.
import java.awt.*;
import javax.swing.*;

/*
  <applet code="JTableDemo" width=400 height=200>
  </applet>
*/

public class TableDemo extends JApplet {

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

    // ������ ����������
    String[] colHeads = { "���", "�������", "��������" };

    // ���� ������ - ��������� ������ (�� ��� �������)
    Object[][] data = {
      { "����", "4567", "865" },
      { "������", "7566", "555" },
      { "�������", "5634", "587" },
      { "�������", "7345", "922" },
      { "���������", "1237", "333" },
      { "����������", "5656", "314" },
      { "�������", "5672", "217" },
      { "����", "6741", "444" },
      { "�����", "9023", "519" },
      { "���������", "1134", "532" },
      { "�������", "5689", "112" },
      { "������", "9030", "133" },
      { "�����", "6751", "145" }
    };

    // ������� �������, ��������� ������ ������� � ������ ������
    JTable table = new JTable(data, colHeads);

    // ��������� ������� � ������ ��������� � ����������� �� (������) �� ������
    JScrollPane jsp = new JScrollPane(table);
    add(jsp);
  }
}