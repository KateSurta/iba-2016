// пример использования анонимного внутреннего класса 
import java.applet.*;
import java.awt.event.*;
/*
  <applet code="AnonymousInnerClassDemo" width=200 height=100>
  </applet>
*/

public class Exec3 extends Applet {
  public void init() {
	// добавляем в качестве приемника объект анонимного внутреннего класса - еще проще
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent me) {
        showStatus("Мышь нажата!");
      }
    });
  }
}