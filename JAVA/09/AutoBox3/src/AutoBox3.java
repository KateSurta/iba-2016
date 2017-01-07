class AutoBox3 {
  public static void main(String args[]) {

    Integer iOb, iOb2;
    int i;

    // автоупаковка
    iOb = 100;
    System.out.println("»сходное значнение iOb: " + iOb);

    // автораспаковка, инкремент, автоупаковка
    ++iOb;
    System.out.println("ѕосле инкремента ++iOb: " + iOb);

    // автораспаковка, вычисление выражени€, автоупаковка в to iOb2.
    iOb2 = iOb + (iOb / 3);
    System.out.println("iOb2 после вычислени€: " + iOb2);

    // аналогично, но без финальной автоупаковки
    i = iOb + (iOb / 3);
    System.out.println("i после выражени€: " + i);

  }
}