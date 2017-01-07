// ������ ����������� ������
class GenMethDemo {

  // ���������� ����� - ����������, ���������� �� ������ T � ������� V
  // ��������: ��� ������� ������ ���� ��������� � ����� �������� �������
  // �������� �������� �� ����������:
  // static - ��� �������� �����������
  // <T extends Comparable<T>, V extends T> - �������� ���� 
  // (������������ �� Comparable ��������� ��� ��������� ������ equals();
  // ������������ V �� T ����������� ������������� ������������� ������� � ��������� �������)
   // boolean - ��� ������������� ��������
  static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
    for(int i=0; i < y.length; i++)
      if(x.equals(y[i])) return true;

    return false;
  }

  // ����� �����
  public static void main(String args[]) {

	    // ������� �� Integer:
	    // ������� ������
	    Integer nums[] = { 1, 2, 3, 4, 5 };
	    // ��������� �����
	    // �������� ��������:
	    // ����� ��� ���������� ���� ����������
	    // � �� �� ����� ��������� ���� - ���� ����� ������� � ���:
	    // GenMethDemo.<Integer, Integer>isIn(2, nums)
	    if(isIn(2, nums))
	      System.out.println("2 ���������� � ������� nums");
	    if(!isIn(7, nums))
	      System.out.println("7 �� ���������� � ������� nums");
	    System.out.println();

	    // ������� �� String.
	    String strs[] = { "������", "�����", "������","����", "�������" };
	    // ����...
	    if(isIn("������", strs))
	      System.out.println("������ ���������� � ������� strs");

	    if(!isIn("����� ������", strs))
	      System.out.println("����� ������ �� ���������� � ������� strs");

	    // �� ��������� - String �� �������� ���������� Integer
	    // �� ����������� ������� "V extends T" �� ���������� ������ isIm()
	    // Java ���� ��������� ������������ �����
	    // if(isIn("two", nums))
	    //     System.out.println("two is in strs");
	  }
	}