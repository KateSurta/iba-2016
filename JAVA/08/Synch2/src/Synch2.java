// программа БЕЗ синхронизации

// класс для демонстрации исполнения длительного потока ("работа")
class Callme {
  // единственный метод
	void call(String msg) {
	// начинаем работу: 
	// выводим открывающую скобку и полученную строку...
    System.out.print("[" + msg);
    //.. спим секунду (имитация работы)
    try {
      Thread.sleep(1000);
    } catch(InterruptedException e) {
      System.out.println("Поток прерван");
    }
    // а затем выводим закрывающую скобку (работа завершена)
    System.out.println("]");
  } 
  
}

// класс для потока исполнения
class Caller implements Runnable {
  String msg;
  Callme target;
  Thread t;

  // при создании - запускаем класс "работы" в отдельно потоке
  public Caller(Callme targ, String s) {
    target = targ;
    msg = s;
    // порождаем объект потока
    t = new Thread(this);
    // и запускаем его
    t.start();
  }
  
  public void run() {
	  // запуск в синхронизированном блоке!
	  synchronized(target) { 
	      target.call(msg);
    }
  }
}


// сам депокласс
class Synch2 {
	  public static void main(String args[]) {
		// объект "работы"
	    Callme target = new Callme();
	    // три объекта потоков для трех "работ"
	    Caller ob1 = new Caller(target, "Здравствуй");
	    Caller ob2 = new Caller(target, "синхронизированный");
	    Caller ob3 = new Caller(target, "мир");

	    // ждем завершения потоков
	    try {
	      ob1.t.join();
	      ob2.t.join();
	      ob3.t.join();
	    } catch(InterruptedException e) {
	      System.out.println("Поток прерван");
	    }
	  }
	}