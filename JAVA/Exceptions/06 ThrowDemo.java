// пример "ручной" генерации исключений
public class ThrowDemo {
  static void demoproc() {
    try {
      // собственно генерация объекта исключения
      throw new NullPointerException("Пример!");
    } catch(NullPointerException e) {
      System.out.println("Перехват исключения.");
      throw e; // отправка исключения дальше - внешнему обработчику
    }
  }

  public static void main(String args[]) {
    try {
      // где-то там создается и пересылается исключение
      demoproc();
    } catch(NullPointerException e) {
      System.out.println("Повторный перехват: " + e);
    }
  }
}