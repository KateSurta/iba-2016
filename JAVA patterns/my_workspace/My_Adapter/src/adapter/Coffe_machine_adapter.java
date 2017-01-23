package adapter;

import java.util.List;

import object.Coffe_machine;

public class Coffe_machine_adapter implements Coffe_list_printer {
	

    private  Coffe_machine machine = new  Coffe_machine();
    
    public void print(List<String> list) {
        for (String text : list) {
        	machine.print(text);            
        }
    }

}
