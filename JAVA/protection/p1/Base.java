package p1;

// �����-�������� ����������
public class Base {

	  // ���������� ��� ������������
	  int nNoModificator = 1;
	  // ���������� � �������������
	  private int nPrivate = 2;
	  protected int nProtected = 3;
	  public int nPublic = 4;

	  public void Base() {
	    System.out.println("base constructor");
	    System.out.println("nNoModificator = " + nNoModificator);
	    System.out.println("nPrivate = " + nPrivate);
	    System.out.println("nProtected = " + nProtected); 
	    System.out.println("nPublic = " + nPublic);
	  }
}
