import java.util.Random;

// возможные варианты ответов
enum Answers {
  NO, YES, MAYBE, LATER, SOON, NEVER
}

class Question {
  // генерируем случайное число от 0 до 1
  Random rand = new Random();
  
  // метод, возвращающий случайную именованную константу
  Answers ask() {
  int prob = (int) (100 * rand.nextDouble());

    if (prob < 15)
      return Answers.MAYBE; // 15%
    else if (prob < 30)
      return Answers.NO;    // 15%
    else if (prob < 60)
      return Answers.YES;   // 30%
    else if (prob < 75)
      return Answers.LATER; // 15%
    else if (prob < 98)
      return Answers.SOON;  // 13%
    else
      return Answers.NEVER; // 2%
  }
}

// демонстрационный класс
class AskMe {
	
	 //  для преобразования константы в "читабельный" ответ
	  static void answer(Answers result) {
	    switch(result) {
	      case NO:
	        System.out.println("No");
	        break;
	      case YES:
	        System.out.println("Yes");
	        break;
	      case MAYBE:
	        System.out.println("Maybe");
	        break;
	      case LATER:
	        System.out.println("Later");
	        break;
	      case SOON:
	        System.out.println("Soon");
	        break;
	      case NEVER:
	        System.out.println("Never");
	        break;
	    }
	  }
	  
	  // генерируем пять случайных "ответов"
	  public static void main(String args[]) {
		    Question q = new Question();
		    answer(q.ask());
		    answer(q.ask());
		    answer(q.ask());
		    answer(q.ask());
		  }
		}