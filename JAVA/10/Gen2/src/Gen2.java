// ������ �������� ���������

// ���������� ����������
class Gen<T> {
  T ob; // ���������� ���������� T

  // ������� ����������� 
  Gen(T o) {
	    ob = o;
	  }

  // ����� �����������
	  T getob() {
	    return ob;
	  }
	}


// ���������� ��������
	class SubGen<T, V> extends Gen<T> {
	  // ��������� ��� ���� ����������
	  V ob2;

	  // �������� ��������: ����������� �������� _���_ ��������� ����
	   SubGen(T o, V o2) {
		// ���� ���������� ��������
	    super(o);
	    // ������ ������������ ����
	    ob2 = o2;
	  }

	  // ����� ��� ������ ����� ����������
	  V getob2() {
	    return ob2;
	  }
	}

	// ���������
	class Gen2 {
	  public static void main(String args[]) {

	    // ������� ������ SubGen ��� ���������� String � Integer.
	    SubGen<String, Integer> x =   new SubGen<String, Integer>("�������� �����: ", 99);
	    // ������� ����������
	    System.out.print(x.getob());
	    System.out.println(x.getob2());
	  }
	}