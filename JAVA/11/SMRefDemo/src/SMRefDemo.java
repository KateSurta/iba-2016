// пример ссылки на статический метод

// ФИ для операций со строками
interface StringFunc {
  String func(String n);
}

// класс, чьи методы мы будем вызывать
class MyStringOps {
  // статический метод, выполняющий инверсию строки
  static String strReverse(String str) {
      String result = ""; 
      int i;

      for(i = str.length()-1; i >= 0; i--)
        result += str.charAt(i);

      return result;
  }
  
  // метод экземпляра (приводит строку к верхнему регистру)
  String strUp(String str) {
      String result = ""; 
      result = str.toUpperCase();

      return result;
  }
}

// демокласс
class SMRefDemo {

  // метод принимает ФИ как первый параметр
  // соответственно, ему можно передать любой экземпляр ФИ,
  // включая ссылку на метод
  // второй параметр - обрабатываемая строка
  static String stringOp(StringFunc sf, String s) {
    return sf.func(s);
  }

  public static void main(String args[])
  {
    String inStr = "Лямбда-выражения это сила";
    String outStr;

    // вызываем метод stringOp, передавая ему ссылку на статический метод и саму строку для обработки
    outStr = stringOp(MyStringOps::strReverse, inStr);

    System.out.println("Вызываем статический метод (инверсия)");
    System.out.println("Было: " + inStr);
    System.out.println("Стало: " + outStr);
    System.out.println();
    

    // теперь создаем экземпляр MyStringOps
    MyStringOps strOps = new MyStringOps( );
    // и передаем методу stringOp() ссылку на метод этого экземпляра
    outStr = stringOp(strOps::strUp, inStr);
    
    System.out.println("Вызываем метод экземпляра (регистр)");
    System.out.println("Было: " + inStr);
    System.out.println("Стало: " + outStr);
    System.out.println();
    
  }
}