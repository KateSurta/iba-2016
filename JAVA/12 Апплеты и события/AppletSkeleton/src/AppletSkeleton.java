// ������ "�������" ��� �������

// ���������� ����������
import java.awt.*;
import java.applet.*;

// ���� ��� ��������� HTML-��������
/*
<applet code="AppletSkel" width=300 height=400>
</applet>
*/

// ���������� ����� ��� �������
public class AppletSkeleton extends Applet {
	
	String strContent;

	// �����, ������� ���������� ������
  public void init() {
	// ��� ����� ���-������ ����������������
	  // ��������, ������������� ���� ���� � ������
	  setBackground(Color.black);
	  setForeground(Color.white);
	  strContent = "init";
  }

  // ���������� ����� ����� init() ��� �������������� ������� � ��� ������ �����������
  public void start() {
	  strContent += " - start - ";
  }

  // ���������� ��� ������������ �������
  public void stop() {
    // ����� ���� ���� ������
	  strContent += "stop";
  }

  // ����� �������������� ���������� ������ ������� (���������� ���������)
  public void destroy() {
    // ��� ����� ���������� �����-������ �������
  }

  // ���������� ��� ������ ����������� �������
  public void paint(Graphics g) {
    // ����������, �����������
	g.drawString(strContent, 20, 20);
  }
}