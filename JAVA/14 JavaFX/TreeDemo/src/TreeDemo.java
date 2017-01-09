
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.beans.value.*;
import javafx.geometry.*;

public class TreeDemo extends Application {

  Label response;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("Пример TreeView");
    FlowPane rootNode = new FlowPane(10, 10);
    rootNode.setAlignment(Pos.CENTER);
    Scene myScene = new Scene(rootNode, 310, 460);
    myStage.setScene(myScene);
    response = new Label("Ничего не выбрано");

    // коздаем корневой узел (в узлах хранятся простые строки)
    TreeItem<String> tiRoot = new TreeItem<String>("Еда");

    // порожденный узел для первой ветви
    TreeItem<String> tiFruit = new TreeItem<String>("Фрукты");
    // и ее содержимое
    TreeItem<String> tiApples = new TreeItem<String>("Яблоки");
    // заполняем ветвь
    tiApples.getChildren().add(new TreeItem<String>("Глостер"));
    tiApples.getChildren().add(new TreeItem<String>("Налив"));
    tiApples.getChildren().add(new TreeItem<String>("Ранет"));

    // еще фруктов!
    tiFruit.getChildren().add(tiApples);
    tiFruit.getChildren().add(new TreeItem<String>("Груши"));
    tiFruit.getChildren().add(new TreeItem<String>("Апельсины"));

    // присоединяем "фруктовую" ветвь к корневому узлу
    tiRoot.getChildren().add(tiFruit);

    // теперь - овощи (принцип тот же)
    TreeItem<String> tiVegetables = new TreeItem<String>("Овощи");
    tiVegetables.getChildren().add(new TreeItem<String>("Капуста"));
    tiVegetables.getChildren().add(new TreeItem<String>("Морковь"));
    tiVegetables.getChildren().add(new TreeItem<String>("Картофель"));
    tiVegetables.getChildren().add(new TreeItem<String>("Свекла"));
    tiRoot.getChildren().add(tiVegetables);

    // Орехи!
    TreeItem<String> tiNuts = new TreeItem<String>("Орехи");
    tiNuts.getChildren().add(new TreeItem<String>("Фундук"));
    tiNuts.getChildren().add(new TreeItem<String>("Арахис"));
    tiNuts.getChildren().add(new TreeItem<String>("Кешью"));
    tiRoot.getChildren().add(tiNuts);

    // наконец создаем само дерево
    TreeView<String> tvFood = new TreeView<String>(tiRoot);

    // получаем доступ к его модели выбора
    MultipleSelectionModel<TreeItem<String>> tvSelModel = tvFood.getSelectionModel();

    // и реализуем для нее приемник событий
    tvSelModel.selectedItemProperty().addListener(
                           new ChangeListener<TreeItem<String>>() {
      public void changed(
                  ObservableValue<? extends TreeItem<String>> changed,
                      TreeItem<String> oldVal, TreeItem<String> newVal) {
 
          // просто отображаем путь к выбранному элементу
          if(newVal != null) {

            // строим строку с путем
            String path = newVal.getValue();
            TreeItem<String> tmp = newVal.getParent();
            while(tmp != null) {
              path = tmp.getValue() + " -> " + path;
              tmp = tmp.getParent();
            }

            // отображаем результат
            response.setText("Вы выбрали  " + newVal.getValue() + "\nПолный путь " + path);
          }
        }
       });

      // собираем граф
      rootNode.getChildren().addAll(tvFood, response);
      myStage.show();
    }
  }