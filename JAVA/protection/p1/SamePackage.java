package p1;

// класс "не наследник", но в том же пакете, что и Base

class SamePackage {  
	
	SamePackage() {
    
		Base p = new Base();
		System.out.println("Класс в том же пакете");

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