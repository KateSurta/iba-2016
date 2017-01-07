// класс для реализации потока исполнения
class NewThread extends Thread {

  NewThread() {
    // создаем объект потока исполнения, 
	// вызывая конструктор родительского класса
    super("Demo Thread");
    
    // выводим информацию о порожденном потоке..
    System.out.println("Child thread: " + this);
    // ..и запускаем его (метод start запускает метод run)
    // сразу после этого управление передается в главный поток,
    // после чего (в многоядерной системе) главный и дочерний поток работают параллельно
    start(); 
  }

  // сам код дочернего потока и точка входа в него
  public void run() {
    try {
    	// уже знакомый "обратный отсчет с засыпанием"
      for(int i = 5; i > 0; i--) {
        System.out.println("Дочерний поток: " + i);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out.println("Дочерний поток прерван");
    }
    // все нормально - выводим сообщение
    System.out.println("Дочерний поток завершен");
  }
}

// непосредственно демонстрационный класс
class ExtendThread {
	  public static void main(String args[]) {
		// создаем новый поток
	    new NewThread();

	    // запускаем параллельный отсчет в главном потоке
	    try {
	      for(int i = 5; i > 0; i--) {
	        System.out.println("Главный поток: " + i);
	        Thread.sleep(1000);
	      }
	    } catch (InterruptedException e) {
	      System.out.println("Главный поток прерван");
	    }
	    // главный поток должен завершиться последним
	    // в данном случае это гарантируется разными аргументами метода sleep
	    System.out.println("Главный поток завершен");

	  }
	}