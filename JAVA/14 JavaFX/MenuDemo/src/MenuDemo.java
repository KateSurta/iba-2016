// ������ ��������������� ����

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

  // ������� ��� �������� ����
  MenuBar mb;
  // ����������� ����
  ContextMenu editMenu;
  // ������ ������������
  ToolBar tbDebug;
  // �������� ������ ������������ ���������
  EventHandler<ActionEvent> MEHandler;
   

  Label response;

  public static void main(String[] args) {

    launch(args);
  }

  public void start(Stage myStage) {

    myStage.setTitle("������ ������ ����");

    // ��������� �������� �� �����
    final BorderPane rootNode = new BorderPane();
    Scene myScene = new Scene(rootNode, 480, 480);
    myStage.setScene(myScene);

    // ����� ��� �����������
    response = new Label();

    // ���������� ������ ����
    MEHandler = new EventHandler<ActionEvent>() {
      public void handle(ActionEvent ae) {
        String name = ((MenuItem)ae.getTarget()).getText();

        if(name.equals("�����")) Platform.exit();

        response.setText( name + " �������");
      }
    };

    // ������� ������ �������� ����
    mb = new MenuBar();
    // � ����� - ��������� ���� (��� �������� ������ ��������� ��������� �������)
    // ���� File
    makeFileMenu();
    // Options
    makeOptionsMenu();
    // � �����������
    makeContextMenu();

    // ������� ��������� ����
    TextField tf = new TextField();
    tf.setPrefColumnCount(20);
    // � ������������ � ���� ����������� ����
    tf.setContextMenu(editMenu);

    // ������� ������ ������������
    makeToolBar();

    // ��������� ����������� ���� �� ����� �����
    rootNode.setOnContextMenuRequested(
                new EventHandler<ContextMenuEvent>() {
      public void handle(ContextMenuEvent ae) {
        // ���������� ���� � ����� ������� �����
        editMenu.show(rootNode, ae.getScreenX(), ae.getScreenY());
      }
    });

    // ��������� ������ ������������ � �������� ����� ����
    rootNode.setTop(mb);

    // ����������� ��������� ��������
    FlowPane fpRoot = new FlowPane(10, 10);
    fpRoot.setAlignment(Pos.CENTER);
    Separator separator = new Separator();
    separator.setPrefWidth(260);
    fpRoot.getChildren().addAll(response, separator,  tf);

    // ��� ���� ������
    rootNode.setBottom(tbDebug);
    rootNode.setCenter(fpRoot);
    myStage.show();
  }

  // ����� ��� �������� ���� File
  void makeFileMenu() {
    // ������� ������ ���� (� ����������)
    Menu fileMenu = new Menu("_����");

    // � ���� ������
    MenuItem open = new MenuItem("�������");
    MenuItem close = new MenuItem("�������");
    MenuItem save = new MenuItem("���������");
    MenuItem exit = new MenuItem("�����");
    
    // ��������� �������� ������� ��� ���
    open.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
    close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));
    save.setAccelerator(KeyCombination.keyCombination("shortcut+S"));
    exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
    
    // � �����������
    open.setOnAction(MEHandler);
    close.setOnAction(MEHandler);
    save.setOnAction(MEHandler);
    exit.setOnAction(MEHandler);

    // ��������� ������ � ����
    fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);

    // � ���� ���� - � �������
    mb.getMenus().add(fileMenu);
  }
  
  
  // ������� ���� Options
  void makeOptionsMenu() {
    Menu optionsMenu = new Menu("���������");

    // ������� Colors
    Menu colorsMenu = new Menu("�����");

    // � �������� ������� - ��������
    CheckMenuItem red = new CheckMenuItem("�������");
    CheckMenuItem green = new CheckMenuItem("�������");
    CheckMenuItem blue = new CheckMenuItem("�����");
    
    // �������� �� ���������
    green.setSelected(true);

    // �������� "�������" ���� � ������������ ��� � Options
    colorsMenu.getItems().addAll(red, green, blue);
    optionsMenu.getItems().add(colorsMenu);


    // ������� ������� Priority
    Menu priorityMenu = new Menu("���������");

    // ��� ������ - ����������� � ������

    RadioMenuItem high = new RadioMenuItem("�������");
    RadioMenuItem low = new RadioMenuItem("������");
    ToggleGroup tg = new ToggleGroup();
    high.setToggleGroup(tg);
    low.setToggleGroup(tg);
    high.setSelected(true);

    // �������� "������������" ���� � ������������ ��� � Options
    priorityMenu.getItems().addAll(high, low);
    optionsMenu.getItems().add(priorityMenu);

    // ��������� ��� �������
    optionsMenu.getItems().add(new SeparatorMenuItem());

    // � ����� Reset
    MenuItem reset = new MenuItem("�����");
    optionsMenu.getItems().add(reset);

    // ��������� ����������� ��� �������
    red.setOnAction(MEHandler);
    green.setOnAction(MEHandler);
    blue.setOnAction(MEHandler); 
    high.setOnAction(MEHandler);
    low.setOnAction(MEHandler);
    reset.setOnAction(MEHandler);

    // � ���������� ��� �����������
    tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
      public void changed(ObservableValue<? extends Toggle> changed,
                         Toggle oldVal, Toggle newVal) {
        if(newVal==null) return;

        // �������� ��������� �������
        RadioMenuItem rmi = (RadioMenuItem) newVal;

        // � ���������� ���
        response.setText("��������� " + rmi.getText());
      }
    });

    // ��������� Options � ������� ����
    mb.getMenus().add(optionsMenu);
  }


  // ����������� ����
  void makeContextMenu() {

    // ������� ������
    MenuItem cut = new MenuItem("��������");
    MenuItem copy = new MenuItem("����������");
    MenuItem paste = new MenuItem("��������");

    // ������ ���� ����
    editMenu = new ContextMenu(cut, copy, paste);
    // �����������
    cut.setOnAction(MEHandler);
    copy.setOnAction(MEHandler);
    paste.setOnAction(MEHandler);
  }

  // ������ ������������
  void makeToolBar() {
    // ������� ������
    Button btnSet = new Button("���������� �����", new ImageView("setBP.png"));
    Button btnClear = new Button("����� �����", new ImageView("clearBP.png"));
    Button btnResume = new Button("���������� ������", new ImageView("resume.png"));

    // ������� �������
    btnSet.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    btnClear.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    btnResume.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

    // �� ������ ���������
    btnSet.setTooltip(new Tooltip("���������� �����"));
    btnClear.setTooltip(new Tooltip("����� �����"));
    btnResume.setTooltip(new Tooltip("���������� ������"));

    // ������� ���� ������
    tbDebug = new ToolBar(btnSet, btnClear, btnResume);

    // ����������� ��� ������
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