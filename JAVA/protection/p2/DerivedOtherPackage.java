package p2;

class DerivedOtherPackage extends p1.Base{
	
	DerivedOtherPackage() { 
			System.out.println("�����-��������� � ������ ������");

			// ������ � ���������� ��� ������������ - �� ��������
			// System.out.println("nNoModificator = " + nNoModificator);
			
			// ������ � private-���������� - �� ��������
			// System.out.println("n_pri = " + nPrivate);
			
			// ������ � protected-����������  - ��������
			System.out.println("nProtected = " + nProtected);
			
			// ������ � public-����������  - ��������
			System.out.println("nPublic = " + nPublic);  
		    }

}
