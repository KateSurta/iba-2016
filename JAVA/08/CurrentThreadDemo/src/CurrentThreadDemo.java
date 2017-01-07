// пример обращени€ к главному потоку
class CurrentThreadDemo {
  public static void main(String args[]) {
	// получаем объект текущего через статический метод класса Thread
    Thread t = Thread.currentThread();

    // выводитс€: им€ потока, приоритет, название группы потоков
    System.out.println("√лавный поток: " + t);

    // измен€ем им€ потока
    t.setName("My Thread");
    System.out.println("√лавный поток после смены имени: " + t);

    // выводим "обратный отсчет" с паузами по 1 сек.
    try {
      for(int n = 5; n > 0; n--) {
        System.out.println(n);
        Thread.sleep(1000);
      }
      // обратите внимание на обработку исключений
    } catch (InterruptedException e) {
      System.out.println("√лавный поток прерван");
    }
  }
}