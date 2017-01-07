package p2;

class DerivedOtherPackage extends p1.Base{
	
	DerivedOtherPackage() { 
			System.out.println("Класс-наследник в другом пакете");

			// доступ к переменной без модификатора - не работает
			// System.out.println("nNoModificator = " + nNoModificator);
			
			// доступ к private-переменной - не работает
			// System.out.println("n_pri = " + nPrivate);
			
			// доступ к protected-переменной  - работает
			System.out.println("nProtected = " + nProtected);
			
			// доступ к public-переменной  - работает
			System.out.println("nPublic = " + nPublic);  
		    }

}
