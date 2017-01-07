// ������ �������-"�������"
import java.awt.*;
import java.applet.*;

// ��� ��� ����
/*
<applet code="MyBanner" width=300 height=50>
<param name=message value="Java makes the Web move!">
</applet>
*/

// ��� ������ - �������� �������� �� ���������� ���������� Runnable
public class MyBanner extends Applet implements Runnable {
  // ������ ��� �����������
  String msg;
  // ����� ��� �����������
  Thread t = null;
  // ��������� �������
  int state;
  volatile boolean stopFlag;

  // �������������� ������
  public void init() {
    setBackground(Color.black);
    setForeground(Color.white);
  }

  // ������ �������
  public void start() {
    msg = getParameter("message");
    if(msg == null) msg = "Java is da best";
    msg = " " + msg;
    // ��������� ����� ����� - � ��������� ���
    t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  // ����� ����� ������ �������
  public void run() {

    // �������������� ������ � ����������� �����
    for( ; ; ) {
      try {
    	// ����� ����������� ������� (�.�. ������ ����)
        repaint();
        // ���� �������
        Thread.sleep(125);
        // ��������� ���� ��������
        if(stopFlag)
          break;
      } catch(InterruptedException e) {}
    }
  }
  
  // ������������ �������
  public void stop() {
	// ���������� ���� �������� - ����� ������������������
    stopFlag = true;
    // ����������� �� ������ (��� ����������� ������� ���� ���)
    t = null;
  }

  // ���� ����������� �������
  public void paint(Graphics g) {
    char ch;

    // �������������� ������ � �����
    ch = msg.charAt(0);
    msg = msg.substring(1, msg.length());
    msg += ch;

    g.drawString(msg, 50, 30);
  }
}