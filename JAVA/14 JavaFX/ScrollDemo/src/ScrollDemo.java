import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ScrollDemo extends Application {

  // �������-��������
  ScrollPane scrlPane;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("������ ������ ScrollPane");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 200, 200);
    myStage.setScene(myScene);

    // ����� � ������� ������� ��� ���������
    Label scrlLabel = new Label(
                          "� �������� ����� ���-��������� ���\n" + 
                                  "���� ����� ����� - �� ������ �����\n" +
                                  "����� � �����.\n" +
                                  "(������� �������)\n" +
                                  "��� ���� ��� ����, ����� ��� �����.\n" +
                                  "� ��������� ����� �� ��� � �� ���� - \n" +
                                  "� ������� ������.");

            // ������� ������ ���������
            scrlPane = new ScrollPane(scrlLabel);

            // ������������� ������� "���� ���������"
            scrlPane.setPrefViewportWidth(130);
            scrlPane.setPrefViewportHeight(80);

            // �������� ���������������
            scrlPane.setPannable(true);

            // ������ �������� � ������
            Button btnReset = new Button("��������� � ������");

            // � �� ����������
            btnReset.setOnAction(new EventHandler<ActionEvent>() {
              public void handle(ActionEvent ae) {
                // ������������ � ������ (�� ����������� � ���������)
                scrlPane.setVvalue(0);
                scrlPane.setHvalue(0);
              }
            });
            // ������� ����
            rootNode.getChildren().addAll(scrlPane, btnReset);
            myStage.show();
          }
        }