 
import java.io.*; 

// �������:
// - �������� � ��������� ���� ������ ����� ���� �� ������
// - ����������� �������, ����������� �� ������� �������� Java
 
class FOSDemo { 
  public static void main(String args[]) { 
    String source = "� �������� ����� ���-��������� ���\n" 
      + " ���� ����� ����� - �� ������ �����.\n" 
      + " ��� ���� ��� ����, ������ ��� �����."
      + " � ��������� ����� �� ��� � �� ���� - � ������� ������"; 
    byte buf[] = source.getBytes(); 
 
    // ��������� �������. 
    try (FileOutputStream f0 = new FileOutputStream("d:\\file1.txt"); 
         FileOutputStream f1 = new FileOutputStream("d:\\file2.txt"); 
         FileOutputStream f2 = new FileOutputStream("d:\\file3.txt") ) 
    { 
 
      // ����� � ������ - ��������
      for (int i=0; i < buf.length; i += 2) f0.write(buf[i]); 
 
      // ����� �� ������ - ����� �������
      f1.write(buf); 
 
      // ����� � ������ - �� ��������� 
      f2.write(buf, buf.length-buf.length/4, buf.length/4); 
    } catch(IOException e) { 
      System.out.println("������ �����-������"); 
    } 
  } 
}
