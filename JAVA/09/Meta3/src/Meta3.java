import java.lang.annotation.*;
import java.lang.reflect.*;

// пример аннотации со значениями по умолчанию
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
  String str() default "Тестирование";
  int val() default 9000;
}

class Meta3 {

  // аннотируем метод значениями по умолчанию
  @MyAnno()
  public static void myMeth() {
    Meta3 ob = new Meta3();

    // получаем аннотацию и отображаем ее поля
    try {
      Class<?> c = ob.getClass();
      Method m = c.getMethod("myMeth");

      MyAnno anno = m.getAnnotation(MyAnno.class);

      System.out.println(anno.str() + " " + anno.val());
    } catch (NoSuchMethodException exc) {
       System.out.println("Метод не найден");
    }
  }

  public static void main(String args[]) {
    myMeth();
  }
}