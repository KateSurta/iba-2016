// пример использования встроенного ФИ Function

// прежде всего подключаем его 
import java.util.function.Function;


class FunctionDemo {
  public static void main(String args[])
  {
    // создаем конкретизированный экземпляр стандартного ФИ Function
	// и помещаем в его единственный метод блочное ЛВ с вычислением факториала числа
	// обратите внимание на типовую совместимость экземпляра ФИ и самого ЛВ
	// (Integer на входе, Integer на выходе)
    Function<Integer, Integer> factorial = (n) ->  {
      int result = 1;
      for(int i=1; i <= n; i++)
        result = i * result;
      return result;
    };
    // проверяем результат
    System.out.println("Факториал числа 5 равен " + factorial.apply(5));
  }
}