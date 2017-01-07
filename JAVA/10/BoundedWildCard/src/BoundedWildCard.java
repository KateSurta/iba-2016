// пример применения ограниченных метасимвольных аргументов
// три вида объектов: двумерные, трехмерные и четырехмерные координаты
// и плюс набор методов, специфичных для координат разного вида

// двумерные координаты
class TwoD {
  // два измерения
  int x, y;
  // "двухмерный" конструктор
  TwoD(int a, int b) {
    x = a;
    y = b;
  }
}

// трехмерные координаты
class ThreeD extends TwoD {
  // добавляем третье
  int z;
  // "трехмерный" конструктор
  ThreeD(int a, int b, int c) {
    super(a, b);
    z = c;
  }
}

// четырехмерные координаты
class FourD extends ThreeD {
// добавляем четвертое изменение
int t;
// "четырехмерный" конструктор
FourD(int a, int b, int c, int d) {
 super(a, b, c);
 t = d;
}
}

// параметризованный класс для хранения массива координат (все равно каких)
class Coords<T extends TwoD> {
// сам массив
T[] coords;
// конструктор
Coords(T[] o) { coords = o; }
}


// демокласс
class BoundedWildCard {

// метод для отображения двух координат 
// (работает на координатах любых видов
// - потому применяем метасимвольный аргумент)
static void showXY(Coords<?> c) {
 System.out.println("Координаты X Y: ");
 for(int i=0; i < c.coords.length; i++)
   System.out.println(c.coords[i].x + " " + c.coords[i].y);
 System.out.println();
}

// метод для отображения трех координат 
// (работает только на трех- и четырехмерных координатах
// - потому применяем ограниченный метасимвольный аргумент 
// ("ограничение сверху"))
static void showXYZ(Coords<? extends ThreeD> c) {
 System.out.println("Координаты X Y Z: ");
 for(int i=0; i < c.coords.length; i++) 
     System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
System.out.println();
}

// метод для отображения четырех координат 
// (работает только на четырехмерных (и потенциально более) координатах
// - потому снова применяем ограниченный метасимвольный аргумент 
// ("ограничение сверху") - но другого вида)
static void showAll(Coords<? extends FourD> c) {
System.out.println("Координаты X Y Z T: ");
for(int i=0; i < c.coords.length; i++)
System.out.println(c.coords[i].x + " " + c.coords[i].y + " " +
             c.coords[i].z + " " + c.coords[i].t);
System.out.println();
}

// собственно точка входа программы
public static void main(String args[]) {
// создаем массив двухмерных координат
TwoD td[] = {
new TwoD(0, 0),
new TwoD(7, 9),
new TwoD(18, 4),
new TwoD(-1, -23)
};
// и помещаем его в наш параметризованный объект
Coords<TwoD> tdlocs = new Coords<TwoD>(td);
// а потом выводим его содержимое
System.out.println("Содержимое tdlocs.");
showXY(tdlocs); // сработает - подходит для двухмерных координат
//showXYZ(tdlocs); // не сработает - нужно не менее трех координат
//showAll(tdlocs); // не сработает - нужно не менее четырех координат


// теперь создаем массив четырехмерных координат 
FourD fd[] = {
  new FourD(1, 2, 3, 4),
  new FourD(6, 8, 14, 8),
  new FourD(22, 9, 4, 9),
  new FourD(3, -2, -23, 17)
};
// и помещаем его в параметризованный объект
Coords<FourD> fdlocs = new Coords<FourD>(fd);
// а затем выводим его содержимое
System.out.println("Содержимое fdlocs.");
showXY(fdlocs); // сработает: четыре не менее двух
showXYZ(fdlocs);// сработает: четыре не менее трех 
showAll(fdlocs);// сработает: четыре не менее четырех
}
}