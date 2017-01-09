import javafx.application.*;
import javafx.scene.*; 
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class CheckDemo extends Application {

  // кнопки вариантов
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

    myStage.setTitle("Примеры кнопок");

    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 230, 140);
    myStage.setScene(myScene);

    // метка-приглашение
    Label heading = new Label("Выберите среду функционирования");
    // метки с результатами
    response = new Label("Ничего не выбрано");
    allTargets = new Label("Среда: <нет>");

    // Create the check boxes.
    cbWeb = new CheckBox("Web"); 
    cbDesktop = new CheckBox("Desktop");
    cbMobile = new CheckBox("Mobile");
    
    // явно разрешаем "неопределенность"
    cbWeb.setAllowIndeterminate(true);
    cbDesktop.setAllowIndeterminate(true);
    cbMobile.setAllowIndeterminate(true);

    // обработчики событий
    cbWeb.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  if(cbWeb.isIndeterminate())
   		   response.setText("Web возможен");
    	    else if(cbWeb.isSelected())
          response.setText("Выбран Web");
        else
          response.setText("Отказ от Web");

        showAll();
      }
    });

    cbDesktop.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  if(cbDesktop.isIndeterminate())
    		  response.setText("Desktop возможен");
  	    else if(cbDesktop.isSelected())
          response.setText("Выбран Desktop");
        else
          response.setText("Отказ от Desktop");

        showAll();
      }
    });

    cbMobile.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
      	  if(cbMobile.isIndeterminate())
    		  response.setText("Mobile возможен");
  	    else if(cbMobile.isSelected())
            response.setText("Выбран Mobile");
          else
            response.setText("Отказ от Mobile");

          showAll();
        }
      });

      // сепаратор для красоты
      Separator separator = new Separator();
      separator.setPrefWidth(200);

      // собираем граф сцены
      rootNode.getChildren().addAll(heading, separator, cbWeb, cbDesktop, cbMobile, response, allTargets);
      myStage.show();
    }

    // построение списка целевых сред
    void showAll() {
      targets = "";
      if(cbWeb.isSelected()) targets = "Web ";     if(cbDesktop.isSelected()) targets += "Desktop ";
      if(cbMobile.isSelected()) targets += "Mobile";

      if(targets.equals("")) targets = "<нет>";

      allTargets.setText("Target List: " + targets);
    }
  }