package object;

import java.util.ArrayList;
import java.util.List;

import adapter.Coffe_list_printer;
import adapter.Coffe_machine_adapter;

public class Client {
	
	 public static void main(String[] args) {
		 List list = new ArrayList();
		 list.add("Capuchino");
		 list.add("Latte");
		 list.add("Americano");
		 list.add("Chocolate");
		 
		 Coffe_list_printer Coffe_machine_adapter = new Coffe_machine_adapter();
		 Coffe_machine_adapter.print(list);
		 
	 }

}
