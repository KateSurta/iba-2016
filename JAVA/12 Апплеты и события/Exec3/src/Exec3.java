// ������ ������������� ���������� ����������� ������ 
import java.applet.*;
import java.awt.event.*;
/*
  <applet code="AnonymousInnerClassDemo" width=200 height=100>
  </applet>
*/

public class Exec3 extends Applet {
  public void init() {
	// ��������� � �������� ��������� ������ ���������� ����������� ������ - ��� �����
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        showStatus("���� ������!");
      }
    });
  }
}