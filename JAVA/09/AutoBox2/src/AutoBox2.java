
class AutoBox2 {
  // �������� Integer �� ����, ���������� int
  static int m(Integer v) {
    return v ; // ��������������
  }

  public static void main(String args[]) {
    // �������� ������ m() int-�������� (����������� ������������ ���������)
	// ����� ������ Integer ������������� ��������������� � int
	// ��� �������� �������� ����� ��������� ������������
	// PS "pen-pineapple-apple-pen"(c) :)
    Integer iOb = m(100);

    System.out.println(iOb);
  }
}