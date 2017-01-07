// обработка событий от мыши
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// тег-оболочка
/*
  <applet code="MouseEvents" width=300 height=100>
  </applet>
*/

// класс реализует сразу два "мышиных" интерфейса
public class MouseEvents extends Applet
  implements MouseListener, MouseMotionListener {

  String msg = "";
  int mouseX = 0, mouseY = 0; // координаты точки нажатия

  // регистрируем "два приемника"
  // (если точно - то самого себя как обработчика двух видов собственных событий)
  // обрабатывать события самостоятельно - нормальная практика
  public void init() {
    addMouseListener(this);
    addMouseMotionListener(this);
  }


  // обработка клика кнопки мыши
  public void mouseClicked(MouseEvent me) {
	// порядок обработки событий идентичен:
    // запоминаем координаты
    mouseX = 0;
    mouseY = 10;
    // формируем строку с сописанием события
    msg = "Нажата мышь!";
    // и перерисовываем апплет
    repaint();
  }

  // курсор зашел в область окна апплета
  public void mouseEntered(MouseEvent me) {
    mouseX = 0;
    mouseY = 10;
    msg = "Пришла мышь!";
    repaint();
  }

  // курсор выведен из области окна апплета 
  public void mouseExited(MouseEvent me) {
	    mouseX = 0;
	    mouseY = 10;
	    msg = "Ушла мышь!";
	    repaint();
	  }

	  // кнопка мыши нажата
	  public void mousePressed(MouseEvent me) {
	    mouseX = me.getX();
	    mouseY = me.getY();
	    msg = "Кнопка мыши нажата!";
	    repaint();
	  }

	  // кнопка мыши отпущена
	  public void mouseReleased(MouseEvent me) {
	    mouseX = me.getX();
	    mouseY = me.getY();
	    msg = "Кнопка мыши отпущена!";
	    repaint();
	  }

	  // "перетаскивание"
	  public void mouseDragged(MouseEvent me) {
	    mouseX = me.getX();
	    mouseY = me.getY();
	    msg = "*";
	    // пишем все в строку состояния
	    showStatus("Перетаскивание в точке " + mouseX + ", " + mouseY);
	    repaint();
	  }

	  // просто перемещение мыши
	  public void mouseMoved(MouseEvent me) {
		// пишем все в строку состояния
	    showStatus("Движение мыши в точке " + me.getX() + ", " + me.getY());
	  }

	  // собственно перерисовка апплета - отображение строки с комментариями событий
	  public void paint(Graphics g) {
	    g.drawString(msg, mouseX, mouseY);
	  }
	}