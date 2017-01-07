// пример обобщенного интерфейса

// интерфейс Min/Max - ищет минимальный и максимальный элементы в массиве
// обратите внимание, что элементы массива должны наследоваться от Comparable - 
// для поддержки метода equals()
interface MinMax<T extends Comparable<T>> {
  T min();
  T max();
}

// реализуем интерфейс
class MyClass<T extends Comparable<T>> implements MinMax<T> {  
  // обрабатываемый массив объектов
  T[] vals;
  // конструктор
  MyClass(T[] o) { vals = o; }

  // поиск минимального значение
  public T min() {
    T v = vals[0];

    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) < 0) v = vals[i];

    // выводим минимум
    return v;
  }

  // поиск максимального значения
  public T max() {
    T v = vals[0];

    for(int i=1; i < vals.length; i++)
      if(vals[i].compareTo(v) > 0) v = vals[i];
    // выводим максимум
    return v;
  }
}

// демокласс
class GenIFDemo {
  public static void main(String args[]) {
	// создаем два массива разных типов
    Integer inums[] = {3, 6, 2, 8, 6 };
    Character chs[] = {'b', 'r', 'p', 'w' };

    // помещаем их в объекты с помощью обобщенных конструкторов
    MyClass<Integer> iob = new MyClass<Integer>(inums);
    MyClass<Character> cob = new MyClass<Character>(chs);

    // ищем минимальное и максимальное значения среди целых чисел
    System.out.println("Max value in inums: " + iob.max());
    System.out.println("Min value in inums: " + iob.min());
 // ищем минимальное и максимальное значения среди символов
    System.out.println("Max value in chs: " + cob.max());
    System.out.println("Min value in chs: " + cob.min());
  }
}