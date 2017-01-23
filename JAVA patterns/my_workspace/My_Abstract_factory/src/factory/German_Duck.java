package factory;

import Duck_impl_Toys.Teddy_Duck;
import Duck_impl_animal.Lake_Duck;
import Duck_impl_suveniar.Cooper_Duck;
import Types_duck_interface.Animal_duck;
import Types_duck_interface.Suveniar_Duck;
import Types_duck_interface.Toys_duck;
import factory_interface.Duck_factory_int;

public  class German_Duck implements Duck_factory_int {
	
	public Animal_duck createAnimal(){
		return  new Lake_Duck();
		
	}
	
	public Toys_duck createToys(){
		return  new Teddy_Duck();
		
	}
	
	public Suveniar_Duck createSuveniar(){
		return  new Cooper_Duck();
		
	}
	

}
