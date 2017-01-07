// Перечисление это класс, у которого есть переменные, методы и конструктор
enum Apple {
  Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

  private int price; // переменная (цена яблок)

  // конструктор с указанием цены
  Apple(int p) { price = p; }
  
  // конструктор по умолчанию
  Apple() { price = -1; }


  // метод
  int getPrice() { return price; }
}

class AppleDemo3 {
  public static void main(String args[])
  {
    // отображаем цену сорта Winesap.
    System.out.println("Winesap стоит" + Apple.Winesap.getPrice() + " р.\n");

    // отображаем список всех сортов с ценами. 
    System.out.println("Все сортв с ценами:");
    for(Apple a : Apple.values())
      System.out.println(a + " стоит " + a.getPrice() + " р.");
  }
}