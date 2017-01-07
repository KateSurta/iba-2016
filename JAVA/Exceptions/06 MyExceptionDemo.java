 // пример собственного исплючения
 class MyException extends Exception {
	  private int detail;

	  MyException(int a) {
	    detail = a;
	  }

	  public String toString() {
	    return "MyException[" + detail + "]";
	  }
	}

 public class MyExceptionDemo {
	  static void compute(int a) throws MyException {
	    System.out.println("Вызов compute(" + a + ")");
	    if(a > 10)
	      throw new MyException(a); // генерация собственного исключения
	    System.out.println("Корректное завершение");
	  }

	  public static void main(String args[]) {
	    try {
	      compute(1);
	      compute(20);
	    } catch (MyException e) {
	      System.out.println("Перехвачено: " + e);
	    }
	  }
	}