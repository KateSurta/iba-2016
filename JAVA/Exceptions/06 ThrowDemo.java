// ������ "������" ��������� ����������
public class ThrowDemo {
  static void demoproc() {
    try {
      // ���������� ��������� ������� ����������
      throw new NullPointerException("������!");
    } catch(NullPointerException e) {
      System.out.println("�������� ����������.");
      throw e; // �������� ���������� ������ - �������� �����������
    }
  }

  public static void main(String args[]) {
    try {
      // ���-�� ��� ��������� � ������������ ����������
      demoproc();
    } catch(NullPointerException e) {
      System.out.println("��������� ��������: " + e);
    }
  }
}