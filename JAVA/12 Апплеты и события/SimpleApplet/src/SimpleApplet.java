// подключаем библиотеки
import java.awt.*;
import java.applet.*;

// это "заготовка" для просмотрщика
/*
<applet code="SimpleApplet" width=200 height=60>
</applet>
*/

// сам класс апплета
public class SimpleApplet extends Applet {
  public void paint(Graphics g) {
	// при перерисовке просто (пока) выводим сообщение
    g.drawString("Здравствуй, мир!!!", 20, 20);
  }
}