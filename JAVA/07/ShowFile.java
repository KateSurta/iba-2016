import java.io.*;

class ShowFile {
  public static void main(String args[])
  {
    int i;
    FileInputStream fin = null;

    try {
      // создаем поток для чтения файла
      fin = new FileInputStream("d:\\test.txt");

      // читаем файл посимвольно, пока не дойдем до EOF (код -1)
      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } // обработка ошибки нахождения файла 
      // по теории, необязательно (это частный случай IOException)
      catch(FileNotFoundException e) {
      System.out.println("Файл не найдет");
    } // обработка ошибок ввода
      catch(IOException e) {
      System.out.println("Ошибка чтения");
    } finally {
      // закрываем файл (но сначала проверка. открывался ли он вообще)
      try {
          if(fin != null) fin.close();
        } catch(IOException e) {
          System.out.println("Ошибка закрытия файла");      }
      }
    }
  }