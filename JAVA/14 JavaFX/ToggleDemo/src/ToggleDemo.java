import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ToggleDemo extends Application {

  // "нажимаемая" кнопка и метка для нее
  ToggleButton tbOnOff;
  Label lToggle;

  public static void main(String[] args) {

    launch(args);
  }


  public void start(Stage myStage) {

    myStage.setTitle("Примеры кнопок");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 240, 360);
    myStage.setScene(myScene);

    // метка для переключаемой кнопки
    lToggle = new Label("Нажмите/отожмите кнопку");
    // создаем переключаемую кнопку
    tbOnOff = new ToggleButton("Вкл/Выкл");
    // и определяем обработчик ее событий
    tbOnOff.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        if(tbOnOff.isSelected()) lToggle.setText("Кнопка вкл");
        else lToggle.setText("Кнопка выкл");
      }
    });

    // помещаем элементы на сцену
    rootNode.getChildren().addAll(tbOnOff, lToggle);
    
    // и отображаем ее
    myStage.show();
  }
}