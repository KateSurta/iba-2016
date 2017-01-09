
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

    myStage.setTitle("Пример ComboBox");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 280, 120);
    myStage.setScene(myScene);

    // метка для результата
    response = new Label();
    // список вариантов выбора ObservableList
    ObservableList<String> transportTypes = FXCollections.observableArrayList( "Самолет", "Поезд", "Паром", "Автобус", "Автомобиль" );

    // создаем элемент управления
    cbTransport = new ComboBox<String>(transportTypes);
    // и задаем значение по умолчанию
    cbTransport.setValue("Самолет");
    response.setText("Вы выбрали " + cbTransport.getValue());

    // обработчик события
    cbTransport.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("Вы выбрали " + cbTransport.getValue());      }
    });

    // выкладываем элементы в граф
    rootNode.getChildren().addAll(cbTransport, response);
    myStage.show();
  }
}