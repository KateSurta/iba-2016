// ������ ��������� � �������� ������
class CurrentThreadDemo {
  public static void main(String args[]) {
	// �������� ������ �������� ����� ����������� ����� ������ Thread
    Thread t = Thread.currentThread();

    // ���������: ��� ������, ���������, �������� ������ �������
    System.out.println("������� �����: " + t);

    // �������� ��� ������
    t.setName("My Thread");
    System.out.println("������� ����� ����� ����� �����: " + t);

    // ������� "�������� ������" � ������� �� 1 ���.
    try {
      for(int n = 5; n > 0; n--) {
        System.out.println(n);
        Thread.sleep(1000);
      }
      // �������� �������� �� ��������� ����������
    } catch (InterruptedException e) {
      System.out.println("������� ����� �������");
    }
  }
}