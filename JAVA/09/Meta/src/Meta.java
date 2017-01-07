// ���������� ������ ��� ������ ��������� � ���������
import java.lang.annotation.*;
import java.lang.reflect.*;

// ��������� ���� ��� ���������
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
  String strName(); // �������� ������
  String strAuthor(); // �����
  int val(); // ������������ ���������� � �����
}

// ��������� ����-�����
class Meta {

  // ���������� �����
  @MyAnno(strName = "����� myMeth", strAuthor = "������� �������", val = 8) 
  public static void myMeth() {
	    Meta ob = new Meta();

	    // �������� ��������� ������
	    try {
	      // �������� ������ ���� Class, ����������� ������� �����
	      Class<?> c = ob.getClass();

	      // �������� ������ ������ Method ��� ������ myMeth()
	      Method m = c.getMethod("myMeth");

	      // �������� ��������� ������ � ���������� �� ���
	      MyAnno anno = m.getAnnotation(MyAnno.class);

	      // ���������� ���������� ���������
	      System.out.println(anno.strName() + " " + anno.strAuthor() + " " + anno.val());
	    } catch (NoSuchMethodException exc) {
	      System.out.println("����� �� ������");
	    }
	  }

  public static void main(String args[]) {
	    myMeth();
	  }
	}