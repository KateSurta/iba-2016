// Пример использования оператора instanceof для иерархии обобщенных классов

// базовый обобщенный класс
class Gen<T> {
  // переменная
  T ob;
  // конструктор
  Gen(T o) {
    ob = o;
  }
  // вывод переменной
  T getob() {
    return ob;
  }
}

// обобщенный подкласс
class Gen2<T> extends Gen<T> {
  Gen2(T o) {
    super(o);
  }
}

// демокласс
class InstaDemo {
public static void main(String args[]) {

 // создаем Gen-объект для Integer
 Gen<Integer> iOb = new Gen<Integer>(88);

 // создаем Gen2-объект для Integer
 Gen2<Integer> iOb2 = new Gen2<Integer>(99);

 // создаем Gen2-объект для Strings.
 Gen2<String> strOb2 = new Gen2<String>("Тест обобщений");

 // провверяем, является ли iOb2 объектом Gen2
 if(iOb2 instanceof Gen2<?>)
   System.out.println("iOb2 - экземпляр Gen2");
 // а экземпляром Gen?
 if(iOb2 instanceof Gen<?>)
   System.out.println("iOb2 - экземпляр Gen");

 System.out.println();

 // strOb2 - объект Gen2?
 if(strOb2 instanceof Gen2<?>)
   System.out.println("strOb2 - экземпляр Gen2");
 // а экземпляром Gen?
 if(strOb2 instanceof Gen<?>)
   System.out.println("strOb2 - экземпляр Gen");

 System.out.println();

 // iOb - экземпляр Gen2? (на самом деле нет)
 if(iOb instanceof Gen2<?>)
   System.out.println("iOb - экземпляр Gen2");
 // а Gen? (да)
 if(iOb instanceof Gen<?>)
   System.out.println("iOb - экземпляр Gen");

 // компилятор не пропустит - т.к.
 // обобщение конкретизируется на этапе исполнения
 // if(iOb2 instanceof Gen2<Integer>)
 //   System.out.println("iOb2 - экземпляр Gen2<Integer>");
}
}