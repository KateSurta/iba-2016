package transport.impl.car;

import transport.interfaces.Car;

public class Niva implements Car{

    public void drive() {
        System.out.println("Niva drive");
    }

  
    public void stop() {
        System.out.println("Niva stopped");
    }
    
}
