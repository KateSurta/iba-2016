import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ScrollDemo extends Application {

  // элемент-оболочка
  ScrollPane scrlPane;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("Пример работы ScrollPane");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 200, 200);
    myStage.setScene(myScene);

    // метка с большим текстом для прокрутки
    Label scrlLabel = new Label(
                          "С рождения Бобби пай-мальчиком был\n" + 
                                  "имел Бобби хобби - он деньги любил\n" +
                                  "Любил и копил.\n" +
                                  "(хороший мальчик)\n" +
                                  "Все дети как дети, живут без забот.\n" +
                                  "А маленький Бобби не ест и не пьет - \n" +
                                  "В копилку кладет.");

            // создаем панель прокрутки
            scrlPane = new ScrollPane(scrlLabel);

            // устанавливаем размеры "окна просмотра"
            scrlPane.setPrefViewportWidth(130);
            scrlPane.setPrefViewportHeight(80);

            // включаем панорамирование
            scrlPane.setPannable(true);

            // кнопка перехода в начало
            Button btnReset = new Button("Вернуться в начало");

            // и ее обработчик
            btnReset.setOnAction(new EventHandler<ActionEvent>() {
              public void handle(ActionEvent ae) {
                // возвращаемся в начало (по горизонтали и вертикали)
                scrlPane.setVvalue(0);
                scrlPane.setHvalue(0);
              }
            });
            // собраем граф
            rootNode.getChildren().addAll(scrlPane, btnReset);
            myStage.show();
          }
        }