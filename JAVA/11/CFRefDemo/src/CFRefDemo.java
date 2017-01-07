// ������ ������������� ������ �� �����������

// MyFunc - ��, ������������ ������ �� MyClass
interface MyFunc {
   MyClass func(int n);
}

// ���������� �������������� �����
class MyClass {
  // ����������-����������
  private int val;

  // ����������� � ����������
  MyClass(int v) { val = v; }

  // ����������� �� ���������
  MyClass() { val = 0; }

  // ���������� ��������
  int getVal() { return val; };
}

// ���������
class CFRefDemo {
	  public static void main(String args[])
	  {
	    // ������� ������ �� ����������� MyClass
	    // (��������� ���������� � ������)
		// ��������� func() � �� MyFunc ��������� ��������,
	    // �� � ������ ���������� ��������� �� ����������������� �������
		// ������������ MyClass, � �� �� ����������� �� ���������
	    MyFunc myClassCons = MyClass::new;

	    // ������� ��������� MyClass ����� ������ �� �����������
	    // ������� ��������������: ������� �������
	    MyClass mc = myClassCons.func(100);

	    // ���������, �������� �� �������������� ������
	    System.out.println("�������� mc ����� " + mc.getVal( ));
	  }
	}