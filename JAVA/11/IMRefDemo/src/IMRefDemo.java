// ������ ������������� ������ �� ����� ���������� � ������� ���������

// ��, ����������� ��� ������ � ������������ boolean
interface MyFunc<T> {
  boolean func(T v1, T v2);
}

// ����� ��� �������� ������������ ����������� �� ����
class HighTemp {
  // ���������� ���������� � ������������
  private int hTemp;
  // ������� �����������
  HighTemp(int ht) { hTemp = ht; }
  // ���������� true, ���� ���������� ������ ����� �� �� �����������, ��� � ht2.
  boolean sameTemp(HighTemp ht2) {
    return hTemp == ht2.hTemp;
  }
  //   // ���������� true, ���� ���������� ������ ����� �������, ��� � ht2.
  boolean lessThanTemp(HighTemp ht2) {
    return hTemp < ht2.hTemp;
  }
}

// ���������
class IMRefDemo {

	  // ����� ���������� ����� ��������, ���������� ��� ��������, 
	  // ���������� ���������� �� MyFunc
	  // ���������:
	  // T[] vals - ������ �������� ��� ���������
	  // MyFunc<T> f - ����� ����������� "��������"
	  // T v - ��������� ������ ��� ���������
	  // ������������ �������� - �����
	  static <T> int counter(T[] vals, MyFunc<T> f, T v) { 
		    int count = 0;
		    // �������� �� ����� �������
		    for(int i=0; i < vals.length; i++)
		      // ���� ������� ������ "��������", ���������� �������
		      if(f.func(vals[i], v)) count++;
		    // ���������� ���������
		    return count;
		  }

		  public static void main(String args[])
		  {
		    int count;

		    // ������� ������ �������� HighTemp (� ������� - �����������)
		    HighTemp[] weekDayHighs = { new HighTemp(25), new HighTemp(23),
		                                new HighTemp(29), new HighTemp(25),
		                                new HighTemp(27), new HighTemp(30),
		                                new HighTemp(24), new HighTemp(27) };

		    // ������� ����� ��������, ��� ����������� _���������_ (HighTemp::sameTemp)
		    // � ������������ ���������� ������� (HighTemp(25))
		    count = counter(weekDayHighs, HighTemp::sameTemp, new HighTemp(25));
		    System.out.println(count + " ���� ����� ����������� 25 ��������");


		    // ������ ���������� ������ �� ����� lessThanTemp(), ����� 
		    // ����� ��� � ������������ ������ ������������� ��������
		    count = counter(weekDayHighs, HighTemp::lessThanTemp, new HighTemp(27));
		    System.out.println(count + " ���� ����� ����������� ����� 27 ��������");

		    
	  }
}