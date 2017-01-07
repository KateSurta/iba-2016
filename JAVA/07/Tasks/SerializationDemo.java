 
import java.io.*; 

// Задание:
// - создать еще один класс (собственный)
// попробовать записать и прочитать разные комбинации разных объектов
 
public class SerializationDemo { 
  public static void main(String args[]) { 
 
    // создание потока для сериализация объектов 
 
    try ( ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial")) ) 
    { 
      MyClass object1 = new MyClass("Привет", -7, 2.7e10); 
      System.out.println("Объект 1: " + object1); 
 
      objOStrm.writeObject(object1); 
    } 
    catch(IOException e) { 
      System.out.println("Ошибка сериализации: " + e); 
    } 
 
    // создание потока для десериализация объектов 
 
    try ( ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial")) ) 
    { 
      MyClass object2 = (MyClass)objIStrm.readObject(); 
      System.out.println("Объект 2: " + object2); 
    } 
    catch(Exception e) { 
      System.out.println("Ошибка десериализации: " + e); 
    } 
  } 
} 

class MyClass implements Serializable { 
	  String s; 
	  int i; 
	  double d; 
	 
	  public MyClass(String s, int i, double d) { 
	    this.s = s; 
	    this.i = i; 
	    this.d = d; 
	  }
	  public String toString() { 
		    return "s=" + s + "; i=" + i + "; d=" + d; 
		  } 
		}
