// ������������ ����������� ���� ��������� ���������
// ���������� ������
import java.lang.annotation.*;
import java.lang.reflect.*;

// ���������� ��������� ������� ����
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
  String str();
  int val();
}

// ���������� ��������� ������� ����
@Retention(RetentionPolicy.RUNTIME)
@interface What {
  String description();
}

@What(description = "����� ��� ������������ ���������")
@MyAnno(str = "Meta2", val = 99)
class Meta2 {


  @What(description = "����� ��� ������������ ���������")
  @MyAnno(str = "Testing", val = 100)
  public static void myMeth() {
    Meta2 ob = new Meta2();

    try {
    	// �������� ������ ��������� �������� ������
        Annotation annos[] = ob.getClass().getAnnotations();

        // ���������� ������ ��������� ������ Meta2.
        System.out.println("��������� Meta2:");
        for(Annotation a : annos)
          System.out.println(a);

        System.out.println();

        // �������� ������ ������ myMeth � ��� ��������� 
        Method m = ob.getClass( ).getMethod("myMeth");
        annos = m.getAnnotations();
        
        // ���������� ��������� ������ myMeth
        System.out.println("��������� myMeth:");
        for(Annotation a : annos)
          System.out.println(a);

      } catch (NoSuchMethodException exc) {
         System.out.println("����� �� ������.");
      }
    }

    public static void main(String args[]) {
      myMeth();
    }
  }