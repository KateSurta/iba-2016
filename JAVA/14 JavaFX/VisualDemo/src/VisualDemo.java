
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

public class VisualDemo extends Application {
 
	  // переменные для силы эффектов и преобразований
	  double angle = 0.0;
	  double glowVal = 0.0;
	  boolean shadow = false;
	  double scaleFactor = 1.0;

	  // создаем объекты эффектов и преобразований
	  Glow glow = new Glow(0.0);
	  InnerShadow innerShadow = new InnerShadow(10.0, Color.RED);
	  Rotate rotate = new Rotate();
	  Scale scale = new Scale(scaleFactor, scaleFactor);

	  // четыре кнопки - по одной на эффект или преобразование
	  Button btnRotate = new Button("Rotate");
	  Button btnGlow = new Button("Glow");
	  Button btnShadow = new Button("Shadow off");
	  Button btnScale = new Button("Scale");

	  public static void main(String[] args) {

	    launch(args);
	  }

	  public void start(Stage myStage) {

	    myStage.setTitle("Примеры эффектов и преобразований");

	    FlowPane rootNode = new FlowPane(10, 10);
	    rootNode.setAlignment(Pos.CENTER);
	    Scene myScene = new Scene(rootNode, 300, 100);
	    myStage.setScene(myScene);

	    // подсказки для кнопок
	    btnGlow.setTooltip(new Tooltip("Нажми, чтобы подсветить"));
	    btnRotate.setTooltip(new Tooltip("Нажми, чтобы прокрутить"));
	    btnScale.setTooltip(new Tooltip("Нажми, чтобы увеличть"));
	    
	    // устанавливаем начальные значения эффектов и преобразований
	    btnGlow.setEffect(glow);
	    btnRotate.getTransforms().add(rotate);
	    btnScale.getTransforms().add(scale);

	    // приемники событий кнопок
	    // Rotate
	    btnRotate.setOnAction(new EventHandler<ActionEvent>() { 
	        public void handle(ActionEvent ae) {
	            // на каждое нажатие прокручиваем на 30 градусов (ось вращения - по центру кнопки)
	            angle += 30.0;

	            rotate.setAngle(angle);
	            rotate.setPivotX(btnRotate.getWidth()/2);
	            rotate.setPivotY(btnRotate.getHeight()/2);
	          }
	        });

	        // Scale
	        btnScale.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent ae) {
	            // при каждом нажатии меняем размер кнопки
	            scaleFactor += 0.1;
	            if(scaleFactor > 1.0) scaleFactor = 0.4;

	            scale.setX(scaleFactor);
	            scale.setY(scaleFactor);

	          }
	        });

	        // Glow
	        btnGlow.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent ae) {
	            // при каждом нажатии меняем интерсивность свечения
	            glowVal += 0.1;
	            if(glowVal > 1.0) glowVal = 0.0;
	            glow.setLevel(glowVal);
	          }
	        });

	        // Shadow
	        btnShadow.setOnAction(new EventHandler<ActionEvent>() {
	          public void handle(ActionEvent ae) {
	            // при каждом нажатии включаем или отключаем тень
	            shadow = !shadow;
	            if(shadow) {
	              btnShadow.setEffect(innerShadow);
	              btnShadow.setText("Shadow on");
	            } else {
	              btnShadow.setEffect(null);
	              btnShadow.setText("Shadow off");
	            }
	          }
	        });

	        // собираем граф сцены
	        rootNode.getChildren().addAll(btnRotate, btnScale, btnGlow, btnShadow); 
	        myStage.show();
	      }
	    }
	    