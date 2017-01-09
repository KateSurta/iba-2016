// пример работы со списков

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class ListDemo extends Application {

  Label response;
 
  public static void main(String[] args) {

	    launch(args);
	  }

	  public void start(Stage myStage) {

	    myStage.setTitle("Пример ListView");
	    FlowPane rootNode = new FlowPane(10, 10);
	    rootNode.setAlignment(Pos.CENTER);
	    Scene myScene = new Scene(rootNode, 160, 240);
	    myStage.setScene(myScene);

	    // метка для резульатат выбора
	    response = new Label("Выберите напиток");

	    // создаем список вариантов выбора (объект класса ObservableList)
	    ObservableList<String> transportTypes = FXCollections.observableArrayList( "Чай", "Кофе", "Вода", "Сок", "Молоко" );

	    // создаем сам элемент управления
	    final ListView<String> lvTransport = new ListView<String>(transportTypes);

	    // включаем множественный выбор
	    lvTransport.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	    // определяем его размеры
	    lvTransport.setPrefSize(100, 100);

	    // получаем его модель выбора
	    MultipleSelectionModel<String> lvSelModel = lvTransport.getSelectionModel();

	    // и регистрируем для нее (!) приемник события изменения состояния
	    lvSelModel.selectedItemProperty().addListener(
	                                      new ChangeListener<String>() {
	      public void changed(ObservableValue<? extends String> changed,
	                          String oldVal, String newVal) {

	    	  // строка для списка выбранных элементов
	    	  String selItems = "";
	    	  // получаем список выбранных элементов
	    	  ObservableList<String> selected = lvTransport.getSelectionModel().getSelectedItems();
	    	  // собираем его в строку
	    	    for(int i=0; i < selected.size(); i++)
	    	      selItems += "\n      " + selected.get(i);

	        // теперь покажем, что выбрал пользователь
	        response.setText("Наш гость заказал " + selItems + "!");
	      }
	     });
	    // выводим все в граф
	    rootNode.getChildren().addAll(lvTransport, response);
	    myStage.show();
	  }
	}