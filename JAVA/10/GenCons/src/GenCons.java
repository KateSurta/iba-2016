// пример обобщенного конструктора
class GenConsSample {
  // единственное (числовое) поле
  private double val;

  // объявление обобщенного конструктора
  // обратите внимание - "на вход" принимаются только числа!
  // Java обеспечивает контроль типов, а doubleValue() извлекает значение в нужном формате
  <T extends Number> GenConsSample(T arg) {
    val = arg.doubleValue();
  }

  // метод для отображения поля
  void showval() {
    System.out.println("Значение: " + val);
  }
}

// демокласс
class GenCons {
  public static void main(String args[]) {

	// создаем два объекта
    GenConsSample test = new GenConsSample(100);
    GenConsSample test2 = new GenConsSample(123.5F);
    // и отображаем их значения
    test.showval();
    test2.showval();
  }
}