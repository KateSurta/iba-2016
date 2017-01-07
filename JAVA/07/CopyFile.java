import java.io.*;

class CopyFile {
  public static void main(String args[]) throws IOException
  {
    int i;
    // объекты потоков для чтения и записи в файл
    FileInputStream fin = null;
    FileOutputStream fout = null;

    // Copy a File.
    try {
      // пытаемся инициализировать потоки
      fin = new FileInputStream("d:\\test.txt");
      fout = new FileOutputStream("d:\\test2.txt");

      // собственно побайтное копирование
      do {
        i = fin.read();
        if(i != -1) fout.write(i);
      } while(i != -1);

    } catch(IOException e) {
      System.out.println("Ошибка ввода-вывода: " + e);
    } finally {
      try {
        if(fin != null) fin.close();
      } catch(IOException e2) {
        System.out.println("Ошибка закрытия исходного файла");
      }
      try {
        if(fout != null) fout.close();
      } catch(IOException e2) {
        System.out.println("Ошибка закрытия конечного файла");
      }
    }
  }
}