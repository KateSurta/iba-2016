// ������ ������� ���������� �� ���������� �������

// ��������� ��
interface MyFunc {
  int func(int n);
}

// ���������
class VarCapt {
  public static void main(String args[])
  {
    // ��������� ���������� ��� �������
    int num = 10;

    // ������� ������ �� �� � �� ��� ���
    MyFunc myLambda = (n) ->  {
      // ��� ����� - �������� num �� ��������
      int v = num + n;

      // � ��� ��� ������ - ��� ������� ����������� ��������� num
      //    num++;
      return v;
    };

    // ���� ������ - �� ��� �� ��������
    //  num = 9;
  }
}