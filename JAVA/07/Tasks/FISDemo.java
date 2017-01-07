import java.io.*;

// Задание:
// - создать свой файл произвольного содержания
// - переписать его "задом наперед"

class FISDemo { 
	  public static void main(String args[]) { 
	    int size; 
	 
	    // объявляем ресурс для работы (сам исходный файл) 
	    try ( FileInputStream f = new FileInputStream("d:\\FISDemo.java") ) { 
	 
	      // определяем доступное число байт
	      System.out.println("Всего доступно байт: " + (size = f.available()));
	      
	      // вычисляем размер "порции" для чтения
	      int n = size/40;
	      
	      System.out.println("Первые " + n + " байт файла читаем по одному");
	      for (int i=0; i < n; i++) { 
	    	// побайтное чтение в цикле
	        System.out.print((char) f.read()); 
	      } 
	 
	      // переопределяем доступное число байт
	      System.out.println("\nОсталось доступно: " + f.available()); 
	 
	      System.out.println("Читаем следующие " + n + " читаем массивом"); 
	      byte b[] = new byte[n]; 
	      // другой вариант чтения - массивом
	      if (f.read(b) != n) { 
	        System.err.println("Ошибка чтения " + n + " байт."); 
	      } 
	      System.out.println(new String(b, 0, n));
	      
	      // снова переопределяем доступное число байт
	      System.out.println("\nЕще доступно: " + (size = f.available())); 
	      System.out.println("Пропускаем половину - skip()"); 
	      f.skip(size/2); 
	      System.out.println("Осталось доступно: " + f.available()); 
	 
	      System.out.println("Читаем " + n/2 + " до конца массива"); 
	      if (f.read(b, n/2, n/2) != n/2) { 
	        System.err.println("Ошибка чтения " + n/2 + " байт."); 
	      } 
	      System.out.println(new String(b, 0, b.length));
	      
	      // в последний раз определяем, сколько осталось доступно
	      System.out.println("\nОсталось доступно: " + f.available()); 
	    } catch(IOException e) { 
	      System.out.println("Ошибка ввода-вывода: " + e); 
	    } 
	  } 
	}
