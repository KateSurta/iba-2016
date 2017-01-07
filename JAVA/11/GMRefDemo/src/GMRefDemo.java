// ������ ������������� ������ �� ���������� �����,
// ����������� � ������������ ������

// ��, ���������� �� ���� ������ ����� �������� � ��������� ������,
// � ������������ ����� �����
interface MyFunc<T> {
  int func(T[] vals, T v);
}

// ���������� ����� countMatching() ���������� ����� ��������� �������,
// ������ �������� �������� (�.�. "������������� ����������")
class MyArrayOps {
  static <T> int countMatching(T[] vals, T v) {
    // ������� ����������
	int count = 0;
    // ����� �������
    for(int i=0; i < vals.length; i++)
      if(vals[i] == v) count++;
    // ���������� ���������
    return count;
  }
}

// ���������
class GMRefDemo {

	  // ����� myOp ����� ��� ���������:
	  // - �� (������� ������ ��������� ���� ������)
	  // - ������ ����� �������� (������ ��� ���������)
	  // - ��� ���� (���������) ������ _����_��_ ����
	  static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
	    return f.func(vals, v);
	  }

	  public static void main(String args[])
	  {
		// ��������� ��� ������� �������� ������� ����
	    Integer[] vals = { 1, 2, 3, 4, 2, 3, 4, 4, 5 };
	    String[] strs = { "������", "������", "�����", "�����" };
	    int count;

	    // ��������� ����� myOp � ������ Integer, ��� ��� ������������� ��������� ��
	    count = myOp(MyArrayOps::<Integer>countMatching, vals, 4);
	    System.out.println("vals �������� " + count + " �������� 4");

	    // ��������� ����� myOp � ������ Integer, ��� ��� ������������� ��������� ��
	    count = myOp(MyArrayOps::<String>countMatching, strs, "������");
	    System.out.println("strs �������� " + count + " �������� ������");
	  }
	}