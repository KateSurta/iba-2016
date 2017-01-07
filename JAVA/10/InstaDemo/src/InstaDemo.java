// ������ ������������� ��������� instanceof ��� �������� ���������� �������

// ������� ���������� �����
class Gen<T> {
  // ����������
  T ob;
  // �����������
  Gen(T o) {
    ob = o;
  }
  // ����� ����������
  T getob() {
    return ob;
  }
}

// ���������� ��������
class Gen2<T> extends Gen<T> {
  Gen2(T o) {
    super(o);
  }
}

// ���������
class InstaDemo {
public static void main(String args[]) {

 // ������� Gen-������ ��� Integer
 Gen<Integer> iOb = new Gen<Integer>(88);

 // ������� Gen2-������ ��� Integer
 Gen2<Integer> iOb2 = new Gen2<Integer>(99);

 // ������� Gen2-������ ��� Strings.
 Gen2<String> strOb2 = new Gen2<String>("���� ���������");

 // ����������, �������� �� iOb2 �������� Gen2
 if(iOb2 instanceof Gen2<?>)
   System.out.println("iOb2 - ��������� Gen2");
 // � ����������� Gen?
 if(iOb2 instanceof Gen<?>)
   System.out.println("iOb2 - ��������� Gen");

 System.out.println();

 // strOb2 - ������ Gen2?
 if(strOb2 instanceof Gen2<?>)
   System.out.println("strOb2 - ��������� Gen2");
 // � ����������� Gen?
 if(strOb2 instanceof Gen<?>)
   System.out.println("strOb2 - ��������� Gen");

 System.out.println();

 // iOb - ��������� Gen2? (�� ����� ���� ���)
 if(iOb instanceof Gen2<?>)
   System.out.println("iOb - ��������� Gen2");
 // � Gen? (��)
 if(iOb instanceof Gen<?>)
   System.out.println("iOb - ��������� Gen");

 // ���������� �� ��������� - �.�.
 // ��������� ���������������� �� ����� ����������
 // if(iOb2 instanceof Gen2<Integer>)
 //   System.out.println("iOb2 - ��������� Gen2<Integer>");
}
}