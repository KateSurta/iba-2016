// пример открытия 

import java.awt.*;
import java.applet.*;
import java.net.*;

/*
<applet code="FollowMe" width=300 height=50>
</applet>
*/

public class FollowMe extends Applet {
  public void start() {
	// получаем контекст апплета
    AppletContext ac = getAppletContext();
    URL url = getCodeBase(); // получаем каталог, в котором размещен апплет

    try {
      ac.showDocument(new URL(url+"Test.html"));
    } catch(MalformedURLException e) {
      showStatus("URL не найдет");
    }
  }
}