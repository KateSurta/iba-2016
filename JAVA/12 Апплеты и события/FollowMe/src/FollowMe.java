// ������ �������� 

import java.awt.*;
import java.applet.*;
import java.net.*;

/*
<applet code="FollowMe" width=300 height=50>
</applet>
*/

public class FollowMe extends Applet {
  public void start() {
	// �������� �������� �������
    AppletContext ac = getAppletContext();
    URL url = getCodeBase(); // �������� �������, � ������� �������� ������

    try {
      ac.showDocument(new URL(url+"Test.html"));
    } catch(MalformedURLException e) {
      showStatus("URL �� ������");
    }
  }
}