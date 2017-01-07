// Пример использования ordinal(), compareTo() и equals().

// опять яблоки
enum Apple {
  Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

class AppleDemo4 {
  public static void main(String args[])
  {
    Apple ap, ap2, ap3;

    // получаем все позиции значений с помощью ordinal().
    System.out.println("Значения констант и их позиции: ");
    for(Apple a : Apple.values())
      System.out.println(a + " " + a.ordinal());

    // помещаем в переменные три конкретных объекта
    ap =  Apple.RedDel;
    ap2 = Apple.GoldenDel;
    ap3 = Apple.RedDel;

    System.out.println();

    // пример compareTo() and equals()
    if(ap.compareTo(ap2) < 0)
      System.out.println(ap + " идет перед " + ap2);

    if(ap.compareTo(ap2) > 0)
        System.out.println(ap2 + " идет после " + ap);

      if(ap.compareTo(ap3) == 0)
        System.out.println(ap + " равно " + ap3);

      System.out.println();

      if(ap.equals(ap2))
        System.out.println("Ошибка!");

      if(ap.equals(ap3))
        System.out.println(ap + " равно " + ap3);

      if(ap == ap3)
        System.out.println(ap + " == " + ap3);

    }
  }