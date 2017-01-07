// ѕример использовани€ предопределенных методов перечислений

// ¬се те же сорта €блок
enum Apple {
  Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

class AppleDemo2 {
  public static void main(String args[])
  {
    Apple ap;

    System.out.println("¬озможные константы перечислени€ Apple:");
    // используем values()
    Apple allapples[] = Apple.values();
    for(Apple a : allapples)
      System.out.println(a);

    System.out.println();

    // используем valueOf()
    ap = Apple.valueOf("Winesap");
    System.out.println("ap содержит " + ap);

  }
}