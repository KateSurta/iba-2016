// пример обобщенного класса с двумя параметрами типа
class Gen2<T, V> {
  T ob1;
  V ob2;

  // передаем в конструктор один объект типа T
  // и один - типа V.
  Gen2(T o1, V o2) {
    ob1 = o1;
    ob2 = o2;
  }

  // отображаем типы T и V.
  void showTypes() {
    System.out.println("Тип T: " + ob1.getClass().getName());

    System.out.println("Тип V: " + ob2.getClass().getName());
  }

  
  T getob1() {
    return ob1;
  }

  V getob2() {
	    return ob2;
  }
}

	// демокласс
	class TwoGen {
	  public static void main(String args[]) {

		// создаем объект параметризованного класса
	    Gen2<Integer, String> tgObj = new Gen2<Integer, String>(88, "обобщения");

	    // отображаем типы
	    tgObj.showTypes();

	    // извлекаем и отображаем значения
	    int v = tgObj.getob1();
	    System.out.println("значение 1: " + v);

	    String str = tgObj.getob2();
	    System.out.println("значение 2: " + str);
	  }
	}