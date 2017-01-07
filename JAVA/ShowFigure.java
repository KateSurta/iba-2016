// �������:
// 1. ������� �������� ��� � ��������� ��������� �������
// 2. ���������� ����������� �����, ������� ����, ��������, ���������� ��������� ������
// 3. ������� ��� ���� �������� ��� ������ Figure (��������, ���� ��� �������)

// ����������� ����� "������"
abstract class Figure {
  double dim1;
  double dim2;

  //.. � ��� �����������
  Figure(double a, double b) {
    dim1 = a;
    dim2 = b;
  }

  // ����������� ����� ���������� �������
  abstract double area();
}

// ����� �������������, ����������� ����������� "������"
class Rectangle extends Figure {
  // ��� ����������� - ���������� �������
  Rectangle(double a, double b) {
    super(a, b);
  }

  // ���������������� ����� ���������� �������
  double area() {
    System.out.println("������� ��������������: ");
    return dim1 * dim2;
  }
}

// // ����� �����������, ����������� ����������� "������"
class Triangle extends Figure {
  // ���� ����������� - ���������� ������
  Triangle(double a, double b) {
    super(a, b);
  }

  // ���������� ������� �������������� ������������
  double area() {
    System.out.println("������� �������������� ������������: ");
    return dim1 * dim2 / 2;
  }
}

// ���������������� �����
class ShowFigure {
  public static void main(String args[]) {
    // Figure f = new Figure(10, 10); // ������! ����� Figure �����������
    // ������� ������������� � �����������
    Rectangle r = new Rectangle(9, 5);
    Triangle t = new Triangle(10, 8);
    // ��� ����� - ��� ������ ����������, ������ "������" �� �� �������
    Figure figref; 

    // �������� ����� area ����� ���������� ����������� - �������� ������� ��������������
    figref = r;
    System.out.println("Area is " + figref.area());

    // �������� ����� area ����� ���������� ����������� - �������� ������� ������������
    figref = t; 
    System.out.println("Area is " + figref.area());
  }
}