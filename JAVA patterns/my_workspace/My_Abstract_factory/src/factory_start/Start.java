package factory_start;
import java.util.*;
import factory.China_Duck;
import factory.German_Duck;
import factory.Russian_Duck;
import factory_interface.Duck_factory_int;


public class Start {
	static Scanner reader = new Scanner(System.in);
	
    private static Duck_factory_int factory;  
    public static void main(String[] args) {  
    	System.out.println("¬ведите номер фабрики: 1 - China_Duck, 2 - German_Duc, 3 - Russian_Duck ");
    	
    	int a = reader.nextInt();   	
    	
          if (a == 1){        	 
            factory = new China_Duck();
        } if(a == 2){
            factory = new German_Duck();           
        } if(a == 3){
        	factory = new Russian_Duck();        	
        }      
        
        if(a == 0 || a > 3) {
        	System.out.println("‘абрика не найдена!");
        }         
        factory.createToys().behavior();
        factory.createSuveniar().material();
        factory.createAnimal().fly(); 
           
    }

}
