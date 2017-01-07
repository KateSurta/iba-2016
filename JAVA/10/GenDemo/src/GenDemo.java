// ������ ���������
// T - ��� �������� ����, ������� ���������� �������� �����
// ��� �������� ������� ������ Gen
class Gen<T> {
  T ob; // ������ ������� ���� T

  // �������� ������������ ������ �� ������
  // ������ T.
  Gen(T o) {
    ob = o;
  }

  // ���������� ob.
  T getob() {
    return ob;
  }

  // ���������� ��� T. 
  void showType() {
	    System.out.println("��� T: " + ob.getClass().getName());
	  }
	}

	// �����-������������
	class GenDemo {
	  public static void main(String args[]) {
	    // ��������� ���������� ������ Gen ��� �������� Integer.
	    Gen<Integer> iOb;

	    // ������� ������ Gen<Integer> � �������� ������ �� ���� � 
	    // ���������� iOb (�������� �������� �� ������������� ��� � ������������)
	    iOb = new Gen<Integer>(88);

	    // ���������� ��� iOb.
	    iOb.showType();

	    // �������� �������� iOb 
	    //  (�������� �������� - ������ �������������� �� ������������)
	    int v = iOb.getob();
	    System.out.println("��������: " + v);

	    System.out.println();

	    // ������� Gen-������ ��� �������� String.
	    Gen<String> strOb = new Gen<String> ("���� ���������");

	    // ���������� ��� strOb.
	    strOb.showType();

	    // �������� � ���������� �������� strOb
	    // (����� ��, ��� ������� �������������� �����)
	    String str = strOb.getob();
	    System.out.println("��������: " + str);
	  }
	}