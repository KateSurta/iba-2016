// �������:
// 1. ������� �������� ��� � ��������� ��������� �������
// 2. �������� ��� ���� �����, ����������� ���������, � ���.��������
// 3. ����������� ������� ���.����� ������ �� �.2 ����� ���������� ������� � ���������� ����������
// 4*. �������� ����� � ����������� �� ���������
// 5*. �������� ����������� ����� � ������� ��� � ����-������



public class StackDemo {
	 public static void main(String args[]) {

		    // ����� 01
		    // ������� ��� ����� �������������� �������
		    FixedStack myFixedSack1 = new FixedStack(5);
		    FixedStack myFixedSack2 = new FixedStack(8);

		    // ��������� ��
		    for(int i=0; i<5; i++) myFixedSack1.push(i);
		    for(int i=0; i<8; i++) myFixedSack2.push(i);

		    // ��������� ��������
		    System.out.println("���� myFixedSack1:");
		    for(int i=0; i<5; i++)
		       System.out.println(myFixedSack1.pop());

		    System.out.println("���� myFixedSack2:");
		    for(int i=0; i<8; i++)
		       System.out.println(myFixedSack2.pop());
		    
		    // ����� 02
		    // ��� ������������ �����
		    DynStack myDynStack1 = new DynStack(5);
		    DynStack myDynStack2 = new DynStack(8);

		    // ��������� �� (�������� ��������� �������)
		    for(int i=0; i<12; i++) myDynStack1.push(i);
		    for(int i=0; i<20; i++) myDynStack2.push(i);

		    // � ����� ���������� ����������
		    System.out.println("���� myDynStack1:");
		    for(int i=0; i<12; i++)
		       System.out.println(myDynStack1.pop());

		    System.out.println("���� myDynStack2:");
		    for(int i=0; i<20; i++)
		       System.out.println(myDynStack2.pop());

		    // ����� 03
		    // ���������� ����������!!!
		    IntStack mystack; 
		    // ��� ������� "���������" ������
		    DynStack ds = new DynStack(5);
		    FixedStack fs = new FixedStack(8);

		    // ���������� � �������
		    mystack = ds; 
		    // � ��������� ���
		    for(int i=0; i<12; i++) mystack.push(i); 
		    // ���������� �� �������
		    mystack = fs; 
		    // � ���� ��� ���������
		    for(int i=0; i<8; i++) mystack.push(i);

		    // � ������ ���������� ����������
		    mystack = ds;
		    System.out.println("������������ ����:");
		    for(int i=0; i<12; i++)
		       System.out.println(mystack.pop());

		    mystack = fs;
		    System.out.println("������������� ����:");
		    for(int i=0; i<8; i++)
		       System.out.println(mystack.pop());

		  }

}
