// пример использования метасимвольных аргументов
class Stats<T extends Number> {
  T[] nums; // массив чисел

  // все тот же конструкторв
  Stats(T[] o) {
    nums = o;
  }

  // вычисление среднего (типа double)
  double average() {
    double sum = 0.0;

    for(int i=0; i < nums.length; i++)
      sum += nums[i].doubleValue();
    return sum / nums.length;
  }

  // сравнение средних значений
  // обратите внимание на <?>! 
  boolean sameAvg(Stats<?> ob) {
    if(average() == ob.average())
      return true;

    return false;
  }
}

// демокласс
class WildCardDemo {
public static void main(String args[]) {
 // массив целых чисел
 Integer inums[] = { 1, 2, 3, 4, 5 };
 Stats<Integer> iob = new Stats<Integer>(inums);
 // считаем среднее
 double v = iob.average();
 System.out.println("Среднее iob: " + v);

 // массив дробных
 Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
 Stats<Double> dob = new Stats<Double>(dnums);
 // считаем среднее
 double w = dob.average();
 System.out.println("Среднее dob: " + w);

 // еще массив дробных - другого типа
 Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
 Stats<Float> fob = new Stats<Float>(fnums);
 // и тут считаем среднее
 double x = fob.average();
 System.out.println("Среднее fob: " + x);

 // получаем три массива чисел разного вида
 // и сравниваем их средние значения
 System.out.print("Средние значения iob и dob ");
 if(iob.sameAvg(dob))
   System.out.println("равны");
 else
   System.out.println("неравны");

 System.out.print("Средние значения iob и fob ");
 if(iob.sameAvg(fob))
     System.out.println("равны");
   else
     System.out.println("неравны");
 }
}