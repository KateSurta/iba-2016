// пример вложенных операторов try
public class NestedTries {
  public static void main(String args[]) {
    try {
      // определяем число аргументов
      int a = args.length;

      // если их нет - делим на ноль
      int b = 42 / a;

       System.out.println("a = " + a);

       try { // вложенный try
        // если один аргумент есть - то делим на ноль во вложенном блоке
        if(a==1) a = a/(a-a); // division by zero

        // если аргументов два - выходим за рамки массива
        if(a==2) {
           int c[] = { 1 };
           c[42] = 99; 
        }
      } catch(ArrayIndexOutOfBoundsException e) {
        System.out.println("Выход за границы массива: " + e);
      }
    } catch(ArithmeticException e) {
      System.out.println("Деление на 0: " + e);
    }
  }
}