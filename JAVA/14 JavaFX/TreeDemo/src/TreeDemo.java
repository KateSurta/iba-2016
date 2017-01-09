
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.beans.value.*;
import javafx.geometry.*;

public class TreeDemo extends Application {

  Label response;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("������ TreeView");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 310, 460);
    myStage.setScene(myScene);
    response = new Label("������ �� �������");

    // ������� �������� ���� (� ����� �������� ������� ������)
    TreeItem<String> tiRoot = new TreeItem<String>("���");

    // ����������� ���� ��� ������ �����
    TreeItem<String> tiFruit = new TreeItem<String>("������");
    // � �� ����������
    TreeItem<String> tiApples = new TreeItem<String>("������");
    // ��������� �����
    tiApples.getChildren().add(new TreeItem<String>("�������"));
    tiApples.getChildren().add(new TreeItem<String>("�����"));
    tiApples.getChildren().add(new TreeItem<String>("�����"));

    // ��� �������!
    tiFruit.getChildren().add(tiApples);
    tiFruit.getChildren().add(new TreeItem<String>("�����"));
    tiFruit.getChildren().add(new TreeItem<String>("���������"));

    // ������������ "���������" ����� � ��������� ����
    tiRoot.getChildren().add(tiFruit);

    // ������ - ����� (������� ��� ��)
    TreeItem<String> tiVegetables = new TreeItem<String>("�����");
    tiVegetables.getChildren().add(new TreeItem<String>("�������"));
    tiVegetables.getChildren().add(new TreeItem<String>("�������"));
    tiVegetables.getChildren().add(new TreeItem<String>("���������"));
    tiVegetables.getChildren().add(new TreeItem<String>("������"));
    tiRoot.getChildren().add(tiVegetables);

    // �����!
    TreeItem<String> tiNuts = new TreeItem<String>("�����");
    tiNuts.getChildren().add(new TreeItem<String>("������"));
    tiNuts.getChildren().add(new TreeItem<String>("������"));
    tiNuts.getChildren().add(new TreeItem<String>("�����"));
    tiRoot.getChildren().add(tiNuts);

    // ������� ������� ���� ������
    TreeView<String> tvFood = new TreeView<String>(tiRoot);

    // �������� ������ � ��� ������ ������
    MultipleSelectionModel<TreeItem<String>> tvSelModel = tvFood.getSelectionModel();

    // � ��������� ��� ��� �������� �������
    tvSelModel.selectedItemProperty().addListener(
                           new ChangeListener<TreeItem<String>>() {
      public void changed(
                  ObservableValue<? extends TreeItem<String>> changed,
                      TreeItem<String> oldVal, TreeItem<String> newVal) {
 
          // ������ ���������� ���� � ���������� ��������
          if(newVal != null) {

            // ������ ������ � �����
            String path = newVal.getValue();
            TreeItem<String> tmp = newVal.getParent();
            while(tmp != null) {
              path = tmp.getValue() + " -> " + path;
              tmp = tmp.getParent();
            }

            // ���������� ���������
            response.setText("�� �������  " + newVal.getValue() + "\n������ ���� " + path);
          }
        }
       });

      // �������� ����
      rootNode.getChildren().addAll(tvFood, response);
      myStage.show();
    }
  }