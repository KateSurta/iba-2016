// Пример конструирования меню

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.input.*;
import javafx.scene.image.*;
import javafx.beans.value.*;

public class MenuDemo extends Application {

  // элемент для главного меню
  MenuBar mb;
  // контекстное меню
  ContextMenu editMenu;
  // панель инструментов
  ToolBar tbDebug;
  // приемник обытий собственного сочинения
  EventHandler<ActionEvent> MEHandler;
   

  Label response;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("Пример работы меню");

    // компонуем элементы по краям
    final BorderPane rootNode = new BorderPane();
    Scene myScene = new Scene(rootNode, 480, 480);
    myStage.setScene(myScene);

    // метка для результатов
    response = new Label();

    // обработчик обытий меню
    MEHandler = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        String name = ((MenuItem)ae.getTarget()).getText();

        if(name.equals("Выход")) Platform.exit();

        response.setText( name + " выбрано");
      }
    };

    // создаем объект главного меню
    mb = new MenuBar();
    // а потом - отдельные меню (для удобства каждое создается отдельным методом)
    // меню File
    makeFileMenu();
    // Options
    makeOptionsMenu();
    // и всплывающее
    makeContextMenu();

    // создаем текстовое поле
    TextField tf = new TextField();
    tf.setPrefColumnCount(20);
    // и присоединяем к нему всплывающее меню
    tf.setContextMenu(editMenu);

    // создаем панель инструментов
    makeToolBar();

    // добавляем контекстное меню ко всему графу
    rootNode.setOnContextMenuRequested(
                new EventHandler<ContextMenuEvent>() {
      public void handle(ContextMenuEvent ae) {
        // отображаем меню в точке правого клика
        editMenu.show(rootNode, ae.getScreenX(), ae.getScreenY());
      }
    });

    // добавляем панель инструментов в северную часть окна
    rootNode.setTop(mb);

    // выкладываем остальные эдементы
    FlowPane fpRoot = new FlowPane(10, 10);
    fpRoot.setAlignment(Pos.CENTER);
    Separator separator = new Separator();
    separator.setPrefWidth(260);
    fpRoot.getChildren().addAll(response, separator,  tf);

    // еще одна панель
    rootNode.setBottom(tbDebug);
    rootNode.setCenter(fpRoot);
    myStage.show();
  }

  // метод для создания меню File
  void makeFileMenu() {
    // создаем объект меню (с мнемоникой)
    Menu fileMenu = new Menu("_Файл");

    // и сами пункты
    MenuItem open = new MenuItem("Открыть");
    MenuItem close = new MenuItem("Закрыть");
    MenuItem save = new MenuItem("Сохранить");
    MenuItem exit = new MenuItem("Выход");
    
    // сочетания быстрого доступа для них
    open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
    close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
    save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
    exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
    
    // и обработчики
    open.setOnAction(MEHandler);
    close.setOnAction(MEHandler);
    save.setOnAction(MEHandler);
    exit.setOnAction(MEHandler);

    // добавляем пункты в меню
    fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);

    // а само меню - в главное
    mb.getMenus().add(fileMenu);
  }
  
  
  // создаем меню Options
  void makeOptionsMenu() {
    Menu optionsMenu = new Menu("Настройки");

    // подменю Colors
    Menu colorsMenu = new Menu("Цвета");

    // в качестве пунктов - чекбоксы
    CheckMenuItem red = new CheckMenuItem("Красный");
    CheckMenuItem green = new CheckMenuItem("Зеленый");
    CheckMenuItem blue = new CheckMenuItem("Синий");
    
    // значение по умолчанию
    green.setSelected(true);

    // собираем "цветное" меню и присоединяем его в Options
    colorsMenu.getItems().addAll(red, green, blue);
    optionsMenu.getItems().add(colorsMenu);


    // создаем подменю Priority
    Menu priorityMenu = new Menu("Приоритет");

    // его пункты - радиокнопки в группе

    RadioMenuItem high = new RadioMenuItem("Высокий");
    RadioMenuItem low = new RadioMenuItem("Низкий");
    ToggleGroup tg = new ToggleGroup();
    high.setToggleGroup(tg);
    low.setToggleGroup(tg);
    high.setSelected(true);

    // собираем "приоритетное" меню и присоединяем его в Options
    priorityMenu.getItems().addAll(high, low);
    optionsMenu.getItems().add(priorityMenu);

    // сепаратор для красоты
    optionsMenu.getItems().add(new SeparatorMenuItem());

    // и пункт Reset
    MenuItem reset = new MenuItem("Сброс");
    optionsMenu.getItems().add(reset);

    // добавляем обработчики для пунктов
    red.setOnAction(MEHandler);
    green.setOnAction(MEHandler);
    blue.setOnAction(MEHandler); 
    high.setOnAction(MEHandler);
    low.setOnAction(MEHandler);
    reset.setOnAction(MEHandler);

    // и обработчик для радиокнопок
    tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> changed,
                         Toggle oldVal, Toggle newVal) {
        if(newVal==null) return;

        // получаем выбранный элемент
        RadioMenuItem rmi = (RadioMenuItem) newVal;

        // и отображаем его
        response.setText("Приоритет " + rmi.getText());
      }
    });

    // добавляем Options в главное меню
    mb.getMenus().add(optionsMenu);
  }


  // всплывающее меню
  void makeContextMenu() {

    // созадем пункты
    MenuItem cut = new MenuItem("Вырезать");
    MenuItem copy = new MenuItem("Копировать");
    MenuItem paste = new MenuItem("Вставить");

    // теперь само меню
    editMenu = new ContextMenu(cut, copy, paste);
    // обработчики
    cut.setOnAction(MEHandler);
    copy.setOnAction(MEHandler);
    paste.setOnAction(MEHandler);
  }

  // панель инструментов
  void makeToolBar() {
    // сначала кнопки
    Button btnSet = new Button("Установить метку", new ImageView("setBP.png"));
    Button btnClear = new Button("Снять метку", new ImageView("clearBP.png"));
    Button btnResume = new Button("Продолжить работу", new ImageView("resume.png"));

    // убираем подписи
    btnSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    btnClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    btnResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

    // но делаем подсказки
    btnSet.setTooltip(new Tooltip("Установить метку"));
    btnClear.setTooltip(new Tooltip("Снять метку"));
    btnResume.setTooltip(new Tooltip("Продолжить работу"));

    // создаем саму панель
    tbDebug = new ToolBar(btnSet, btnClear, btnResume);

    // обработчики для кнопок
    EventHandler<ActionEvent> btnHandler = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        response.setText(((Button)ae.getTarget()).getText());
      }
    };
    btnSet.setOnAction(btnHandler);
    btnClear.setOnAction(btnHandler);
    btnResume.setOnAction(btnHandler);
  }
}