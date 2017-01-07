import java.lang.annotation.*;
import java.lang.reflect.*;

// ����������� ���������
@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
  int value(); // ������������ ���� � ������������ ��������� value
}

class Single {

  // ���������� �����
  @MySingle(100)
  public static void myMeth() {
    Single ob = new Single();

    try {
      Method m = ob.getClass().getMethod("myMeth");

      MySingle anno = m.getAnnotation(MySingle.class);

      System.out.println(anno.value()); // ���������� 100

    } catch (NoSuchMethodException exc) {
       System.out.println("����� �� ������");
    }
  }
 
  public static void main(String args[]) {
	    myMeth();
	  }
	}