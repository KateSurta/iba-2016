// пример захвата переменных из объемлющей области

// объявляем ФИ
interface MyFunc {
  int func(int n);
}

// демокласс
class VarCapt {
  public static void main(String args[])
  {
    // локальная переменная для захвата
    int num = 10;

    // создаем ссылку на ФИ и ЛВ для нее
    MyFunc myLambda = (n) ->  {
      // так можно - значение num не меняется
      int v = num + n;

      // а вот так нельзя - это нарушит завершенное состояние num
      //    num++;
      return v;
    };

    // тоже нельзя - по тем же причинам
    //  num = 9;
  }
}