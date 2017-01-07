// пример блочных ЛВ

// ФИ int->int
interface NumericFunc {
  int func(int n);
}

// ФИ String->String
interface StringFunc {
	  String func(String n);
	}

// демокласс
class BlockLambdaDemo {
  public static void main(String args[])
  {

    // блочное ЛВ, вычисляющее факториал полученного параметра
    NumericFunc factorial = (n) ->  {
      // объявляем переменную
      int result = 1;
      // вычисляем факториал в цикле
      for(int i=1; i <= n; i++)
        result = i * result;
      // возвращаем результат
      return result;
    };
    // собственно вызовы метода (и, соответственно, блочного ЛВ)
    System.out.println("Факториал 3 равен " + factorial.func(3));
    System.out.println("Факториал 5 равен " + factorial.func(5));
    
    
    // строчное выражение - инвертируем строку
    StringFunc reverse = (str) ->  {
      // переменные
      String result = "";
      int i;
      // собственно инвертирование
      for(i = str.length()-1; i >= 0; i--)
        result += str.charAt(i);
      // возвращаем результат
      return result;
    };
    // вызываем метод
    System.out.println("Лямбда наоборот - " + reverse.func("Лямбда"));
    System.out.println("Аргентина манит негра наоборот - " + reverse.func("Аргентина манит негра"));
   }
}