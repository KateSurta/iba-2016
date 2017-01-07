// ������ ������������� �� ��� ���������� ��

// ���������� ��
interface SomeFunc<T> {
  T func(T t);
}

// ���������
class GFIDemo {
  public static void main(String args[])
  {

    // ��������� String-������ ��
	// � ��������������� �� ��� ����
    SomeFunc<String> reverse = (str) ->  {
      // ����������
      String result = "";
      int i;
      // ��������
      for(i = str.length()-1; i >= 0; i--)
        result += str.charAt(i);
      // ���������� ��������� ���������
      return result;
    };
    System.out.println("������ �������� " + reverse.func("������"));

    
    // ������ ��������� Integer-������ ��
	// � ��������������� �� ��� ����
    SomeFunc<Integer> factorial = (n) ->  {
      // ����������
      int result = 1;
      // ���������
      for(int i=1; i <= n; i++)
        result = i * result;
      // ���������� �������� ���������
      return result;
    };

    System.out.println("��������� 5 ����� " + factorial.func(5));
  }
}