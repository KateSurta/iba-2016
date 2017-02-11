package patternsdemo.factorymethod;

import java.util.ArrayList;

public class Geep implements Car{

	   
    public void drive() {
        System.out.println("Drive speed 50 km/h");
    } 
    
   
    public void stop() {
        System.out.println("Stopped at 5 sec");
    }

}
