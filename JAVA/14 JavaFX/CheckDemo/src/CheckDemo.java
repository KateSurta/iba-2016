import javafx.application.*;
import javafx.scene.*; 
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class CheckDemo extends Application {

  // ������ ���������
  CheckBox cbWeb;
  CheckBox cbDesktop;
  CheckBox cbMobile;

  Label response;
  Label allTargets;

  String targets = "";

  public static void main(String[] args) {
    launch(args);
  }


  public void start(Stage myStage) {

    myStage.setTitle("������� ������");

    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 230, 140);
    myStage.setScene(myScene);

    // �����-�����������
    Label heading = new Label("�������� ����� ����������������");
    // ����� � ������������
    response = new Label("������ �� �������");
    allTargets = new Label("�����: <���>");

    // Create the check boxes.
    cbWeb = new CheckBox("Web"); 
    cbDesktop = new CheckBox("Desktop");
    cbMobile = new CheckBox("Mobile");
    
    // ���� ��������� "����������������"
    cbWeb.setAllowIndeterminate(true);
    cbDesktop.setAllowIndeterminate(true);
    cbMobile.setAllowIndeterminate(true);

    // ����������� �������
    cbWeb.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  if(cbWeb.isIndeterminate())
   		   response.setText("Web ��������");
    	    else if(cbWeb.isSelected())
          response.setText("������ Web");
        else
          response.setText("����� �� Web");

        showAll();
      }
    });

    cbDesktop.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  if(cbDesktop.isIndeterminate())
    		  response.setText("Desktop ��������");
  	    else if(cbDesktop.isSelected())
          response.setText("������ Desktop");
        else
          response.setText("����� �� Desktop");

        showAll();
      }
    });

    cbMobile.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
      	  if(cbMobile.isIndeterminate())
    		  response.setText("Mobile ��������");
  	    else if(cbMobile.isSelected())
            response.setText("������ Mobile");
          else
            response.setText("����� �� Mobile");

          showAll();
        }
      });

      // ��������� ��� �������
      Separator separator = new Separator();
      separator.setPrefWidth(200);

      // �������� ���� �����
      rootNode.getChildren().addAll(heading, separator, cbWeb, cbDesktop, cbMobile, response, allTargets);
      myStage.show();
    }

    // ���������� ������ ������� ����
    void showAll() {
      targets = "";
      if(cbWeb.isSelected()) targets = "Web ";     if(cbDesktop.isSelected()) targets += "Desktop ";
      if(cbMobile.isSelected()) targets += "Mobile";

      if(targets.equals("")) targets = "<���>";

      allTargets.setText("Target List: " + targets);
    }
  }