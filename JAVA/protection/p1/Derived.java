package p1;

class Derived extends Base {
	  Derived() {

		Base p = new Base();
		System.out.println("�����-��������� � ��� �� ������");

		// ������ � ���������� ��� ������������ - ��������
		System.out.println("nNoModificator = " + p.nNoModificator);
		
		// ������ � private-���������� - �� ��������!
		// System.out.println("n_pri = " + p.n_pri);
		
		// ������ � protected-����������  - ��������
		System.out.println("nProtected = " + p.nProtected);
		
		// ������ � public-����������  - ��������
		System.out.println("nPublic = " + p.nPublic);  
	  }
	}