// пример использования ссылки на конструктор

// MyFunc - ФИ, возвращающий ссылку на MyClass
interface MyFunc {
   MyClass func(int n);
}

// собственно конструируемый класс
class MyClass {
  // переменная-содержимое
  private int val;

  // конструктор с параметром
  MyClass(int v) { val = v; }

  // конструктор по умолчанию
  MyClass() { val = 0; }

  // извлечение значения
  int getVal() { return val; };
}

// демокласс
class CFRefDemo {
	  public static void main(String args[])
	  {
	    // создаем ссылку на конструктор MyClass
	    // (синтаксис указывался в лекции)
		// поскольку func() в ФИ MyFunc принимает аргумент,
	    // то в ссылку помещается указатель на параметризованный вариант
		// конструктора MyClass, а не на конструктор по умолчанию
	    MyFunc myClassCons = MyClass::new;

	    // создаем экземпляр MyClass через ссылку на конструктор
	    // ПАТТЕРН ПРОЕКТИРОВАНИЯ: ФАБРИКА КЛАССОВ
	    MyClass mc = myClassCons.func(100);

	    // проверяем, работает ли свежесозданный объект
	    System.out.println("Значение mc равно " + mc.getVal( ));
	  }
	}