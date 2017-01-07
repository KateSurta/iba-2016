// пример использования внутреннего класса
import java.applet.*;
import java.awt.event.*;
/*
  <applet code="InnerClassDemo" width=200 height=100>
  </applet>
*/

public class Exec2 extends Applet {
  public void init() {
    addMouseListener(new MyMouseAdapter());
  }
  // адаптер реализован как внутренний класс - это делает структуру проще
  class MyMouseAdapter extends MouseAdapter {
    public void mousePressed(MouseEvent me) {
      // внутренний класс имеет доступ ко всем членам класса-оболочки!
      showStatus("Mouse Pressed");
    }
  }
}