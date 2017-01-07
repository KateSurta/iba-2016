 
import java.io.*; 
 
class DataIODemo { 
  public static void main(String args[]) throws IOException { 
 
	// ������� ����� ��� ������ ����������� ������
    try ( DataOutputStream dout = new DataOutputStream(new FileOutputStream("d:\\test.dat")) ) 
    { 
      // ���������� ������
      dout.writeDouble(98.6); 
      dout.writeInt(1000); 
      dout.writeBoolean(true); 
    } catch(FileNotFoundException e) { 
        System.out.println("��� ����� ��� ������"); 
        return; 
      } catch(IOException e) { 
        System.out.println("������ �����-������: " + e); 
      } 
   
      // ������� ����� ��� ����� ����������� ������
      try ( DataInputStream din = new DataInputStream(new FileInputStream("d:\\test.dat")) ) 
      { 
    	// ������ ������
        double d = din.readDouble(); 
        int i = din.readInt(); 
        boolean b = din.readBoolean(); 
        // ������� ��������
        System.out.println("��������: " + d + " " + i + " " + b); 
      } catch(FileNotFoundException e) { 
        System.out.println("��� ����� ��� ������"); 
        return; 
      } catch(IOException e) { 
        System.out.println("������ �����-������: " + e); 
      } 
    } 
  }
