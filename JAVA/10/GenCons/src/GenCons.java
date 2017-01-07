// ������ ����������� ������������
class GenConsSample {
  // ������������ (��������) ����
  private double val;

  // ���������� ����������� ������������
  // �������� �������� - "�� ����" ����������� ������ �����!
  // Java ������������ �������� �����, � doubleValue() ��������� �������� � ������ �������
  <T extends Number> GenConsSample(T arg) {
    val = arg.doubleValue();
  }

  // ����� ��� ����������� ����
  void showval() {
    System.out.println("��������: " + val);
  }
}

// ���������
class GenCons {
  public static void main(String args[]) {

	// ������� ��� �������
    GenConsSample test = new GenConsSample(100);
    GenConsSample test2 = new GenConsSample(123.5F);
    // � ���������� �� ��������
    test.showval();
    test2.showval();
  }
}