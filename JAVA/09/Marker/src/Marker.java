import java.lang.annotation.*;
import java.lang.reflect.*;

// аннотация-маркер
@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker { }

class Marker {

  // аннотируем метод маркеров
  // скобки не нужны
  @MyMarker
  public static void myMeth() {
    Marker ob = new Marker();

    try {
      Method m = ob.getClass().getMethod("myMeth");

      // определяем наличие аннотации
      if(m.isAnnotationPresent(MyMarker.class))
        System.out.println("MyMarker в наличии");

    } catch (NoSuchMethodException exc) {
      System.out.println("Метод не найден");
    }
  }
 
  public static void main(String args[]) {
	    myMeth();
	  }
	}