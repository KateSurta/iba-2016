import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class TextDemo extends Application {

  // ���� �������� ����������
  TextField tf;
  Label response;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("������ TextField");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 230, 140);
    myStage.setScene(myScene);

    // ����� ��� ����������� ���������� �����
    response = new Label("�� ����: ");

    // ������, ����� "���������" ���������
    Button btnGetText = new Button("������ ������");

    // ��� ������������ ���������
    tf = new TextField();
    tf.setPrefColumnCount(15);
    // ��������� ������������
    tf.setPromptText("������� ������ �������"); 


    // ��������� ������� �� ���� �����
    tf.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("�� ����: " + tf.getText());
      }
    });

    // ��������� ������� �� ������
    btnGetText.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("�� ����: " + tf.getText());
      }
    });

    // ��������� ��� �������
    Separator separator = new Separator();
    separator.setPrefWidth(180);

    // �������� ����
    rootNode.getChildren().addAll(tf, btnGetText, separator, response);
    myStage.show();
  }
}