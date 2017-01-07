// демонстрация отображения всех доступных аннотаций
// подключаем пакеты
import java.lang.annotation.*;
import java.lang.reflect.*;

// определяем аннотацию первого типа
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
  String str();
  int val();
}

// определяем аннотацию второго типа
@Retention(RetentionPolicy.RUNTIME)
@interface What {
  String description();
}

@What(description = "Класс для тестирования аннотаций")
@MyAnno(str = "Meta2", val = 99)
class Meta2 {


  @What(description = "Метод для тестирования аннотаций")
  @MyAnno(str = "Testing", val = 100)
  public static void myMeth() {
    Meta2 ob = new Meta2();

    try {
    	// получаем массив аннотаций текущего класса
        Annotation annos[] = ob.getClass().getAnnotations();

        // отображаем список аннотаций класса Meta2.
        System.out.println("Аннотации Meta2:");
        for(Annotation a : annos)
          System.out.println(a);

        System.out.println();

        // получаем объект метода myMeth и его аннотации 
        Method m = ob.getClass( ).getMethod("myMeth");
        annos = m.getAnnotations();
        
        // отображаем аннотации метода myMeth
        System.out.println("Аннотации myMeth:");
        for(Annotation a : annos)
          System.out.println(a);

      } catch (NoSuchMethodException exc) {
         System.out.println("Метод не найден.");
      }
    }

    public static void main(String args[]) {
      myMeth();
    }
  }