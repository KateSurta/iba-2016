// ������ ������������� finally
public class FinallyDemo {
  // ���������� ���������� � ������
  static void procA() {
    try {
      System.out.println("����� procA");
      throw new RuntimeException("������");
    } finally {
      System.out.println("finally ������ procA");
    }
  }

  // ��������� ������� �� ����� try
  static void procB() {
    try {
      System.out.println("����� procB");
      return;
    } finally {
      System.out.println("finally ������ procB");
    }
  }

  // ����������� ����������
  static void procC() {
    try {
      System.out.println("����� procC");
    } finally {
      System.out.println("finally ������ procC");
    }
  }

  public static void main(String args[]) {
	    try {
	      // ������ ��������
	      procA();
	    } catch (Exception e) {
	      System.out.println("���������� �����������");
	    }
	    // ������ ��������
	    procB();
	    // ������ ��������
	    procC();
	  }
	}