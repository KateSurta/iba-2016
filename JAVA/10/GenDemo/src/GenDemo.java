// пример обобщений
// T - это параметр типа, который замещается реальным типом
// при создании объекта класса Gen
class Gen<T> {
  T ob; // объект некоего типа T

  // передаем конструктору ссылку на объект
  // класса T.
  Gen(T o) {
    ob = o;
  }

  // возвращаем ob.
  T getob() {
    return ob;
  }

  // отображаем тип T. 
  void showType() {
	    System.out.println("Тип T: " + ob.getClass().getName());
	  }
	}

	// класс-демонстратор
	class GenDemo {
	  public static void main(String args[]) {
	    // объявляем переменную класса Gen для хранения Integer.
	    Gen<Integer> iOb;

	    // создаем объект Gen<Integer> и помещаем ссылку на него в 
	    // переменную iOb (обратите внимание на использование еще и автоупаковки)
	    iOb = new Gen<Integer>(88);

	    // отображаем тип iOb.
	    iOb.showType();

	    // получаем значение iOb 
	    //  (обратите внимание - ручные преобразования не производятся)
	    int v = iOb.getob();
	    System.out.println("Значение: " + v);

	    System.out.println();

	    // создаем Gen-объект для хранения String.
	    Gen<String> strOb = new Gen<String> ("Тест обобщений");

	    // отображаем тип strOb.
	    strOb.showType();

	    // получаем и отображаем значение strOb
	    // (опять же, нет ручного преобразования типов)
	    String str = strOb.getob();
	    System.out.println("Значение: " + str);
	  }
	}