// ����� ��� ���������� ������ ����������
class NewThread extends Thread {

  NewThread() {
    // ������� ������ ������ ����������, 
	// ������� ����������� ������������� ������
    super("Demo Thread");
    
    // ������� ���������� � ����������� ������..
    System.out.println("Child thread: " + this);
    // ..� ��������� ��� (����� start ��������� ����� run)
    // ����� ����� ����� ���������� ���������� � ������� �����,
    // ����� ���� (� ������������ �������) ������� � �������� ����� �������� �����������
    start(); 
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
class ExtendThread {
	  public static void main(String args[]) {
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