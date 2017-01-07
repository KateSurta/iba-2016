// ������������ ��� �����, � �������� ���� ����������, ������ � �����������
enum Apple {
  Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

  private int price; // ���������� (���� �����)

  // ����������� � ��������� ����
  Apple(int p) { price = p; }
  
  // ����������� �� ���������
  Apple() { price = -1; }


  // �����
  int getPrice() { return price; }
}

class AppleDemo3 {
  public static void main(String args[])
  {
    // ���������� ���� ����� Winesap.
    System.out.println("Winesap �����" + Apple.Winesap.getPrice() + " �.\n");

    // ���������� ������ ���� ������ � ������. 
    System.out.println("��� ����� � ������:");
    for(Apple a : Apple.values())
      System.out.println(a + " ����� " + a.getPrice() + " �.");
  }
}