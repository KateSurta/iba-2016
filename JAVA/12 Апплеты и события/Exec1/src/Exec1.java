// ������������ ����������� ���������
import java.applet.*;
import java.awt.event.*;
/*
  <applet code="MousePressedDemo" width=200 height=100>
  </applet>
*/

public class Exec1 extends Applet {
  public void init() {
	// ���������� �����-�������
    addMouseListener(new MyMouseAdapter(this));
  }
}

// �����-������� ��� ������������ ������� ����
class MyMouseAdapter extends MouseAdapter {
	Exec1 mousePressedDemo;
  public MyMouseAdapter(Exec1 mousePressedDemo) {
    this.mousePressedDemo = mousePressedDemo;
  }
  public void mousePressed(MouseEvent me) {
    mousePressedDemo.showStatus("���� ������!");
  }
}