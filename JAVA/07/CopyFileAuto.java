
import java.io.*;

class CopyFileAuto {
  public static void main(String args[]) throws IOException
  {
    int i;

    // автозакрытие сразу для двух ресурсов
    try (FileInputStream fin = new FileInputStream("d:\\test.txt");
         FileOutputStream fout = new FileOutputStream("d:\\test2.txt"))    {

      do {
        i = fin.read();
        if(i != -1) fout.write(i);
      } while(i != -1); 

    } catch(IOException e) {
      System.out.println("Ошибка ввода-вывода: " + e);
    }
  }
}