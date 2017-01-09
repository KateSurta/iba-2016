// ������ ������ �� �������

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class ListDemo extends Application {

  Label response;
 
  public static void main(String[] args) {

	    launch(args);
	  }

	  public void start(Stage myStage) {

	    myStage.setTitle("������ ListView");
	    FlowPane rootNode = new FlowPane(10, 10);
	    rootNode.setAlignment(Pos.CENTER);
	    Scene myScene = new Scene(rootNode, 160, 240);
	    myStage.setScene(myScene);

	    // ����� ��� ���������� ������
	    response = new Label("�������� �������");

	    // ������� ������ ��������� ������ (������ ������ ObservableList)
	    ObservableList<String> transportTypes = FXCollections.observableArrayList( "���", "����", "����", "���", "������" );

	    // ������� ��� ������� ����������
	    final ListView<String> lvTransport = new ListView<String>(transportTypes);

	    // �������� ������������� �����
	    lvTransport.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	    // ���������� ��� �������
	    lvTransport.setPrefSize(100, 100);

	    // �������� ��� ������ ������
	    MultipleSelectionModel<String> lvSelModel = lvTransport.getSelectionModel();

	    // � ������������ ��� ��� (!) �������� ������� ��������� ���������
	    lvSelModel.selectedItemProperty().addListener(
	                                      new ChangeListener<String>() {
	      public void changed(ObservableValue<? extends String> changed,
	                          String oldVal, String newVal) {

	    	  // ������ ��� ������ ��������� ���������
	    	  String selItems = "";
	    	  // �������� ������ ��������� ���������
	    	  ObservableList<String> selected = lvTransport.getSelectionModel().getSelectedItems();
	    	  // �������� ��� � ������
	    	    for(int i=0; i < selected.size(); i++)
	    	      selItems += "\n      " + selected.get(i);

	        // ������ �������, ��� ������ ������������
	        response.setText("��� ����� ������� " + selItems + "!");
	      }
	     });
	    // ������� ��� � ����
	    rootNode.getChildren().addAll(lvTransport, response);
	    myStage.show();
	  }
	}