// реализаци€ стека фиксированного размера
class FixedStack implements IntStack {
  // переменные дл€ хранени€ самого стека...
  private int stck[];
  // ..и индекса последнего элемента
  private int tos;

  // инициализаци€
  FixedStack(int size) {
    stck = new int[size];
    tos = -1;
  }

  // добавл€ем элемент
  public void push(int item) {
    if(tos==stck.length-1) // стек переполнен
      System.out.println("—тек переполнен!)");
    else
      stck[++tos] = item;
  }
  // извлекаем элемент
  public int pop() {
    if(tos < 0) {
      System.out.println("—тек пуст!");      return 0;
    }
    else
      return stck[tos--];
  }
}

