package MyPack;

class AccountBalance {
	  public static void main(String args[]) {
	    // создаем массив из "балансов" (классы в пакете MyPack)
	    Balance current[] = new Balance[3];

	    current[0] = new Balance("Иван Иванов", 123.23);
	    current[1] = new Balance("Петр Петров", 157.02);
	    current[2] = new Balance("Непридумал Имени", -12.33);
	     for(int i=0; i<3; i++) current[i].show();
	  }
	}