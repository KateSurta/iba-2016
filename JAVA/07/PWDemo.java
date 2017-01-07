// PWDemo - грамотный вывод в консоль
import java.io.*;

public class PWDemo {
  public static void main(String args[]) {
	// создаем объект потока вывода с автоочисткой
    PrintWriter pw = new PrintWriter(System.out, true);
    // ..и выводим с его помощью данные разного типа
    pw.println("Вывод строки");
    int i = -7;
    pw.println(i);
    double d = 4.5e-7;
    pw.println(d);
  }
}