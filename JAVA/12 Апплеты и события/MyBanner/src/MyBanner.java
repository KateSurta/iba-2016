// пример апплета-"баннера"
import java.awt.*;
import java.applet.*;

// код для тега
/*
<applet code="MyBanner" width=300 height=50>
<param name=message value="Java makes the Web move!">
</applet>
*/

// сам апплет - обратите внимание на реализацию интерфейса Runnable
public class MyBanner extends Applet implements Runnable {
  // строка для отображения
  String msg;
  // поток для отображения
  Thread t = null;
  // состояние баннера
  int state;
  volatile boolean stopFlag;

  // инициализируем баннер
  public void init() {
    setBackground(Color.black);
    setForeground(Color.white);
  }

  // запуск баннера
  public void start() {
    msg = getParameter("message");
    if(msg == null) msg = "Java is da best";
    msg = " " + msg;
    // порождаем новый поток - и запускаем его
    t = new Thread(this);
    stopFlag = false;
    t.start();
  }

  // точка входа потока апплета
  public void run() {

    // перерисовываем строку в бесконечном цикле
    for( ; ; ) {
      try {
    	// вызов перерисовки баннера (т.е. самого себя)
        repaint();
        // ждем немного
        Thread.sleep(125);
        // проверяем флаг останова
        if(stopFlag)
          break;
      } catch(InterruptedException e) {}
    }
  }
  
  // приостановка баннера
  public void stop() {
	// выставляем флаг останова - поток приостанавливается
    stopFlag = true;
    // избавляемся от потока (при перезапуске породим себе еще)
    t = null;
  }

  // само отображение апплета
  public void paint(Graphics g) {
    char ch;

    // перерисовываем строку в цикле
    ch = msg.charAt(0);
    msg = msg.substring(1, msg.length());
    msg += ch;

    g.drawString(msg, 50, 30);
  }
}