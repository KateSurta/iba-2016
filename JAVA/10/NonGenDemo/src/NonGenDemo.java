// пример _неиспользования_ обобщений
// непараметрихзованный класс!
class NonGen {
  Object ob; // ob теперь просто Object

  // в конструктор тоже передаем Object
  NonGen(Object o) {
    ob = o;
  }

  // ...его же и возвращаем Object
  Object getob() {
    return ob;
  }

  // отображаем тип ob
  void showType() {
    System.out.println("Тип ob: " + ob.getClass().getName());
  }
}

// класс-демонстратор
class NonGenDemo {
public static void main(String args[]) {
 NonGen iOb;

 // создаем объект NonGen и помещаем туда Integer
 // автоупаковка работает, кстати
 iOb = new NonGen(88);

 // отображаем тип iOb.
 iOb.showType();

 // получаем значение iOb.
 // требуется ручное приведение типов!
 int v = (Integer) iOb.getob();
 System.out.println("Значение: " + v);

 System.out.println();

 // создаем другой объект NonGen 
 // и помещаем туда String
 NonGen strOb = new NonGen("Тест НеОбобщений");

 // отображаем тип strOb.
 strOb.showType();

 // отображаем значение strOb.
 // снова нужно ручное приведение типов! 
 String str = (String) strOb.getob();
 System.out.println("Значение: " + str);

 // компилируется - но семантически некорректно!
 iOb = strOb;
 v = (Integer) iOb.getob(); // и тут резонно получаем ошибку
}
}