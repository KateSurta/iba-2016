// пример смешанной иерархии:
// необобщенный родитель и обобщенный потомок

// необобщенный родитель
class NonGen {
  int num; //единственная переменная

  // конструктор
  NonGen(int i) {
    num = i;
  }
 // вывод содержимого
  int getnum() {
    return num;
  }
}

// обобщенны потомок
class Gen<T> extends NonGen {
  T ob; // переменная типа T

  // передаем в конструктор и T (для потомка),
  // и число (для родителя)
  Gen(T o, int i) {
	// число родителю
    super(i);
    // второй параметр - потомку
    ob = o;
  }

  // возвращаем содержимое потомка
  T getob() {
    return ob;
  }
}

// демокласс
class SubGen2 {
public static void main(String args[]) {
 // создаем объект Gen для String
 Gen<String> w = new Gen<String>("Привет, мир", 47);
 // выводим его содержимое
 System.out.print(w.getob() + " ");
 System.out.println(w.getnum());
}
}

