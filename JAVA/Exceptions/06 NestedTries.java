// ������ ��������� ���������� try
public class NestedTries {
  public static void main(String args[]) {
    try {
      // ���������� ����� ����������
      int a = args.length;

      // ���� �� ��� - ����� �� ����
      int b = 42 / a;

       System.out.println("a = " + a);

       try { // ��������� try
        // ���� ���� �������� ���� - �� ����� �� ���� �� ��������� �����
        if(a==1) a = a/(a-a); // division by zero

        // ���� ���������� ��� - ������� �� ����� �������
        if(a==2) {
           int c[] = { 1 };
           c[42] = 99; 
        }
      } catch(ArrayIndexOutOfBoundsException e) {
        System.out.println("����� �� ������� �������: " + e);
      }
    } catch(ArithmeticException e) {
      System.out.println("������� �� 0: " + e);
    }
  }
}