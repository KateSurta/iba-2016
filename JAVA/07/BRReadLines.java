// ѕострочное чтение с использованием BufferedReader.
import java.io.*;

class BRReadLines {
	  public static void main(String args[]) throws IOException
	  {
	    // готовим поток ввода
	    BufferedReader br = new BufferedReader(new
	                            InputStreamReader(System.in));
	    String str;
	    System.out.println("¬водите строки текста.");
	    System.out.println("¬ведите 'stop', чтобы завершить выполнение.");

	    // построчно читаем данные из консоли, пока не дождемс€ 'stop'
	    do {
	      str = br.readLine();
	      System.out.println(str);
	    } while(!str.equals("stop"));
	  }
	}