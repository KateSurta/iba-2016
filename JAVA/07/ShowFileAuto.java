
import java.io.*;

class ShowFileAuto {
  public static void main(String args[])
  {
    int i;

    // ����� ����� try - try with resources
    // ��������� ���� ������� �� ���������
    try(FileInputStream fin = new FileInputStream("d:\\test.txt")) {

      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } catch(FileNotFoundException e) {
      System.out.println("���� �� ������");
    } catch(IOException e) { 
        System.out.println("������ �����-������");
      }
    }
  }
