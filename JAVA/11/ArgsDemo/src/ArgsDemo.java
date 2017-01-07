// пример передачи ЛВ как аргумента для метода

// ФИ
interface StringFunc {
  String func(String n);
}

// демокласс
class ArgsDemo {

  // У метода два параметра:
  // первый - функциональный интерфейс
  // (соответственно, ему можно передать ссылку на экземпляр ФИ,
  // в т.ч. экземпляр, автоматически создаваемый при объявлении ЛВ)
  // второй - обрабатываемые данные (строка) 
  static String stringOp(StringFunc sf, String s) {
    return sf.func(s);
  }

    public static void main(String args[]) 
  {
    	// данные для обработки
	    String inStr = "Лямбда-выражения это сила";
	    String outStr;

	    System.out.println("Строка на входе: " + inStr);

	    // вызываем метод, передавая ему однострочное ЛВ в качестве первого параметра 
	    // и строку для обработки - в качестве второго
	    // результат тоже помещаем в строку
	    outStr = stringOp((str) -> str.toUpperCase(), inStr);
	    System.out.println("Строка на выходе: " + outStr);

	    // теперь вызываем тот же метод, но передаем ему блочное ЛВ в качестве первого параметра
	    outStr = stringOp(
	    					// первый параметр
	    					(str) ->  {
	    								// перерменные
	    								String result = "";
	    								int i;
	    								// удаляем строки из входного параметра
	    								for(i = 0; i < str.length(); i++)
	    									if(str.charAt(i) != ' ')
	    										result += str.charAt(i);
	    								// и возвращаем результат
	    								return result;
	    					}, 
	    					// второй параметр - строка для обработки
	    					inStr);

	    System.out.println("Строка без пробелов: " + outStr);
	    
	    // теперь явно создадим экземпляр ФИ и присвоим ему блочное ЛВ
	    StringFunc reverse = (str) ->  {
	      String result = "";
	      int i;

	      for(i = str.length()-1; i >= 0; i--)
	        result += str.charAt(i);

	      return result;
	    };

	    // теперь можно передать этот ФИ в качестве параметра метода
	    System.out.println("Строка наоборот: " + stringOp(reverse, inStr));
	  }
	}