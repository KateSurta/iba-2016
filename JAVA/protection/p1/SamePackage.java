package p1;

// ����� "�� ���������", �� � ��� �� ������, ��� � Base

class SamePackage {  
	
	SamePackage() {
    
		Base p = new Base();
		System.out.println("����� � ��� �� ������");

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