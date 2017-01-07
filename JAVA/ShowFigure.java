// Задание:
// 1. Изучить исходный код и построить диаграмму классов
// 2. Доработать абстрактный класс, добавив туда, например, вычисление периметра фигуры
// 3. Создать еще один подкласс для класса Figure (например, круг или квадрат)

// абстрактный класс "фигура"
abstract class Figure {
  double dim1;
  double dim2;

  //.. и его конструктор
  Figure(double a, double b) {
    dim1 = a;
    dim2 = b;
  }

  // абстрактный метод вычисления площади
  abstract double area();
}

// класс Прямоугольник, реализующий абстрактную "фигуру"
class Rectangle extends Figure {
  // его конструктор - определяем стороны
  Rectangle(double a, double b) {
    super(a, b);
  }

  // переопределенный метод вычисления площади
  double area() {
    System.out.println("Площадь прямоугольника: ");
    return dim1 * dim2;
  }
}

// // класс Треугольник, реализующий абстрактную "фигуру"
class Triangle extends Figure {
  // тоже конструктор - определяем катеты
  Triangle(double a, double b) {
    super(a, b);
  }

  // вычисление площади прямоугольного треугольника
  double area() {
    System.out.println("Площадь прямоугольного треугольника: ");
    return dim1 * dim2 / 2;
  }
}

// демонстрационный класс
class ShowFigure {
  public static void main(String args[]) {
    // Figure f = new Figure(10, 10); // нельзя! класс Figure абстрактный
    // создаем прямоугольник и треугольник
    Rectangle r = new Rectangle(9, 5);
    Triangle t = new Triangle(10, 8);
    // так можно - это просто переменная, объект "фигуры" мы не создаем
    Figure figref; 

    // вызываем метод area через переменную суперкласса - получаем площадь прямоугольника
    figref = r;
    System.out.println("Area is " + figref.area());

    // вызываем метод area через переменную суперкласса - получаем площадь треугольника
    figref = t; 
    System.out.println("Area is " + figref.area());
  }
}