package decorators;

import objects.Button;
import objects.Component;
import objects.TextView;
import objects.Window;

public class Start {
    
    private static Component window;
    private static Component textView;
    private static Component button;
    
    public static void main(String[] args) {
        
        
        boolean showBorder = true;
        
        if (!showBorder){
            window = new Window();
            textView = new TextView();
            button = new Button();
        }else{
            window = new BorderDecorator(new Window());
            textView = new ColorDecorator(new BorderDecorator(new Button()));// decorator in decorator
            button = new BorderDecorator(new Button());
        }
        
        
        window.draw();
        textView.draw();
        button.draw();
        
        
    }

}
