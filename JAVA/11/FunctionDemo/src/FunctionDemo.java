// ������ ������������� ����������� �� Function

// ������ ����� ���������� ��� 
import java.util.function.Function;


class FunctionDemo {
  public static void main(String args[])
  {
    // ������� ������������������ ��������� ������������ �� Function
	// � �������� � ��� ������������ ����� ������� �� � ����������� ���������� �����
	// �������� �������� �� ������� ������������� ���������� �� � ������ ��
	// (Integer �� �����, Integer �� ������)
    Function<Integer, Integer> factorial = (n) ->  {
      int result = 1;
      for(int i=1; i <= n; i++)
        result = i * result;
      return result;
    };
    // ��������� ���������
    System.out.println("��������� ����� 5 ����� " + factorial.apply(5));
  }
}