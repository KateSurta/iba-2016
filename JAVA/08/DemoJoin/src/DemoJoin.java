// ������ ������������� �������
// ���������� ����� ��� ������ ����������
class NewThread implements Runnable {
  String name; // �������� ������
  Thread t; // ���������� ������� ������

  // ����������� 
  NewThread(String threadname) {
	// �������� ��� ��� ������
    name = threadname;
    // ������� ���...
    t = new Thread(this, name);
    System.out.println("����� �����: " + t);
    // ... � ���������
    t.start(); 
  }

  // ����� ����� � ������ ����������
  public void run() {
   try {
	  // ��� �� �������, ����� �������� ������ - 
	  // �� ��� � ��������� "����������" ������
      for(int i = 5; i > 0; i--) {
        System.out.println(name + ": " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println(name + " �������");
    }
    System.out.println(name + " ��������");
  }
}

//���������������� �����
class DemoJoin {
	  public static void main(String args[]) {
		
		// ������� � ��������� ������
	    NewThread ob1 = new NewThread("������");
	    NewThread ob2 = new NewThread("������");
	    NewThread ob3 = new NewThread("������");

	    // ������� ��������� �������� �������
	    System.out.println("������ ����� �������: " + ob1.t.isAlive());
	    System.out.println("������ ����� �������: " + ob2.t.isAlive());
	    System.out.println("������ ����� �������: " + ob3.t.isAlive());
	    
	    // ���� ��������� �������
	    try {
	    	System.out.println("���� ���������� �������");
	    	// "������������" �������� ������, ������ �� ����������
	    	ob1.t.join();
	    	ob2.t.join();
	    	ob3.t.join();
	    	} catch (InterruptedException e) {
	    		System.out.println("������� ����� �������");
	    		}

	    // �������� ������� ��������� �������� �������
	    System.out.println("������ ����� �������: " + ob1.t.isAlive());
	    System.out.println("������ ����� �������: " + ob2.t.isAlive());
	    System.out.println("������ ����� �������: " + ob3.t.isAlive());

	    System.out.println("���������� �������� ������");
	    }
	  }