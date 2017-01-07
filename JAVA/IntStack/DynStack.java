// реализаци€ стека динамической длины
class DynStack implements IntStack {
  private int stck[];
  private int tos;

  // инициализаци€
  DynStack(int size) {
    stck = new int[size];
    tos = -1;
  }

  // помещение элемента
  public void push(int item) {
    // если стек уже полон - выдел€ем еще место
    if(tos==stck.length-1) {
      int temp[] = new int[stck.length * 2]; // увеличиваем стек в два раза
      // копируем содержимое старого стека в новый
      for(int i=0; i<stck.length; i++) temp[i] = stck[i]; 
      stck = temp;
      stck[++tos] = item;
    }
    else
      // место есть - просто добавл€ем элемент
      stck[++tos] = item;
  }

  // извлечение элемента
  public int pop() {
    if(tos < 0) {
      System.out.println("—тек пуст");
      return 0;
    }
    else
      return stck[tos--];
  }
}

