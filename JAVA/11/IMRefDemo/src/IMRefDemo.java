// пример использования ссылки на метод экземпляра с разными объектами

// ФИ, принимающий две ссылки и возвращающий boolean
interface MyFunc<T> {
  boolean func(T v1, T v2);
}

// класс для хранения максимальной температуры за день
class HighTemp {
  // собственно переменная с температуров
  private int hTemp;
  // простой конструктор
  HighTemp(int ht) { hTemp = ht; }
  // возвращаем true, если вызывающий объект имеет ту же температуру, что и ht2.
  boolean sameTemp(HighTemp ht2) {
    return hTemp == ht2.hTemp;
  }
  //   // возвращаем true, если вызывающий объект имеет меньшую, чем у ht2.
  boolean lessThanTemp(HighTemp ht2) {
    return hTemp < ht2.hTemp;
  }
}

// демокласс
class IMRefDemo {

	  // метод возвращает число объектов, подходящих под критерий, 
	  // задаваемый параметров ФИ MyFunc
	  // параметры:
	  // T[] vals - массив объектов для обработки
	  // MyFunc<T> f - метод определения "годности"
	  // T v - эталонный объект для сравнения
	  // возвращаемое значение - число
	  static <T> int counter(T[] vals, MyFunc<T> f, T v) { 
		    int count = 0;
		    // проходим по всему массиву
		    for(int i=0; i < vals.length; i++)
		      // если текущий объект "подходит", прибавляем счетчик
		      if(f.func(vals[i], v)) count++;
		    // возвращаем результат
		    return count;
		  }

		  public static void main(String args[])
		  {
		    int count;

		    // создаем массив объектов HighTemp (в скобках - температуры)
		    HighTemp[] weekDayHighs = { new HighTemp(25), new HighTemp(23),
		                                new HighTemp(29), new HighTemp(25),
		                                new HighTemp(27), new HighTemp(30),
		                                new HighTemp(24), new HighTemp(27) };

		    // считаем число объектов, чья температура _совпадает_ (HighTemp::sameTemp)
		    // с температурой эталонного объекта (HighTemp(25))
		    count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(25));
		    System.out.println(count + " дней имело температуру 25 градусов");


		    // теперь используем ссылку на метод lessThanTemp(), чтобы 
		    // найти дни с температурой меньше определенного значения
		    count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(27));
		    System.out.println(count + " дней имело температуру менее 27 градусов");

		    
	  }
}