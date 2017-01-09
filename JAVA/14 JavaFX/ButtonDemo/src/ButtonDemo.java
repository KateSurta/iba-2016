// ������ ������ � �������� � ���������

import javafx.application.*;
import javafx.scene.image.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ButtonDemo extends Application {

  Label response;

  public static void main(String[] args) {

    // ������ ����������
    launch(args);
  }


  public void start(Stage myStage) {

    // ��������� ����
    myStage.setTitle("������ ������ � �������� � ���������"); 
    // ����������
    FlowPane rootNode = new FlowPane(10, 10);
    // ������������
    rootNode.setAlignment(Pos.CENTER);
    // �����
    Scene myScene = new Scene(rootNode, 300, 600);
    // ..� �� �����������
    myStage.setScene(myScene);

    // ����� ��� ����������
    response = new Label("���� ��� ���?");

    // ������� ��� ������ (������ � �������� � ���������)
    Button btnAlpha = new Button("����", new ImageView("coffee.jpg"));
    Button btnBeta = new Button("���", new ImageView("tea.jpg"));

    // �������� ������� ������� ��� ������ ������
    btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("�� �������� ��� ������!");
      }
    });

    // �������� ������� ������� ��� ������ ������
    btnBeta.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("� ������� ��� �������?");
      }
    });

    // ����������� �������� �� �����
    rootNode.getChildren().addAll(btnAlpha, btnBeta, response);

    // ������ ������� ��� �� �����
    myStage.show();
  }
}