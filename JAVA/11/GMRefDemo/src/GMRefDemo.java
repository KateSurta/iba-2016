// пример использования ссылки на обобщенный метод,
// объявленный в необобщенном классе

// ФИ, получающий на вход массив неких объектов и отдельный объект,
// и возвращающий целое число
interface MyFunc<T> {
  int func(T[] vals, T v);
}

// Обобщенный метод countMatching() возвращает число элементов массива,
// равных заданной величине (т.н. "универсальный компаратор")
class MyArrayOps {
  static <T> int countMatching(T[] vals, T v) {
    // счетчик совпадений
	int count = 0;
    // обход массива
    for(int i=0; i < vals.length; i++)
      if(vals[i] == v) count++;
    // возвращаем результат
    return count;
  }
}

// демокласс
class GMRefDemo {

	  // метод myOp имеет три параметра:
	  // - ФИ (который должен содержить саму логику)
	  // - массив неких объектов (данные для обработки)
	  // - еще один (эталонный) объект _того_же_ типа
	  static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
	    return f.func(vals, v);
	  }

	  public static void main(String args[])
	  {
		// объявляем два массива объектов разного типа
	    Integer[] vals = { 1, 2, 3, 4, 2, 3, 4, 4, 5 };
	    String[] strs = { "Москва", "Берлин", "Париж", "Токио" };
	    int count;

	    // применяем метод myOp к массву Integer, при это конкретизируя экземпляр ФИ
	    count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
	    System.out.println("vals содержит " + count + " значений 4");

	    // применяем метод myOp к массву Integer, при это конкретизируя экземпляр ФИ
	    count = myOp(MyArrayOps::<String>countMatching, strs, "Берлин");
	    System.out.println("strs содержит " + count + " значений Берлин");
	  }
	}