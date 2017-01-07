// пример обработки событий от клавиатуры
import java.awt.*;
import java.awt.event.*; 
import java.applet.*;

// тег-оболочка
/*
  <applet code="SimpleKey" width=300 height=100>
  </applet>
*/

public class KBEvents extends Applet
  implements KeyListener {

  String msg = "";
  int X = 10, Y = 20; // координаты для вывода строки

  public void init() {
	// подключаем в качестве обработчика событий клавиатуры самого себя
    addKeyListener(this);
  }

  // кнопка прижата
  public void keyPressed(KeyEvent ke) {
    showStatus("Кнопка прижата!");
    // извлекаем модификатор (вдруг не букву нажали)
    int key = ke.getKeyCode();
    switch(key) {
      case KeyEvent.VK_F1:
        msg += "<F1>";
        break;
      case KeyEvent.VK_F2:
        msg += "<F2>";
        break;
      case KeyEvent.VK_F3:
        msg += "<F3>";
        break;
      case KeyEvent.VK_PAGE_DOWN:
        msg += "<PgDn>";
        break;
      case KeyEvent.VK_PAGE_UP:
        msg += "<PgUp>";
        break;
      case KeyEvent.VK_LEFT:
        msg += "<Стрелка влево>";
        break;
      case KeyEvent.VK_RIGHT:
        msg += "<Стрелка вправо>";
        break;
    }
    repaint();
  }

  // кнопка отпущена
  public void keyReleased(KeyEvent ke) {
    showStatus("Кнопка отпущена!");
  }


  // ввели букву
  public void keyTyped(KeyEvent ke) {
    msg += ke.getKeyChar();
    repaint();
  }

  // отображаем накопленное
  public void paint(Graphics g) {
    g.drawString(msg, X, Y);
  }
}