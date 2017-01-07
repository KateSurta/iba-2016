package MyPack;

// класс, реализующий "выдачу баланса"
class Balance {
	  // переменные - имя пользователя и баланс
	  String name;
	  double bal;
	  // конструктор
	  Balance(String n, double b) {
	    name = n;
	    bal = b;
	  }
	
	  // "показательный" метод
	  void show() {
	    if(bal<0)
	      System.out.print("--> ");
	    System.out.println(name + ": $" + bal);
	  }
	}