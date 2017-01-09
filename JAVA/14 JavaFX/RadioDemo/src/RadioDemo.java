import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class RadioDemo extends Application {

  // "�������������" ������ � ����� ��� ���
  RadioButton rbTea;
  RadioButton rbCoffee;
  RadioButton rbVodka;
  Label lRadio;

  public static void main(String[] args) {

    launch(args);
  }


  public void start(Stage myStage) {

    myStage.setTitle("������� ������");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 160, 360);
    myStage.setScene(myScene);

    // ������� "�������������"
    rbTea = new RadioButton("���");
    rbCoffee = new RadioButton("����");
    rbVodka = new RadioButton("���");
    
    // ...� ���������� �� � ������
    ToggleGroup tg = new ToggleGroup();
    rbTea.setToggleGroup(tg);
    rbCoffee.setToggleGroup(tg);
    rbVodka.setToggleGroup(tg);
    
    // ��������� ����������� ��� ������
    rbTea.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  lRadio.setText("������ ������ ���!");
      }
    });
    
    rbCoffee.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  lRadio.setText("������ ������ ����!");
      }
    });
    
    rbVodka.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  lRadio.setText("������ ������ ���!"); 
      }
    });
    
    // ����� ��� ��������������
    lRadio = new Label("�������� �������");
    
    // ���������� "��������" ���
    rbTea.fire();

    // ������� - �������!
    rootNode.getChildren().addAll(rbTea, rbCoffee, rbVodka, lRadio);

    // � ���������� ��
    myStage.show();
  }
}