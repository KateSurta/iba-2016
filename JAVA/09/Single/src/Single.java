import java.lang.annotation.*;
import java.lang.reflect.*;

// одночленная аннотация
@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
  int value(); // единственное поле с обязательным названием value
}

class Single {

  // аннотируем метод
  @MySingle(100)
  public static void myMeth() {
    Single ob = new Single();

    try {
      Method m = ob.getClass().getMethod("myMeth");

      MySingle anno = m.getAnnotation(MySingle.class);

      System.out.println(anno.value()); // отображает 100

    } catch (NoSuchMethodException exc) {
       System.out.println("Метод не найден");
    }
  }
 
  public static void main(String args[]) {
	    myMeth();
	  }
	}