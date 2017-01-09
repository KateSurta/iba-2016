import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class TextDemo extends Application {

  // наши элементы управления
  TextField tf;
  Label response;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("Пример TextField");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 230, 140);
    myStage.setScene(myScene);

    // метка для отображения результата ввода
    response = new Label("Мы ищем: ");

    // кнопка, чтобы "захватить" результат
    Button btnGetText = new Button("Ввести запрос");

    // сам однострочный контейнер
    tf = new TextField();
    tf.setPrefColumnCount(15);
    // подсказка пользователю
    tf.setPromptText("Введите строку запроса"); 


    // обработка события от поля ввода
    tf.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("Мы ищем: " + tf.getText());
      }
    });

    // обработка события от кнопки
    btnGetText.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("Мы ищем: " + tf.getText());
      }
    });

    // сепаратор для красоты
    Separator separator = new Separator();
    separator.setPrefWidth(180);

    // собираем граф
    rootNode.getChildren().addAll(tf, btnGetText, separator, response);
    myStage.show();
  }
}