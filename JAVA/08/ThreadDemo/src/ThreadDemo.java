// ����� ��� ���������� ������ ����������
class NewThread implements Runnable {
  // ���������� ������ ����������
  Thread t;

  // ����������� - � ��� ������� ��� �����
  NewThread() {
	// ������� ������ ������ �� ������ �������� ������ � ������ ��� ���
	// � ����� �������� ��������� �� ���� � ���������� t
    t = new Thread(this, "Demo Thread");
    // ������� ���������� � ����������� ������..
    System.out.println("�������� �����: " + t);
    // ..� ��������� ��� (����� start ��������� ����� run)
    // ����� ����� ����� ���������� ���������� � ������� �����,
    // ����� ���� (� ������������ �������) ������� � �������� ����� �������� �����������
    t.start(); 
  }

  // ��� ��� ��������� ������ � ����� ����� � ����
  public void run() {
    try {
      // ��� �������� "�������� ������ � ����������"
      for(int i = 5; i > 0; i--) {
        System.out.println("�������� �����: " + i);
        Thread.sleep(500);
      }
    } catch (InterruptedException e) {
      System.out.println("�������� ����� �������");
    }
    // ��� ��������� - ������� ���������
    System.out.println("�������� ����� ��������");
  } 
  
}


// ��������������� ���������������� �����
class ThreadDemo {
  public static void main(String args[ ] ) {
	// ������� ����� �����
    new NewThread(); 

    // ��������� ������������ ������ � ������� ������
    try {
      for(int i = 5; i > 0; i--) {
        System.out.println("������� �����: " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {

      System.out.println("������� ����� �������");
    }
    // ������� ����� ������ ����������� ���������
    // � ������ ������ ��� ������������� ������� ����������� ������ sleep
    System.out.println("������� ����� ��������");
  }
}