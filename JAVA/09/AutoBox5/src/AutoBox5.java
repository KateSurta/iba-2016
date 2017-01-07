class AutoBox5 {
  public static void main(String args[]) {

    // автоупаковка boolean.
    Boolean b = true;

    // b автораспаковывается при оценке выражения
    if(b) System.out.println("b равен true");

    // автоупаковка char
    Character ch = 'x'; // автоупаковка
    char ch2 = ch; // автораспаковка

    System.out.println("ch2 равен " + ch2);
  }
}