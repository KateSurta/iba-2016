// пример создания нескольких потоков
// собственно класс для потока исполнения
class NewThread implements Runnable {
  String name; // название потока
  Thread t; // переменная объекта потока

  // конструктор 
  NewThread(String threadname) {
	// получаем имя для потока
    name = threadname;
    // создаем его...
    t = new Thread(this, name);
    System.out.println("Новый поток: " + t);
    // ... и запускаем
    t.start(); 
  }

  // точка входа в потока исполнения
  public void run() {
   try {
	  // как ни странно, снова обратный отсчет - 
	  // но уже с указанием "считающего" потока
      for(int i = 5; i > 0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println(name + " прерван");
    }
    System.out.println(name + " завершен");
  }
}
 
// демонстрационный класс
class MultiThreadDemo {
	  public static void main(String args[]) {
		// создаем и запускаем потока
	    new NewThread("Первый"); 
	    new NewThread("Второй");
	    new NewThread("Третий");

	    try {
	      // приостанавливаем главный поток - 
	      // ждем завершения дочерних (не лучший способ)
	      Thread.sleep(10000);
	    } catch (InterruptedException e) {
	      System.out.println("Главный поток прерван");
	    }
	    System.out.println("Главный поток завершен");
	  }
	}