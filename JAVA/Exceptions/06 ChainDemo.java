// Пример цепочки исключений
public class ChainDemo {
  static void demoproc() {

    // создаем исключение
    NullPointerException e = new NullPointerException("Следствие");

    // и указываем его причину
    e.initCause(new ArithmeticException("Причина"));

    throw e;
  }
  public static void main(String args[]) {
	    try {
	      demoproc();
	    } catch(NullPointerException e) {
	      // Отображаем исключение-следствие
	      System.out.println("Перехвачено: " + e);

	      // ...и его причину
	      System.out.println("Причина: " + e.getCause());
	    }
	  }
	}