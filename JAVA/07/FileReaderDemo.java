import java.io.FileReader;
import java.io.IOException; 
 
class FileReaderDemo { 
  public static void main(String args[]) { 
 
	// создаем поток для чтения файла
    try ( FileReader fr = new FileReader("d:\\test.txt") ) 
    { 
      int c; 
 
      // читаем файл посимволько 
      while((c = fr.read()) != -1) System.out.print((char) c); 
 
    } catch(IOException e) { 
      System.out.println("Ошибка ввода-вывода: " + e); 
    } 
  } 
}
