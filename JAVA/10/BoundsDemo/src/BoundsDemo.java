// указываем "верхнюю границу" для параметров типа
// для обобщенного класса Stats
// T теперь может быть или Number, или одним из его наследников
class Stats<T extends Number> {
  T[] nums; // массив Number или его наследников (точно чисел)

  // передаем в конструктор массив чисел
  Stats(T[] o) {
    nums = o;
  }

  // возвращаем среднее (типа double)
  double average() {
    double sum = 0.0;

    for(int i=0; i < nums.length; i++)
      sum += nums[i].doubleValue(); // точно сработает

    return sum / nums.length;
  }
}

// демокласс
class BoundsDemo {
public static void main(String args[]) {

 // создаем массив целых чисел...
 Integer inums[] = { 1, 2, 3, 4, 5 };
 // ..и помещаем в ограниченный обобщенный класс
 Stats<Integer> iob = new Stats<Integer>(inums);
 // вычисляем и выводим среднее
 double v = iob.average();
 System.out.println("Среднее iob: " + v);

 // повторяем для дробных
 Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
 Stats<Double> dob = new Stats<Double>(dnums);
 double w = dob.average();
 System.out.println("Среднее dob: " + w);

 // со строками не сработает!
 // String strs[] = { "1", "2", "3", "4", "5" };
 // Stats<String> strob = new Stats<String>(strs);
 // double x = strob.average();
 // System.out.println("Среднее strob: " + v);

}
}