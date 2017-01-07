// пример перечисления (сорта яблок)
enum Apple {
  Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

class AppleDemo {
  public static void main(String args[])
  {
    Apple ap;

    ap = Apple.RedDel;

    // Выводим значение переменной.
    System.out.println("Значение ap: " + ap);
    System.out.println();

    ap = Apple.GoldenDel;

    // Сравнение значений
    if(ap == Apple.GoldenDel)
      System.out.println("ap содержит GoldenDel.\n");

    // Использование в ветвлении
    switch(ap) {
      case Jonathan:
        System.out.println("Jonathan  - красное.");
        break;
      case GoldenDel:
          System.out.println("Golden Delicious - желтое.");        break;
        case RedDel:
          System.out.println("Red Delicious - красное.");
          break;
        case Winesap:
          System.out.println("Winesap - темно-красное.");
          break;
        case Cortland:
          System.out.println("Cortland - зеленое.");
          break;
      }
    }
  }