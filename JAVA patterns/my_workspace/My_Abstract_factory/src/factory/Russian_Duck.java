package factory;

import Duck_impl_Toys.Plastik_Duck;
import Duck_impl_animal.Sea_Duck;
import Duck_impl_suveniar.Wooden_Duck;
import Types_duck_interface.Animal_duck;
import Types_duck_interface.Suveniar_Duck;
import Types_duck_interface.Toys_duck;
import factory_interface.Duck_factory_int;

public class Russian_Duck implements Duck_factory_int {
	
	public  Animal_duck createAnimal()
	{
		return new Sea_Duck();
	}
	
	public Suveniar_Duck createSuveniar(){
		return  new Wooden_Duck();
		
	}

	
	public Toys_duck createToys(){
		return  new Plastik_Duck();
		
	}
}
