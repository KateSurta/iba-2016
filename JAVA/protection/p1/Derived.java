package p1;

class Derived extends Base {
	  Derived() {

		Base p = new Base();
		System.out.println("Класс-наследник в том же пакете");

		// доступ к переменной без модификатора - работает
		System.out.println("nNoModificator = " + p.nNoModificator);
		
		// доступ к private-переменной - не работает!
		// System.out.println("n_pri = " + p.n_pri);
		
		// доступ к protected-переменной  - работает
		System.out.println("nProtected = " + p.nProtected);
		
		// доступ к public-переменной  - работает
		System.out.println("nPublic = " + p.nPublic);  
	  }
	}