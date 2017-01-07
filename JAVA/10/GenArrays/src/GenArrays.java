// пример использования обобщений в массивах
class Gen<T extends Number> {
  // переменные - объект и массив объектов 
  T ob; 	// все ОК
  T vals[]; // компилятор пропустит

  Gen(T o, T[] nums) {
    ob = o;

    // vals = new T[10]; // нельзя создать массив T

    vals = nums; // а так можно - помещаем туда реальный массив
  }
}

// демокласс
class GenArrays {
	  public static void main(String args[]) {
		// создаем массив 
	    Integer n[] = { 1, 2, 3, 4, 5 };
	    // создаем объект Gen (помещаем туда число и массив)
	    Gen<Integer> iOb = new Gen<Integer>(50, n);

	    // Gen<Integer> gens[] = new Gen<Integer>[10]; // не сработает!

	    // а это ОК
	    Gen<?> gens[] = new Gen<?>[10];
	  }
	}