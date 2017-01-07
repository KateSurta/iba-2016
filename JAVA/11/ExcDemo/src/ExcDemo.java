// ������ ������������� ���������� � ��

// ��������� ��
interface ArrayFunc {
  // �������� �������� �� �������� ��������� ����������
  double func(double[] n) throws EmptyArrayException;
}

// ��������� ����� ������������� ����������
class EmptyArrayException extends Exception {
  EmptyArrayException() {
    super("������ ����");
  }
}

// ���������
class ExcDemo {

  public static void main(String args[]) throws EmptyArrayException
  {
	// ������ ��� ���������
    double[] values  = { 1.0, 2.0, 3.0, 4.0 };

    // ������� ������ �� ��������� ��
    // � �������� � ��� ������� �� ��� ���������� �������� �������� �������
    ArrayFunc average = (n) ->  {
      double sum = 0;

      // ���� ������ ���� - ���������� ����������
      // ��� ������ ���� ���������� � ����������� ������ � ��!
      if(n.length == 0)
        throw new EmptyArrayException();
      // ���� ��� � ������� - ������� � ���������� ���������
      for(int i=0; i < n.length; i++)
        sum += n[i];
      return sum / n.length;
    };

    // �������� ����� (�, �������������, ��)
    System.out.println("������� �����: " + average.func(values));

    // ������ ���������, ������������ �� ����������, ������� ����� ��� ������� �������
    System.out.println("������� �����: " + average.func(new double[0]));
  }
}