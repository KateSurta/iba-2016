// ������ ��������� ��������:
// ������������ �������� � ���������� �������

// ������������ ��������
class NonGen {
  int num; //������������ ����������

  // �����������
  NonGen(int i) {
    num = i;
  }
 // ����� �����������
  int getnum() {
    return num;
  }
}

// ��������� �������
class Gen<T> extends NonGen {
  T ob; // ���������� ���� T

  // �������� � ����������� � T (��� �������),
  // � ����� (��� ��������)
  Gen(T o, int i) {
	// ����� ��������
    super(i);
    // ������ �������� - �������
    ob = o;
  }

  // ���������� ���������� �������
  T getob() {
    return ob;
  }
}

// ���������
class SubGen2 {
public static void main(String args[]) {
 // ������� ������ Gen ��� String
 Gen<String> w = new Gen<String>("������, ���", 47);
 // ������� ��� ����������
 System.out.print(w.getob() + " ");
 System.out.println(w.getnum());
}
}

