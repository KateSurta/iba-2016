
import java.io.*;

class ShowFileAuto {
  public static void main(String args[])
  {
    int i;

    // новая форма try - try with resources
    // закрывать файл вручную не требуется
    try(FileInputStream fin = new FileInputStream("d:\\test.txt")) {

      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } catch(FileNotFoundException e) {
      System.out.println("Файл не найдет");
    } catch(IOException e) { 
        System.out.println("Ошибка ввода-вывода");
      }
    }
  }
