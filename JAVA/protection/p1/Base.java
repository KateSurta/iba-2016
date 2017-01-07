package p1;

// класс-владелец переменных
public class Base {

	  // переменная без модификатора
	  int nNoModificator = 1;
	  // переменные с модификатором
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
