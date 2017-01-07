// пример апплета для загрузки изображений

// тег-оболочка
/*
 * <applet code="SimpleImageLoad" width=600 height=600>
 *   * </applet>
 */
import java.awt.*;
import java.applet.*;

// сам апплет
public class ImageLoader extends Applet
{
  // объект для работы с изображением
  Image img;

  public void init() {
	// загрузка изображения из файла
    img = getImage(getDocumentBase(), "java.jpg");
	}

  public void paint(Graphics g) {
	  // 
	  if (img == null) 
		  g.drawString("No image!", 20, 20);
	  else
		  g.drawImage(img, 0, 0, this);
  }
}