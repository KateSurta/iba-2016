// ������ �������� ������-���������

// ������ �� ��� ����������
interface MyNumber {
  // ������������ (� �����������) �����
  double getValue();
}

// �� � ���������� (�����)
interface NumericTest {
	boolean test(int n);
}

// �� � ����� int-����������� � boolean-����������� 
interface NumericTest2 {
	  boolean test(int n, int d);
	}


// ���������
class LambdaDemo {
  public static void main(String args[])
  {
    MyNumber myNum;  // ������ �� ��������� ��� ����������

    // ������-��������� � ������ ������ - ��� ������ ����������� ���������
    // (��� ������� ���������� � ���������� ������ ���� � �� ��)
    
    // ��� ������������ ��������� ������ myNum ������������� ���������� ���������:
    // 1. ��������� ��������� ���������� ������, ������������ ��������� myNum
    // (�������� ������-�� myNum ���� �� �����, �.�. ��� ��������� - �.�. ����������� �����)
    // 2. ��� ������-��������� ���������� � ����� getValue()
    // �� ������ ���������� �����, � ����� ������ ����� �������� ��� ��? � ������ ��� )
     myNum = () -> 123.45;

    // ������� getValue(), �� ���������� ��������� ��� ������-���������
    System.out.println("����-��������: " + myNum.getValue());

    // ������ ������������ ���� ������ �� �� ������� �� 
    // (������ � getValue() ������������� ������ ����������)
    myNum = () -> Math.random() * 100;

    // � �������� ���
    System.out.println("��������� ��������: " + myNum.getValue());
    System.out.println("��� ���� ��������� ��������: " + myNum.getValue());

    // �������� ��������: ������-��������� ������ ���� ����������
    // �� ������� ���������� � ������������� �������� � ������� �� 
    //  myNum = () -> "123.03"; // ������!!! ������ double � �� ������������ String
    
    
    // ������ ���������� � �����������
    // ����� �� �������� ����� ��������, ���������� ����������
    // �� ������ �� �� ����� (��������� �������� ����������� �����)
    // ��� ��������� ��������� �� ��������� (� ������ ������, �� ���������� ������)
    NumericTest isEven = (n) -> (n % 2)==0;
    // �������� ����� ��� ����������� ��������
    int k = 10;
    if(isEven.test(k)) {
    	System.out.println(k + " ������");
    }
    else {
    	System.out.println(k + " ��������");
    	}
    
    // �������������� ����� - ������ ��������� ����� �� ���������������
    // (���������� � ���������� � ������������� �������� �� ��)
    NumericTest isNonNeg = (n) -> n >= 0;
    // � ��������� ��� ������
    if(isNonNeg.test(k)) {
    	System.out.println(k + " �� �������������");
    }
    else
    {
    	System.out.println(k + " �������������");
    }
    

    
    // ������ �� � �� � ����� int-����������� � boolean-�����������
    // ���� ���������� ��������� �� ��������� (� ������ ������, �� ���������� ������)
    NumericTest2 isFactor = (n, d) -> (n % d) == 0;
    
    int l = 2;
    if(isFactor.test(k, l)) {
      System.out.println(l + " - ��������� " + k);
    }
    else
    {
      System.out.println(l + " - �� ��������� " + k);
      }
  }
}