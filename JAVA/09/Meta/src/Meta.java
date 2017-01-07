// подключаем пакеты дл€ работы аннотаций и рефлексии
import java.lang.annotation.*;
import java.lang.reflect.*;

// объ€вл€ем свой тип аннотации
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
  String strName(); // название метода
  String strAuthor(); // автор
  int val(); // трудоемкость разработки в часах
}

// изучаемый демо-класс
class Meta {

  // аннотируем метод
  @MyAnno(strName = "ћетод myMeth", strAuthor = "¬италий јгашков", val = 8) 
  public static void myMeth() {
	    Meta ob = new Meta();

	    // получаем аннотацию метода
	    try {
	      // получаем объект типа Class, описывающий текущий класс
	      Class<?> c = ob.getClass();

	      // получаем объект класса Method дл€ метода myMeth()
	      Method m = c.getMethod("myMeth");

	      // получаем аннотацию метода и определ€ем ее тип
	      MyAnno anno = m.getAnnotation(MyAnno.class);

	      // отображаем содержимое аннотации
	      System.out.println(anno.strName() + " " + anno.strAuthor() + " " + anno.val());
	    } catch (NoSuchMethodException exc) {
	      System.out.println("ћетод не найден");
	    }
	  }

  public static void main(String args[]) {
	    myMeth();
	  }
	}