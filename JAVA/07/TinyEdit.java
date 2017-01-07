// микроредактор
import java.io.*;

class TinyEdit {
  public static void main(String args[]) throws IOException
  {
    // готовим поток ввода
    BufferedReader br = new BufferedReader(new
                            InputStreamReader(System.in));

    // массив строк дл€ хранени€ пользовательского ввода 
    String str[] = new String[100];
    
    System.out.println("¬водите строки текста.");
    System.out.println("¬ведите 'stop', чтобы завершить выполнение.");
    
    for(int i=0; i<100; i++) {
      str[i] = br.readLine();
      if(str[i].equals("stop")) break;
    }
    
    System.out.println("\n–езультаты ввода:");
    // display the lines
    for(int i=0; i<100; i++) {
      if(str[i].equals("stop")) break;
      System.out.println(str[i]);
    }
  }
}