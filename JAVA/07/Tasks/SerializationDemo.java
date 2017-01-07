 
import java.io.*; 

// �������:
// - ������� ��� ���� ����� (�����������)
// ����������� �������� � ��������� ������ ���������� ������ ��������
 
public class SerializationDemo { 
  public static void main(String args[]) { 
 
    // �������� ������ ��� ������������ �������� 
 
    try ( ObjectOutputStream objOStrm = new ObjectOutputStream(new FileOutputStream("serial")) ) 
    { 
      MyClass object1 = new MyClass("������", -7, 2.7e10); 
      System.out.println("������ 1: " + object1); 
 
      objOStrm.writeObject(object1); 
    } 
    catch(IOException e) { 
      System.out.println("������ ������������: " + e); 
    } 
 
    // �������� ������ ��� �������������� �������� 
 
    try ( ObjectInputStream objIStrm = new ObjectInputStream(new FileInputStream("serial")) ) 
    { 
      MyClass object2 = (MyClass)objIStrm.readObject(); 
      System.out.println("������ 2: " + object2); 
    } 
    catch(Exception e) { 
      System.out.println("������ ��������������: " + e); 
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
