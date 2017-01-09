
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.event.*;


public class ComboDemo extends Application {

  ComboBox<String> cbTransport;
  Label response;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("������ ComboBox");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 280, 120);
    myStage.setScene(myScene);

    // ����� ��� ����������
    response = new Label();
    // ������ ��������� ������ ObservableList
    ObservableList<String> transportTypes = FXCollections.observableArrayList( "�������", "�����", "�����", "�������", "����������" );

    // ������� ������� ����������
    cbTransport = new ComboBox<String>(transportTypes);
    // � ������ �������� �� ���������
    cbTransport.setValue("�������");
    response.setText("�� ������� " + cbTransport.getValue());

    // ���������� �������
    cbTransport.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("�� ������� " + cbTransport.getValue());      }
    });

    // ����������� �������� � ����
    rootNode.getChildren().addAll(cbTransport, response);
    myStage.show();
  }
}