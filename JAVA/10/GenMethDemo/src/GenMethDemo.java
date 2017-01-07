// пример обобщенного метода
class GenMethDemo {

  // обобщенный метод - определяем, содержится ли объект T в массиве V
  // внимание: тип объекта должен быть совместим с типом объектов массива
  // обратите внимание на объявление:
  // static - уже знакомый модификатор
  // <T extends Comparable<T>, V extends T> - параметр типа 
  // (наследование от Comparable требуется для поддержки метода equals();
  // наследование V от T гарантирует совместимость сравниваемого объекта с объектами массива)
   // boolean - тип возвращаемого значение
  static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
    for(int i=0; i < y.length; i++)
      if(x.equals(y[i])) return true;

    return false;
  }

  // точка входа
  public static void main(String args[]) {

	    // пробуем на Integer:
	    // создаем массив
	    Integer nums[] = { 1, 2, 3, 4, 5 };
	    // применяем метод
	    // обратите внимание:
	    // метод сам распознает типы аргументов
	    // и их не нужно указывать явно - хотя можно вызвать и так:
	    // GenMethDemo.<Integer, Integer>isIn(2, nums)
	    if(isIn(2, nums))
	      System.out.println("2 содержится в массиве nums");
	    if(!isIn(7, nums))
	      System.out.println("7 не содержится в массиве nums");
	    System.out.println();

	    // пробуем на String.
	    String strs[] = { "Москва", "Минск", "Казань","Киев", "Вильнюс" };
	    // ищем...
	    if(isIn("Казань", strs))
	      System.out.println("Казань содержится в массиве strs");

	    if(!isIn("Новые Васюки", strs))
	      System.out.println("Новые Васюки не содержатся в массиве strs");

	    // не сработает - String не является подклассом Integer
	    // не выполняется условие "V extends T" из объявления метода isIm()
	    // Java сама проверяет соответствие типов
	    // if(isIn("two", nums))
	    //     System.out.println("two is in strs");
	  }
	}