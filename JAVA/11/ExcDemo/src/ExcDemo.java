// пример генерирования исключений в ЛВ

// объявляем ФИ
interface ArrayFunc {
  // обратите внимание на указание возможных исключений
  double func(double[] n) throws EmptyArrayException;
}

// объявляем класс генерируемого исключения
class EmptyArrayException extends Exception {
  EmptyArrayException() {
    super("Массив пуст");
  }
}

// демокласс
class ExcDemo {

  public static void main(String args[]) throws EmptyArrayException
  {
	// массив для обработки
    double[] values  = { 1.0, 2.0, 3.0, 4.0 };

    // создаем ссылку на экземпляр ФИ
    // и помещаем в нее блочное ЛВ для вычисления среднего значения массива
    ArrayFunc average = (n) ->  {
      double sum = 0;

      // если массив пуст - генерируем исключение
      // оно должно быть совместимо с объявлением метода в ФИ!
      if(n.length == 0)
        throw new EmptyArrayException();
      // если все в порядке - считаем и возвращаем результат
      for(int i=0; i < n.length; i++)
        sum += n[i];
      return sum / n.length;
    };

    // вызываем метод (и, соответствнно, ЛВ)
    System.out.println("Среднее равно: " + average.func(values));

    // теперь проверяем, генерируется ли исключение, вызывая метод для пустого массива
    System.out.println("Среднее равно: " + average.func(new double[0]));
  }
}