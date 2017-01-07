// пример переопределения методов в обобщенных классах

// родительский класс
class Gen<T> {
  T ob; // переменная типа T

  // конструктор
  Gen(T o) {
    ob = o;
  }

  // вывод значения ob.
  T getob() {
    System.out.print("Метод getob() класса Gen: " );
    return ob;
  }
}

// подкласс
class Gen2<T> extends Gen<T> {
// конструктор
Gen2(T o) {
 super(o);
}
// переопределяем метод родительского класса
// Override getob().
T getob() {
	System.out.print("Метод getob() класса Gen2: " );
 return ob;
}
}

// демокласс
class Override {
public static void main(String args[]) {

 // создаем Gen-объект для Integer
 Gen<Integer> iOb = new Gen<Integer>(88);

 // создаем Gen2-объект для Integer
 Gen2<Integer> iOb2 = new Gen2<Integer>(99);

 // создаем Gen2-объект для String
 Gen2<String> strOb2 = new Gen2<String> ("Тест обобщений");

 // вызываем методы обоих классов
 System.out.println(iOb.getob());
 System.out.println(iOb2.getob());
 System.out.println(strOb2.getob());
}
}