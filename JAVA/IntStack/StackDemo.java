// Задание:
// 1. Изучить исходный код и построить диаграмму классов
// 2. Добавить еще один класс, реализующий интерфейс, с доп.методами
// 3. Попробовать вызвать доп.метод класса из п.2 через переменную объекта и переменную интерфейса
// 4*. Добавить метод с реализацией по умолчанию
// 5*. Добавить статический метод и вызвать его в демо-классе



public class StackDemo {
	 public static void main(String args[]) {

		    // Часть 01
		    // создаем два стека фиксированного размера
		    FixedStack myFixedSack1 = new FixedStack(5);
		    FixedStack myFixedSack2 = new FixedStack(8);

		    // заполняем их
		    for(int i=0; i<5; i++) myFixedSack1.push(i);
		    for(int i=0; i<8; i++) myFixedSack2.push(i);

		    // извлекаем элементы
		    System.out.println("Стек myFixedSack1:");
		    for(int i=0; i<5; i++)
		       System.out.println(myFixedSack1.pop());

		    System.out.println("Стек myFixedSack2:");
		    for(int i=0; i<8; i++)
		       System.out.println(myFixedSack2.pop());
		    
		    // Часть 02
		    // два динамических стека
		    DynStack myDynStack1 = new DynStack(5);
		    DynStack myDynStack2 = new DynStack(8);

		    // заполняем их (превышая начальные размеры)
		    for(int i=0; i<12; i++) myDynStack1.push(i);
		    for(int i=0; i<20; i++) myDynStack2.push(i);

		    // а потом отображаем содержимое
		    System.out.println("Стек myDynStack1:");
		    for(int i=0; i<12; i++)
		       System.out.println(myDynStack1.pop());

		    System.out.println("Стек myDynStack2:");
		    for(int i=0; i<20; i++)
		       System.out.println(myDynStack2.pop());

		    // Часть 03
		    // переменная интерфейса!!!
		    IntStack mystack; 
		    // два объекта "настоящих" стеков
		    DynStack ds = new DynStack(5);
		    FixedStack fs = new FixedStack(8);

		    // обращаемся к первому
		    mystack = ds; 
		    // и заполняем его
		    for(int i=0; i<12; i++) mystack.push(i); 
		    // обращаемся ко второму
		    mystack = fs; 
		    // и тоже его заполняем
		    for(int i=0; i<8; i++) mystack.push(i);

		    // а теперь показываем содержимое
		    mystack = ds;
		    System.out.println("Динамический стек:");
		    for(int i=0; i<12; i++)
		       System.out.println(mystack.pop());

		    mystack = fs;
		    System.out.println("Фиксированный стек:");
		    for(int i=0; i<8; i++)
		       System.out.println(mystack.pop());

		  }

}
