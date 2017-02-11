package transport.impl.car;

import transport.interfaces.Car;

public class Porsche implements Car{

 
    public void drive() {
        System.out.println("Drive speed 150 km/h");
    }

    
    public void stop() {
        System.out.println("Stopped at 1 sec");
    }

}
