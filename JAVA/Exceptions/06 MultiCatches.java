// пример один try - много catch
public class MultiCatches {
  public static void main(String args[]) {
    try {
      // переменная а (число аргументов) - потенциальный источник ошибки
      int a = args.length;
      System.out.println("a = " + a);
      // тут мы делим на нуль, если программа запущена без аргументов
      int b = 42 / a;
      // а тут выходим за границы массива
      int c[] = { 1 };
      c[42] = 99;
    } catch(ArithmeticException e) { // перехват "арифметического" исключения
      System.out.println("Деление на 0: " + e);
    } catch(ArrayIndexOutOfBoundsException e) { // перехват "граничного" исключения
      System.out.println("Выход за границы массива: " + e);
    }
    System.out.println("Блок после try/catch. Исполняется при правильной обработке исключений");
  }
}