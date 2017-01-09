import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class RadioDemo extends Application {

  // "переключаемые" кнопки и метка для них
  RadioButton rbTea;
  RadioButton rbCoffee;
  RadioButton rbVodka;
  Label lRadio;

  public static void main(String[] args) {

    launch(args);
  }


  public void start(Stage myStage) {

    myStage.setTitle("Примеры кнопок");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 160, 360);
    myStage.setScene(myScene);

    // создаем "переключатели"
    rbTea = new RadioButton("Чай");
    rbCoffee = new RadioButton("Кофе");
    rbVodka = new RadioButton("Сок");
    
    // ...и объединяем их в группу
    ToggleGroup tg = new ToggleGroup();
    rbTea.setToggleGroup(tg);
    rbCoffee.setToggleGroup(tg);
    rbVodka.setToggleGroup(tg);
    
    // реализуем обработчики для кнопок
    rbTea.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  lRadio.setText("Клиент выбрал чай!");
      }
    });
    
    rbCoffee.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  lRadio.setText("Клиент выбрал кофе!");
      }
    });
    
    rbVodka.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
    	  lRadio.setText("Клиент выбрал сок!"); 
      }
    });
    
    // метка для переключателей
    lRadio = new Label("Выберите напиток");
    
    // программно "выбираем" чай
    rbTea.fire();

    // создали - выносим!
    rootNode.getChildren().addAll(rbTea, rbCoffee, rbVodka, lRadio);

    // и отображаем ее
    myStage.show();
  }
}