import java.io.*;

class CopyFile {
  public static void main(String args[]) throws IOException
  {
    int i;
    // ������� ������� ��� ������ � ������ � ����
    FileInputStream fin = null;
    FileOutputStream fout = null;

    // Copy a File.
    try {
      // �������� ���������������� ������
      fin = new FileInputStream("d:\\test.txt");
      fout = new FileOutputStream("d:\\test2.txt");

      // ���������� ��������� �����������
      do {
        i = fin.read();
        if(i != -1) fout.write(i);
      } while(i != -1);

    } catch(IOException e) {
      System.out.println("������ �����-������: " + e);
    } finally {
      try {
        if(fin != null) fin.close();
      } catch(IOException e2) {
        System.out.println("������ �������� ��������� �����");
      }
      try {
        if(fout != null) fout.close();
      } catch(IOException e2) {
        System.out.println("������ �������� ��������� �����");
      }
    }
  }
}