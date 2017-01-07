package p2;

import p1.Base;

class OtherPackage {
	
	  OtherPackage() {
			Base p = new Base();
			System.out.println("Класс не наследник из другого пакета");

			// доступ к переменной без модификатора - не работает
			// System.out.println("nNoModificator = " + p.nNoModificator);
			
			// доступ к private-переменной - не работает
			// System.out.println("n_pri = " + p.nPrivate);
			
			// доступ к protected-переменной  - не работает
			// System.out.println("nProtected = " + p.nProtected);
			
			// доступ к public-переменной  - работает
			System.out.println("nPublic = " + p.nPublic);  
		  }

}
