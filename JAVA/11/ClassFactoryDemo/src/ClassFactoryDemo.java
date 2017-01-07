// ������ "������������" ������� �������, ������������ ������ �� ������������

// �� - �������� �� ���� ���� ������ � ���������� ������
interface MyFunc<R, T> {
   R func(T n);
}

// ������� ���������� �����
class MyClass<T> {
  // ������ - ������-"����������"
  private T val;

  // ����������� � ����������
  MyClass(T v) { val = v; }
 
  // ����������� ��� ��������� (��� �� �� ���������� - ��� ������)
  MyClass() { val = null; }

  // ��������� ����������
  T getVal() { return val; };
}


// ������� ������������ �����
class MyClass2 {
  // ������ - ������
  String  str;

  // ����������� � ����������
  MyClass2(String s) { str = s; }

  // ����������� ��� ��������� (��� �� �� ���������� - ��� ������)
  MyClass2() { str = ""; }

  // ��������� ����������
  String getVal() { return str; };
}


class ClassFactoryDemo {

	  // ��� � ��� ����� �������� �������� ("�������")
	  // � ������ ������������ ������� ����������� ������ ��������� ������ � �������� ��������� (T)
	  // R ����������, ������ ������ ���� �� ����� �������
	  static <R,T> R myClassFactory(MyFunc<R, T> cons, T v) {
	    return cons.func(v);
	  }

	  public static void main(String args[])
	  {
	    // ������� ������ �� ����������� MyClass (���, ������� � ����������)
	    MyFunc<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;
	    // ������� ������ MyClass � ������� "�������" � ��������� ��� ������������
	    MyClass<Double> mc = myClassFactory(myClassCons, 100.1);
	    // ��������� ���������
	    System.out.println("�������� mc ����� " + mc.getVal( ));

	    // ������� ��� ���� ������ �� ����������� (������ ������ MyClass2)
	    MyFunc<MyClass2, String> myClassCons2 = MyClass2::new;
	    // ������� � ������� ����� "�������" ������
	    MyClass2 mc2 = myClassFactory(myClassCons2, "� ������");
	    // � ��������� ���������
	    System.out.println("�������� mc2 ����� " + mc2.getVal( ));
	  }
	}