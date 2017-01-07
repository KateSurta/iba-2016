// Используем BufferedReader для чтения с консоли
import java.io.*;

public class BRReader {
  public static void main(String args[]) throws IOException
  {
    char c;
    // готовим поток ввода
    BufferedReader br = new
            BufferedReader(new InputStreamReader(System.in));
    System.out.println("Вводите символы, 'q' to quit.");
    // собственно посимвольное чтение из консоли
    do {
      c = (char) br.read();
      System.out.println(c);
    } while(c != 'q');
  }
}