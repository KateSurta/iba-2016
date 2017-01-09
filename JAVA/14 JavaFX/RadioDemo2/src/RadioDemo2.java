import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class RadioDemo2 extends Application {

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
    
    rbTea.setSelected(true);
    
    // метка для переключателей
    lRadio = new Label("Выберите напиток");
    
    // кнопка для определения выбранного варианта
    Button btnConfirm = new Button("Подтвердите заказ");
    btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent ae) {
          // определяем, что нажато
          RadioButton rb = (RadioButton) tg.getSelectedToggle();
          // и отображаем результат
          lRadio.setText(rb.getText() + " заказан(-а,-о)");
        }
      });

      // украшаем окно
      Separator separator = new Separator();
      separator.setPrefWidth(180);

    
    // создали - выносим!
    rootNode.getChildren().addAll(rbTea, rbCoffee, rbVodka, btnConfirm, separator, lRadio);

    // и отображаем ее
    myStage.show();
  }
}