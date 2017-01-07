// ѕример синхронизации потоков
// собственно класс дл€ потока исполнени€
class NewThread implements Runnable {
  String name; // название потока
  Thread t; // переменна€ объекта потока

  // конструктор 
  NewThread(String threadname) {
	// получаем им€ дл€ потока
    name = threadname;
    // создаем его...
    t = new Thread(this, name);
    System.out.println("Ќовый поток: " + t);
    // ... и запускаем
    t.start(); 
  }

  // точка входа в потока исполнени€
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

//демонстрационный класс
class DemoJoin {
	  public static void main(String args[]) {
		
		// создаем и запускаем потоки
	    NewThread ob1 = new NewThread("ѕервый");
	    NewThread ob2 = new NewThread("¬торой");
	    NewThread ob3 = new NewThread("“ретий");

	    // выводим состо€ние дочерних потоков
	    System.out.println("ѕервый поток запущен: " + ob1.t.isAlive());
	    System.out.println("¬торой поток запущен: " + ob2.t.isAlive());
	    System.out.println("“ретий поток запущен: " + ob3.t.isAlive());
	    
	    // ждем завешени€ потоков
	    try {
	    	System.out.println("∆дем завершени€ потоков");
	    	// "присоедин€ем" дочерние потоки, ожида€ из завершени€
	    	ob1.t.join();
	    	ob2.t.join();
	    	ob3.t.join();
	    	} catch (InterruptedException e) {
	    		System.out.println("√лавный поток прерван");
	    		}

	    // повторно выводим состо€ние дочерних потоков
	    System.out.println("ѕервый поток запущен: " + ob1.t.isAlive());
	    System.out.println("¬торой поток запущен: " + ob2.t.isAlive());
	    System.out.println("“ретий поток запущен: " + ob3.t.isAlive());

	    System.out.println("«авершение главного потока");
	    }
	  }