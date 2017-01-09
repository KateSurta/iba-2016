import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ToggleDemo extends Application {

  // "����������" ������ � ����� ��� ���
  ToggleButton tbOnOff;
  Label lToggle;

  public static void main(String[] args) {

    launch(args);
  }


  public void start(Stage myStage) {

    myStage.setTitle("������� ������");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 240, 360);
    myStage.setScene(myScene);

    // ����� ��� ������������� ������
    lToggle = new Label("�������/�������� ������");
    // ������� ������������� ������
    tbOnOff = new ToggleButton("���/����");
    // � ���������� ���������� �� �������
    tbOnOff.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        if(tbOnOff.isSelected()) lToggle.setText("������ ���");
        else lToggle.setText("������ ����");
      }
    });

    // �������� �������� �� �����
    rootNode.getChildren().addAll(tbOnOff, lToggle);
    
    // � ���������� ��
    myStage.show();
  }
}