
// пример взаимодействия потоков
//два потока (Producer и Consumer могут помещать и 
//извлекать объект в очередь строго по порядку)

//очередь для хранения передаваемых объектов
class Q {
// сам объект (просто число)
int n;
// флаг помещения объекта в очередь
boolean valueSet = false;

// синхронизированный метод извлечения из очереди
synchronized int get() {
	// ждем помещения объекта в очередь
	// (бесконечный цикл с проверкой условия)
 while(!valueSet)
   try {
     wait();
   } catch(InterruptedException e) {
     System.out.println("Перехвачено InterruptedException");      }
 // выводим полученное число
 System.out.println("Получено: " + n);
 // "очищаем" очередь
 valueSet = false;
 // извещаем поток Producer
 notify();
 // возвращаем само число
 return n;
}

// синхронизированный метод помещения в очередь
synchronized void put(int n) { 
	    // если очередь занята - ждем извлечения
	    while(valueSet)
	        try {
	          wait();
	        } catch(InterruptedException e) {
	          System.out.println("Перехвачено InterruptedException");      }

	        // помещаем полученное число в переменную класса
	        this.n = n;
	        // "заполняем" очередь
	        valueSet = true;
	        // сообщаем о получении объекта
	        System.out.println("Помещено: " + n);
	        // извещаем поток Consumer
	        notify();
	    }
	  }

	  // класс-"поставщик", помещающий число в очередь
	  class Producer implements Runnable {
		// объект очереди
	    Q q;

	    // конструктор "поставщика"
	    Producer(Q q) {
	      // присоединяемся к очереди
	      this.q = q;
	      // запускаем поток
	      new Thread(this, "Producer").start();
	    }

	    // точка входа "поставщика"
	    public void run() {
	      int i = 0;
	      // бесконечно помещаем число в очередь
	      while(true) {
	        q.put(i++);
	      }
	    }
	  }

	  // класс-"потребитель", извлекающий число из очереди
	  class Consumer implements Runnable {
			// объект очереди
		    Q q;

		    // конструктор "потребителя"
		    Consumer(Q q) {
		    // присоединяемся к очереди
		    this.q = q;
		    // запускаем поток
		    new Thread(this, "Consumer").start();
		    }

		    // точка входа "потребителя"
		    public void run() {
	       // бесконечно извлекаем число из очереди
		    	while(true) {
		    	q.get();
		    	}
		    }
	}

//демонстрационный класс
class PCFixed {
public static void main(String args[]) {
	// создаем очередь
 Q q = new Q();
 // создаем поставщика
 new Producer(q);
 // создаем потребителя
 new Consumer(q);

 // работаем, пока пользователь не завершит программу
 System.out.println("Нажмите Terminate/Disconnect для остановки.");
}
}