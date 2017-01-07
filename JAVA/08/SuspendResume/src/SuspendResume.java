// пример приостановлени€ и возобновлени€ потока
// класс собственно потока
class NewThread implements Runnable {
  // название потока
  String name; 
  // объект потока
  Thread t;
  // флагова€ переменна€
  boolean suspendFlag;

  // конструктор
  NewThread(String threadname) {
    name = threadname;
    // создаем поток
    t = new Thread(this, name);
    System.out.println("Ќовый поток: " + t);
    // и запускаем его
    suspendFlag = false;
    t.start(); 
  }

  // точка входа
  public void run() {
    try {
    	// все тот же обратный отсчет
      for(int i = 15; i > 0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(200);
        // но уже с учетом переменной
        // как только она true, приостанавливаем поток
        synchronized(this) {
          while(suspendFlag) {
            wait();
          }
        }
      }
    } catch (InterruptedException e) {
      System.out.println(name + " прерван.");
    }

    System.out.println(name + " завершен.");
  }

  // процедура приостановки
  synchronized void mysuspend() {
	  // просто переустанавливаем флаговую переменную
      suspendFlag = true;
  }

  // процедура запуска
  synchronized void myresume() {
	// переустанавливаем флаговую переменную...
    suspendFlag = false;
    // .. и извещаем процесс
    notify();
  }
} 

// демонстрационный класс
class SuspendResume {
  public static void main(String args[]) {
	// создаем два потока
    NewThread ob1 = new NewThread("ѕервый");
    NewThread ob2 = new NewThread("¬торой");

    // запускаем и приостанавливаем потоки в произвольном пор€дке
    try {
      Thread.sleep(1000);
      ob1.mysuspend();
      System.out.println("ѕриостанавливаем первый поток");
      Thread.sleep(1000);
      ob1.myresume();
      System.out.println("¬озобновл€ем первый поток");
      ob2.mysuspend();
      System.out.println("ѕриостанавливаем второй поток");
      Thread.sleep(1000);
      ob2.myresume();
      System.out.println("¬озобновл€ем второй поток");
    } catch (InterruptedException e) {
      System.out.println("√лавный поток прерван");
    }

    // ждем завершени€ всех потоков
    try {
      System.out.println("∆дем завершени€ всех потоков");
      ob1.t.join();
      ob2.t.join();
    } catch (InterruptedException e) {
      System.out.println("√лавный поток прерван");
    }

    System.out.println("√лавный поток завершен");
  }
}