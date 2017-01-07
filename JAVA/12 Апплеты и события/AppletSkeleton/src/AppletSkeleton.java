// пример "скелета" для апплета

// подключаем библиотеки
import java.awt.*;
import java.applet.*;

// теги для генерации HTML-оболочки
/*
<applet code="AppletSkel" width=300 height=400>
</applet>
*/

// собственно класс для апплета
public class AppletSkeleton extends Applet {
	
	String strContent;

	// метод, который вызывается первым
  public void init() {
	// тут можно что-нибудь инициализировать
	  // например, устанавливаем цвет фона и шрифта
	  setBackground(Color.black);
	  setForeground(Color.white);
	  strContent = "init";
  }

  // вызывается сразу после init() при первоначальном запуске и при каждом перезапуске
  public void start() {
	  strContent += " - start - ";
  }

  // вызывается при приостановке апплета
  public void stop() {
    // может быть своя логика
	  strContent += "stop";
  }

  // метод окончательного завершения работы апплета (вызывается последним)
  public void destroy() {
    // тут можно освободить какие-нибудь ресурсы
  }

  // вызывается при каждой перерисовке апплета
  public void paint(Graphics g) {
    // собственно, перерисовка
	g.drawString(strContent, 20, 20);
  }
}