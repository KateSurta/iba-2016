package start;

import factory.impl.RussianFactory;
import factory.impl.USAFactory;
import factory.interfaces.TransportFactory;
import transport.interfaces.Aircraft;

public class Start {
    
    private static TransportFactory factory;
    
    public static void main(String[] args) {
        System.err.println("begin");
        if (true){
            factory = new RussianFactory();
        }else{
            factory = new USAFactory();
        }
        
        
        factory.createAircraft().flight();
        factory.createCar().drive();
        
        
    }

}
