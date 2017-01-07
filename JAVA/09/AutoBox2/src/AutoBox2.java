
class AutoBox2 {
  // получаем Integer на вход, возвращаем int
  static int m(Integer v) {
    return v ; // автораспаковка
  }

  public static void main(String args[]) {
    // передаем методу m() int-значение (выполняется автоупаковка аргумента)
	// затем внутри Integer автоматически распаковывается в int
	// при возврате значения снова выполняем автоупаковку
	// PS "pen-pineapple-apple-pen"(c) :)
    Integer iOb = m(100);

    System.out.println(iOb);
  }
}