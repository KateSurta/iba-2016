import java.io.*; 
 
class FileWriterDemo { 
  public static void main(String args[]) throws IOException { 
	    String source = "С рождения Бобби пай-мальчиком был\n" 
	    	      + " Имел Бобби хобби - он деньги любил.\n" 
	    	      + " Все дети как дети, растут без забот."
	    	      + " А маленький Бобби не ест и не пьет - в копилку кладет"; 
	// готовим буфер для записи
    char buffer[] = new char[source.length()]; 
    source.getChars(0, source.length(), buffer, 0); 
 
    try ( FileWriter f0 = new FileWriter("d:\\file1.txt"); 
          FileWriter f1 = new FileWriter("d:\\file2.txt"); 
          FileWriter f2 = new FileWriter("d:\\file3.txt") ) 
    { 
      // пишем в первый файл
      for (int i=0; i < buffer.length; i += 2) { 
        f0.write(buffer[i]); 
      } 
 
      // пишем во второй 
      f1.write(buffer); 
 
      // пишем в третий 
      f2.write(buffer,buffer.length-buffer.length/4,buffer.length/4); 
    } catch(IOException e) { 
        System.out.println("Ошибка ввода-вывода"); 
      } 
    } 
  }
