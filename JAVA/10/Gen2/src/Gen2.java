// пример иерархии обобщений

// обобщенный суперкласс
class Gen<T> {
  T ob; // внутренняя переменная T

  // простой конструктор 
  Gen(T o) {
	    ob = o;
	  }

  // вывод содержимого
	  T getob() {
	    return ob;
	  }
	}


// обобщенный подкласс
	class SubGen<T, V> extends Gen<T> {
	  // добавляем еще одну переменную
	  V ob2;

	  // обратите внимание: конструктор получает _два_ аргумента типа
	   SubGen(T o, V o2) {
		// один передается родителю
	    super(o);
	    // второй обрабатываем сами
	    ob2 = o2;
	  }

	  // метод для вывода новой переменной
	  V getob2() {
	    return ob2;
	  }
	}

	// демокласс
	class Gen2 {
	  public static void main(String args[]) {

	    // создаем объект SubGen для параметров String и Integer.
	    SubGen<String, Integer> x =   new SubGen<String, Integer>("Значение равно: ", 99);
	    // выводим содержимое
	    System.out.print(x.getob());
	    System.out.println(x.getob2());
	  }
	}