// пример работы с кнопками и событиями

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

    // запуск приложения
    launch(args);
  }


  public void start(Stage myStage) {

    // заголовок окна
    myStage.setTitle("Пример работы с кнопками и событиями"); 
    // компоновка
    FlowPane rootNode = new FlowPane(10, 10);
    // выравнивание
    rootNode.setAlignment(Pos.CENTER);
    // сцена
    Scene myScene = new Scene(rootNode, 300, 600);
    // ..и ее отображение
    myStage.setScene(myScene);

    // метка для результата
    response = new Label("Кофе или чай?");

    // создаем две кнопки (каждая с подписью и картинкой)
    Button btnAlpha = new Button("Кофе", new ImageView("coffee.jpg"));
    Button btnBeta = new Button("Чай", new ImageView("tea.jpg"));

    // приемник события нажатия для первой кнопки
    btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("Не забудьте про сливки!");
      }
    });

    // приемник события нажатия для второй кнопки
    btnBeta.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText("С лимоном или молоком?");
      }
    });

    // выкладываем элементы на сцену
    rootNode.getChildren().addAll(btnAlpha, btnBeta, response);

    // теперь выводим все на экран
    myStage.show();
  }
}