// ������ ������ �� ����������� �����

// �� ��� �������� �� ��������
interface StringFunc {
  String func(String n);
}

// �����, ��� ������ �� ����� ��������
class MyStringOps {
  // ����������� �����, ����������� �������� ������
  static String strReverse(String str) {
      String result = ""; 
      int i;

      for(i = str.length()-1; i >= 0; i--)
        result += str.charAt(i);

      return result;
  }
  
  // ����� ���������� (�������� ������ � �������� ��������)
  String strUp(String str) {
      String result = ""; 
      result = str.toUpperCase();

      return result;
  }
}

// ���������
class SMRefDemo {

  // ����� ��������� �� ��� ������ ��������
  // ��������������, ��� ����� �������� ����� ��������� ��,
  // ������� ������ �� �����
  // ������ �������� - �������������� ������
  static String stringOp(StringFunc sf, String s) {
    return sf.func(s);
  }

  public static void main(String args[])
  {
    String inStr = "������-��������� ��� ����";
    String outStr;

    // �������� ����� stringOp, ��������� ��� ������ �� ����������� ����� � ���� ������ ��� ���������
    outStr = stringOp(MyStringOps::strReverse, inStr);

    System.out.println("�������� ����������� ����� (��������)");
    System.out.println("����: " + inStr);
    System.out.println("�����: " + outStr);
    System.out.println();
    

    // ������ ������� ��������� MyStringOps
    MyStringOps strOps = new MyStringOps( );
    // � �������� ������ stringOp() ������ �� ����� ����� ����������
    outStr = stringOp(strOps::strUp, inStr);
    
    System.out.println("�������� ����� ���������� (�������)");
    System.out.println("����: " + inStr);
    System.out.println("�����: " + outStr);
    System.out.println();
    
  }
}