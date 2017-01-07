// пример использовани€ ссылки на конструктор обобщенного класса

// MyFunc стал обобщенным ‘»
interface MyFunc<T> {
   MyClass<T> func(T n);
}

// обобщенный создаваемый класс
class MyClass<T> {
  // теперь вместо обычного числа - внутри некий объект
  private T val;

  // конструктор с аргументом (обобщенный)
  MyClass(T v) { val = v; }

  // конструктор без аргументов
  MyClass( ) { val = null;  }

  // извлечение значени€ 
  // обратите внимание - везде один и тот же параметрированный тип!
  T getVal() { return val; };
}


// демокласс
class CGRefDemo {

  public static void main(String args[])
  {
    // создаем ссылку на конструктор конкретизированного экземпл€ра обобщенного ‘» MyClass<T>
    MyFunc<Integer> myClassCons = MyClass<Integer>::new;

    // создаем экземпл€р MyClass<T>, использу€ ссылку на конструктор
    MyClass<Integer> mc = myClassCons.func(100);

    // провер€ем - все ли сработало
    System.out.println("«начение mc равно " + mc.getVal( ));
  }
}