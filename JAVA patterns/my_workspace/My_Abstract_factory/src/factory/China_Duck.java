package factory;

import Duck_impl_Toys.Rubber_Duck;
import Duck_impl_animal.Fly_Duck;
import Duck_impl_suveniar.Porcelain_Duck;
import Types_duck_interface.Animal_duck;
import Types_duck_interface.Suveniar_Duck;
import Types_duck_interface.Toys_duck;
import factory_interface.Duck_factory_int;

public class China_Duck implements Duck_factory_int{
	
	public Toys_duck createToys(){
		return  new Rubber_Duck();
		
	}
	
	public Suveniar_Duck createSuveniar(){
		return  new Porcelain_Duck();
		
	}
	
	public Animal_duck createAnimal(){
		return  new Fly_Duck();
		
	}
	
	

}
