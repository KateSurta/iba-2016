// ������ ������� ��� �������� �����������

// ���-��������
/*
 * <applet code="SimpleImageLoad" width=600 height=600>
 *   * </applet>
 */
import java.awt.*;
import java.applet.*;

// ��� ������
public class ImageLoader extends Applet
{
  // ������ ��� ������ � ������������
  Image img;

  public void init() {
	// �������� ����������� �� �����
    img = getImage(getDocumentBase(), "java.jpg");
	}

  public void paint(Graphics g) {
	  // 
	  if (img == null) 
		  g.drawString("No image!", 20, 20);
	  else
		  g.drawImage(img, 0, 0, this);
  }
}