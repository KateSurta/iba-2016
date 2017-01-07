// пример "промышленной" фабрики классов, использующей ссылки на конструкторы

// ФИ - получает на вход один объект и возвращает другой
interface MyFunc<R, T> {
   R func(T n);
}

// простой обобщенный класс
class MyClass<T> {
  // внутри - объект-"содержимое"
  private T val;

  // конструктор с аргументом
  MyClass(T v) { val = v; }
 
  // конструктор без аргумента (его мы не используем - нет смысла)
  MyClass() { val = null; }

  // извлекаем содержимое
  T getVal() { return val; };
}


// простой необобщенный класс
class MyClass2 {
  // внутри - строка
  String  str;

  // конструктор с параметром
  MyClass2(String s) { str = s; }

  // конструктор без аргумента (его мы не используем - нет смысла)
  MyClass2() { str = ""; }

  // извлекаем содержимое
  String getVal() { return str; };
}


class ClassFactoryDemo {

	  // вот и сам метод создания объектов ("фабрика")
	  // у класса создаваемого объекта конструктор должен принимать объект в качестве параметра (T)
	  // R определяет, объект какого типа мы хотим создать
	  static <R,T> R myClassFactory(MyFunc<R, T> cons, T v) {
	    return cons.func(v);
	  }

	  public static void main(String args[])
	  {
	    // создаем ссылку на конструктор MyClass (тот, который с параметром)
	    MyFunc<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;
	    // создаем объект MyClass с помощью "фабрики" и аргумента для конструктора
	    MyClass<Double> mc = myClassFactory(myClassCons, 100.1);
	    // проверяем результат
	    System.out.println("Значение mc равно " + mc.getVal( ));

	    // создаем еще одну ссылку на конструктор (теперь класса MyClass2)
	    MyFunc<MyClass2, String> myClassCons2 = MyClass2::new;
	    // создаем с помощью новой "фабрики" объект
	    MyClass2 mc2 = myClassFactory(myClassCons2, "Я строка");
	    // и проверяем результат
	    System.out.println("Значение mc2 равно " + mc2.getVal( ));
	  }
	}