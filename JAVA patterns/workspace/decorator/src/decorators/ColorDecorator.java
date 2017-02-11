package decorators;

import objects.Component;

public class ColorDecorator extends Decorator {

    public ColorDecorator(Component component) {
        super(component);
    }

   
    public void afterDraw() {
        System.out.println("... added color");
    }

}
