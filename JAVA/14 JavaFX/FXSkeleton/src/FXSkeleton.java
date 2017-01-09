// скелет JavaFX-приложени€

// грузим библиотеки
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

// собственно, класс
public class FXSkeleton extends Application {

  // здравствуй, старый добрый main
  public static void main(String[] args) {

    System.out.println("«апускаю JavaFX-приложние...");

    // вызываем еще один стандартный метод класса Application
    launch(args);
  }

  // тут можно что-нибудь проинициализировать
  // (метод запускаетс€ в главном запускающем потоке)
  public void init() { 
	    System.out.println("ќтработал init()");
	  }

	  // а вот метод уже дл€ построени€ интерфейса
  	  // (метод запускаетс€ в исполн€ющем потоке 
	  public void start(Stage myStage) {

	    System.out.println("внутри метода start()");

	    // делаем окну заголовок
	    myStage.setTitle("ѕриложение JavaFX!");

	    // создаем корневой узел (в данном случае, компоновку)
	    FlowPane rootNode = new FlowPane();

	    // создаем сцену, передава€ ей корневой узел и размеры
	    Scene myScene = new Scene(rootNode, 300, 200);

	    // помещаем сцену в фрейм
	    myStage.setScene(myScene);
	    
	    // создаем метку
	    Label myLabel = new Label("JavaFX rulezz");

	    // и добавл€ем ее в граф (а именно - в массив дочерних элементов корневого узла)
	    // каждый элемент должен иметь в дереве свое место!
	    rootNode.getChildren().add(myLabel);


	    // отображаем приложение
	    myStage.show();

	  }

	  // тут можно освободить какие-нибудь ресурсы
	  public void stop() {
	    System.out.println("¬нутри метода stop().");
	  }
	}