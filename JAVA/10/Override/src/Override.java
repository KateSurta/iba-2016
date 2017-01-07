// ������ ��������������� ������� � ���������� �������

// ������������ �����
class Gen<T> {
  T ob; // ���������� ���� T

  // �����������
  Gen(T o) {
    ob = o;
  }

  // ����� �������� ob.
  T getob() {
    System.out.print("����� getob() ������ Gen: " );
    return ob;
  }
}

// ��������
class Gen2<T> extends Gen<T> {
// �����������
Gen2(T o) {
 super(o);
}
// �������������� ����� ������������� ������
// Override getob().
T getob() {
	System.out.print("����� getob() ������ Gen2: " );
 return ob;
}
}

// ���������
class Override {
public static void main(String args[]) {

 // ������� Gen-������ ��� Integer
 Gen<Integer> iOb = new Gen<Integer>(88);

 // ������� Gen2-������ ��� Integer
 Gen2<Integer> iOb2 = new Gen2<Integer>(99);

 // ������� Gen2-������ ��� String
 Gen2<String> strOb2 = new Gen2<String> ("���� ���������");

 // �������� ������ ����� �������
 System.out.println(iOb.getob());
 System.out.println(iOb2.getob());
 System.out.println(strOb2.getob());
}
}