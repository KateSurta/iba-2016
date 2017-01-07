// Задание:
// 1. Изучить исходный код и построить диаграмму классов
// 2. Создать объекты "посылок" с импользованием всех вариантов конструкторов
// 3. Создать подкласс для класса Shipment (например, с разными способами или скоростью доставки)



// снова тот же исходный класс...
class Box {
  private double width;
  private double height;
  private double depth;
 
  // ... и его конструкторы
  // конструктор "по образцу"
  Box(Box ob) { 
    width = ob.width;
    height = ob.height;
    depth = ob.depth;
  }

  // конструктор по трем размерам
  Box(double w, double h, double d) {
    width = w;
    height = h;
    depth = d;
  }

  // конструктор по умолчанию
  Box() {
    width = -1;  
    height = -1; 
    depth = -1;  
  }

  // конструктор для куба
  Box(double len) {
    width = height = depth = len;
  }

  // вычисляем объем
  double volume() {
    return width * height * depth;
  }
}

// дочерний класс - "коробка с весом"
class BoxWeight extends Box {
  double weight; // переменная для веса

  // конструктор "по образцу"
  BoxWeight(BoxWeight ob) { 
    super(ob);
    weight = ob.weight;
  }

  // конструктор по всем параметрам
  BoxWeight(double w, double h, double d, double m) {
    super(w, h, d); // вызываем конструктор суперкласса (Box)
    weight = m;
  }

  // конструктор по умолчанию
  BoxWeight() {
    super();
    weight = -1;
  }
  // конструктор для куба с весом
  BoxWeight(double len, double m) {
    super(len);
    weight = m;
  }
}

// еще один дочерний класс - "коробка с весом и стоимостью доставки"
class Shipment extends BoxWeight {
  double cost; // переменная для стоимости доставки

  // конструктор об образцу
  Shipment(Shipment ob) { 
    super(ob); // вызываем конструктор суперкласса (BoxWeight)
    cost = ob.cost; // и добавляем стоимостью
  }

  // конструктор по всем параметрам
  Shipment(double w, double h, double d,
            double m, double c) {
    super(w, h, d, m); 
    cost = c;
  }

  // конструктор по умолчанию
  Shipment() {
    super();
    cost = -1;
  }

  // "куб с весом и стоимостью доставки"
  Shipment(double len, double m, double c) {
    super(len, m);
    cost = c;
  }
}


// демонстрационный класс
class ShowShipment {
  public static void main(String args[]) {

    // создаем два "отправления" по параметрам
    Shipment shipment1 =
               new Shipment(10, 20, 15, 10, 3.41);
    Shipment shipment2 =
               new Shipment(2, 3, 4, 0.76, 1.28);

    double vol;

    // ...и выводим их характеристики
    vol = shipment1.volume();
    System.out.println("Объем shipment1: " + vol);
    System.out.println("Вес shipment1: "
                        + shipment1.weight);
    System.out.println("Стоимость доставки: $" + shipment1.cost);
    System.out.println();
    vol = shipment2.volume();
    System.out.println("Объем shipment2: " + vol);
    System.out.println("Вес shipment2: "
                        + shipment2.weight);
    System.out.println("Стоимость доставки: $" + shipment2.cost);
  }
}