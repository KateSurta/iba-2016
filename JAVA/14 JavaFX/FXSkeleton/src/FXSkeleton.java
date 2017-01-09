// ������ JavaFX-����������

// ������ ����������
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

// ����������, �����
public class FXSkeleton extends Application {

  // ����������, ������ ������ main
  public static void main(String[] args) {

    System.out.println("�������� JavaFX-���������...");

    // �������� ��� ���� ����������� ����� ������ Application
    launch(args);
  }

  // ��� ����� ���-������ �������������������
  // (����� ����������� � ������� ����������� ������)
  public void init() { 
	    System.out.println("��������� init()");
	  }

	  // � ��� ����� ��� ��� ���������� ����������
  	  // (����� ����������� � ����������� ������ 
	  public void start(Stage myStage) {

	    System.out.println("������ ������ start()");

	    // ������ ���� ���������
	    myStage.setTitle("���������� JavaFX!");

	    // ������� �������� ���� (� ������ ������, ����������)
	    FlowPane rootNode = new FlowPane();

	    // ������� �����, ��������� �� �������� ���� � �������
	    Scene myScene = new Scene(rootNode, 300, 200);

	    // �������� ����� � �����
	    myStage.setScene(myScene);
	    
	    // ������� �����
	    Label myLabel = new Label("JavaFX rulezz");

	    // � ��������� �� � ���� (� ������ - � ������ �������� ��������� ��������� ����)
	    // ������ ������� ������ ����� � ������ ���� �����!
	    rootNode.getChildren().add(myLabel);


	    // ���������� ����������
	    myStage.show();

	  }

	  // ��� ����� ���������� �����-������ �������
	  public void stop() {
	    System.out.println("������ ������ stop().");
	  }
	}