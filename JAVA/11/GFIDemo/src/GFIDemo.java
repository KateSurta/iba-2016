// пример использования ЛВ для обобщенных ФИ

// обобщенный ФИ
interface SomeFunc<T> {
  T func(T t);
}

// демокласс
class GFIDemo {
  public static void main(String args[])
  {

    // объявляем String-версию ФИ
	// и соответствующее ЛВ для него
    SomeFunc<String> reverse = (str) ->  {
      // переменные
      String result = "";
      int i;
      // инверсия
      for(i = str.length()-1; i >= 0; i--)
        result += str.charAt(i);
      // возвращаем СТРОКОВЫЙ результат
      return result;
    };
    System.out.println("Лямбда наоборот " + reverse.func("Лямбда"));

    
    // теперь объявляем Integer-версию ФИ
	// и соответствующее ЛВ для него
    SomeFunc<Integer> factorial = (n) ->  {
      // переменные
      int result = 1;
      // факториал
      for(int i=1; i <= n; i++)
        result = i * result;
      // возвращаем ЧИСЛОВОЙ результат
      return result;
    };

    System.out.println("Факториал 5 равен " + factorial.func(5));
  }
}