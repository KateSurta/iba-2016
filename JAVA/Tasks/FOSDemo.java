 
import java.io.*; 

// Задание:
// - записать в четвертый файл каждый пятый байт из буфера
// - реализовать вариант, совместимый со старыми версиями Java
 
class FOSDemo { 
  public static void main(String args[]) { 
    String source = "С рождения Бобби пай-мальчиком был\n" 
      + " Имел Бобби хобби - он деньги любил.\n" 
      + " Все дети как дети, растут без забот."
      + " А маленький Бобби не ест и не пьет - в копилку кладет"; 
    byte buf[] = source.getBytes(); 
 
    // объявляем ресурсы. 
    try (FileOutputStream f0 = new FileOutputStream("d:\\file1.txt"); 
         FileOutputStream f1 = new FileOutputStream("d:\\file2.txt"); 
         FileOutputStream f2 = new FileOutputStream("d:\\file3.txt") ) 
    { 
 
      // пишем в первый - побайтно
      for (int i=0; i < buf.length; i += 2) f0.write(buf[i]); 
 
      // пишем во второй - буфер целиком
      f1.write(buf); 
 
      // пишем в третий - со смещением 
      f2.write(buf, buf.length-buf.length/4, buf.length/4); 
    } catch(IOException e) { 
      System.out.println("Ошибка ввода-вывода"); 
    } 
  } 
}
