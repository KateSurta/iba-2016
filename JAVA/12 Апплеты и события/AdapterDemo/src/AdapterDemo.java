// пример использовани€ адаптеров
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

// тег-оболочка
/*
  <applet code="AdapterDemo" width=300 height=100>
  </applet>
*/

// сам адаптер
public class AdapterDemo extends Applet {
  public void init() {
	// добавл€ем в качестве приемников два класса собаственной разработки
	// причем при создании передаем им ссылку на объект-источник
    addMouseListener(new MyMouseAdapter(this));
    addMouseMotionListener(new MyMouseMotionAdapter(this));
  }
}

// класс дл€ работы с кнопками мыши
class MyMouseAdapter extends MouseAdapter {
	  // сохран€ем в приемнике объект источника - чтобы обращатьс€ к его методам
	  AdapterDemo adapterDemo;
	  public MyMouseAdapter(AdapterDemo adapterDemo) {
	    this.adapterDemo = adapterDemo;
	  }

	  // обработка нажатий мыши
	  public void mouseClicked(MouseEvent me) {
	    adapterDemo.showStatus("Ќажата кнопка мыши!");
	  }
	}

	// аналогично - с обработкой движени€ мыши 
	class MyMouseMotionAdapter extends MouseMotionAdapter {
	  AdapterDemo adapterDemo;
	  public MyMouseMotionAdapter(AdapterDemo adapterDemo) {
	    this.adapterDemo = adapterDemo;
	  }

	  // обработка перетаскивани€
	  public void mouseDragged(MouseEvent me) {
	    adapterDemo.showStatus("ћышь тащитс€!");
	  }
	}