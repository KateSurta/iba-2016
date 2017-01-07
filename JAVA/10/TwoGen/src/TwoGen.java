// ������ ����������� ������ � ����� ����������� ����
class Gen2<T, V> {
  T ob1;
  V ob2;

  // �������� � ����������� ���� ������ ���� T
  // � ���� - ���� V.
  Gen2(T o1, V o2) {
    ob1 = o1;
    ob2 = o2;
  }

  // ���������� ���� T � V.
  void showTypes() {
    System.out.println("��� T: " + ob1.getClass().getName());

    System.out.println("��� V: " + ob2.getClass().getName());
  }

  
  T getob1() {
    return ob1;
  }

  V getob2() {
	    return ob2;
  }
}

	// ���������
	class TwoGen {
	  public static void main(String args[]) {

		// ������� ������ ������������������ ������
	    Gen2<Integer, String> tgObj = new Gen2<Integer, String>(88, "���������");

	    // ���������� ����
	    tgObj.showTypes();

	    // ��������� � ���������� ��������
	    int v = tgObj.getob1();
	    System.out.println("�������� 1: " + v);

	    String str = tgObj.getob2();
	    System.out.println("�������� 2: " + str);
	  }
	}