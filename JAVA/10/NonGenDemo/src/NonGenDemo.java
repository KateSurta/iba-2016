// ������ _���������������_ ���������
// �������������������� �����!
class NonGen {
  Object ob; // ob ������ ������ Object

  // � ����������� ���� �������� Object
  NonGen(Object o) {
    ob = o;
  }

  // ...��� �� � ���������� Object
  Object getob() {
    return ob;
  }

  // ���������� ��� ob
  void showType() {
    System.out.println("��� ob: " + ob.getClass().getName());
  }
}

// �����-������������
class NonGenDemo {
public static void main(String args[]) {
 NonGen iOb;

 // ������� ������ NonGen � �������� ���� Integer
 // ������������ ��������, ������
 iOb = new NonGen(88);

 // ���������� ��� iOb.
 iOb.showType();

 // �������� �������� iOb.
 // ��������� ������ ���������� �����!
 int v = (Integer) iOb.getob();
 System.out.println("��������: " + v);

 System.out.println();

 // ������� ������ ������ NonGen 
 // � �������� ���� String
 NonGen strOb = new NonGen("���� �����������");

 // ���������� ��� strOb.
 strOb.showType();

 // ���������� �������� strOb.
 // ����� ����� ������ ���������� �����! 
 String str = (String) strOb.getob();
 System.out.println("��������: " + str);

 // ������������� - �� ������������ �����������!
 iOb = strOb;
 v = (Integer) iOb.getob(); // � ��� ������� �������� ������
}
}