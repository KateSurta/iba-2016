// ������ ������������� ������ �� ����������� ����������� ������

// MyFunc ���� ���������� ��
interface MyFunc<T> {
   MyClass<T> func(T n);
}

// ���������� ����������� �����
class MyClass<T> {
  // ������ ������ �������� ����� - ������ ����� ������
  private T val;

  // ����������� � ���������� (����������)
  MyClass(T v) { val = v; }

  // ����������� ��� ����������
  MyClass( ) { val = null;  }

  // ���������� �������� 
  // �������� �������� - ����� ���� � ��� �� ����������������� ���!
  T getVal() { return val; };
}


// ���������
class CGRefDemo {

  public static void main(String args[])
  {
    // ������� ������ �� ����������� ������������������� ���������� ����������� �� MyClass<T>
    MyFunc<Integer> myClassCons = MyClass<Integer>::new;

    // ������� ��������� MyClass<T>, ��������� ������ �� �����������
    MyClass<Integer> mc = myClassCons.func(100);

    // ��������� - ��� �� ���������
    System.out.println("�������� mc ����� " + mc.getVal( ));
  }
}