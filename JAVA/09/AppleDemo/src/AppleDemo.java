// ������ ������������ (����� �����)
enum Apple {
  Jonathan, GoldenDel, RedDel, Winesap, Cortland
}

class AppleDemo {
  public static void main(String args[])
  {
    Apple ap;

    ap = Apple.RedDel;

    // ������� �������� ����������.
    System.out.println("�������� ap: " + ap);
    System.out.println();

    ap = Apple.GoldenDel;

    // ��������� ��������
    if(ap == Apple.GoldenDel)
      System.out.println("ap �������� GoldenDel.\n");

    // ������������� � ���������
    switch(ap) {
      case Jonathan:
        System.out.println("Jonathan  - �������.");
        break;
      case GoldenDel:
          System.out.println("Golden Delicious - ������.");        break;
        case RedDel:
          System.out.println("Red Delicious - �������.");
          break;
        case Winesap:
          System.out.println("Winesap - �����-�������.");
          break;
        case Cortland:
          System.out.println("Cortland - �������.");
          break;
      }
    }
  }