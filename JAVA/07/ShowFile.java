import java.io.*;

class ShowFile {
  public static void main(String args[])
  {
    int i;
    FileInputStream fin = null;

    try {
      // ������� ����� ��� ������ �����
      fin = new FileInputStream("d:\\test.txt");

      // ������ ���� �����������, ���� �� ������ �� EOF (��� -1)
      do {
        i = fin.read();
        if(i != -1) System.out.print((char) i);
      } while(i != -1);

    } // ��������� ������ ���������� ����� 
      // �� ������, ������������� (��� ������� ������ IOException)
      catch(FileNotFoundException e) {
      System.out.println("���� �� ������");
    } // ��������� ������ �����
      catch(IOException e) {
      System.out.println("������ ������");
    } finally {
      // ��������� ���� (�� ������� ��������. ���������� �� �� ������)
      try {
          if(fin != null) fin.close();
        } catch(IOException e) {
          System.out.println("������ �������� �����");      }
      }
    }
  }