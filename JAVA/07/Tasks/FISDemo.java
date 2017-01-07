import java.io.*;

// �������:
// - ������� ���� ���� ������������� ����������
// - ���������� ��� "����� �������"

class FISDemo { 
	  public static void main(String args[]) { 
	    int size; 
	 
	    // ��������� ������ ��� ������ (��� �������� ����) 
	    try ( FileInputStream f = new FileInputStream("d:\\FISDemo.java") ) { 
	 
	      // ���������� ��������� ����� ����
	      System.out.println("����� �������� ����: " + (size = f.available()));
	      
	      // ��������� ������ "������" ��� ������
	      int n = size/40;
	      
	      System.out.println("������ " + n + " ���� ����� ������ �� ������");
	      for (int i=0; i < n; i++) { 
	    	// ��������� ������ � �����
	        System.out.print((char) f.read()); 
	      } 
	 
	      // �������������� ��������� ����� ����
	      System.out.println("\n�������� ��������: " + f.available()); 
	 
	      System.out.println("������ ��������� " + n + " ������ ��������"); 
	      byte b[] = new byte[n]; 
	      // ������ ������� ������ - ��������
	      if (f.read(b) != n) { 
	        System.err.println("������ ������ " + n + " ����."); 
	      } 
	      System.out.println(new String(b, 0, n));
	      
	      // ����� �������������� ��������� ����� ����
	      System.out.println("\n��� ��������: " + (size = f.available())); 
	      System.out.println("���������� �������� - skip()"); 
	      f.skip(size/2); 
	      System.out.println("�������� ��������: " + f.available()); 
	 
	      System.out.println("������ " + n/2 + " �� ����� �������"); 
	      if (f.read(b, n/2, n/2) != n/2) { 
	        System.err.println("������ ������ " + n/2 + " ����."); 
	      } 
	      System.out.println(new String(b, 0, b.length));
	      
	      // � ��������� ��� ����������, ������� �������� ��������
	      System.out.println("\n�������� ��������: " + f.available()); 
	    } catch(IOException e) { 
	      System.out.println("������ �����-������: " + e); 
	    } 
	  } 
	}
