package p2;

import p1.Base;

class OtherPackage {
	
	  OtherPackage() {
			Base p = new Base();
			System.out.println("����� �� ��������� �� ������� ������");

			// ������ � ���������� ��� ������������ - �� ��������
			// System.out.println("nNoModificator = " + p.nNoModificator);
			
			// ������ � private-���������� - �� ��������
			// System.out.println("n_pri = " + p.nPrivate);
			
			// ������ � protected-����������  - �� ��������
			// System.out.println("nProtected = " + p.nProtected);
			
			// ������ � public-����������  - ��������
			System.out.println("nPublic = " + p.nPublic);  
		  }

}
