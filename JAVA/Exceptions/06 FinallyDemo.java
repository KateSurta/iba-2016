// Пример использования finally
public class FinallyDemo {
  // Генерируем исключение в методе
  static void procA() {
    try {
      System.out.println("Метод procA");
      throw new RuntimeException("Пример");
    } finally {
      System.out.println("finally метода procA");
    }
  }

  // выполняем возврат из блока try
  static void procB() {
    try {
      System.out.println("Метод procB");
      return;
    } finally {
      System.out.println("finally метода procB");
    }
  }

  // нормаольное исполнение
  static void procC() {
    try {
      System.out.println("Метод procC");
    } finally {
      System.out.println("finally метода procC");
    }
  }

  public static void main(String args[]) {
	    try {
	      // первый сценарий
	      procA();
	    } catch (Exception e) {
	      System.out.println("Исключение перехвачено");
	    }
	    // второй сценарий
	    procB();
	    // третий сценарий
	    procC();
	  }
	}