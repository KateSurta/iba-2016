// ������ ������������� ���������������� ������� ������������

// ��� �� �� ����� �����
enum Apple {
  Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

class AppleDemo2 {
  public static void main(String args[])
  {
    Apple ap;

    System.out.println("��������� ��������� ������������ Apple:");
    // ���������� values()
    Apple allapples[] = Apple.values();
    for(Apple a : allapples)
      System.out.println(a);

    System.out.println();

    // ���������� valueOf()
    ap = Apple.valueOf("Winesap");
    System.out.println("ap �������� " + ap);

  }
}