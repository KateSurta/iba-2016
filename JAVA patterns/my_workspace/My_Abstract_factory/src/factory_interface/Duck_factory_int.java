package factory_interface;

import Types_duck_interface.Animal_duck;
import Types_duck_interface.Suveniar_Duck;
import Types_duck_interface.Toys_duck;

public interface Duck_factory_int {
	Animal_duck createAnimal();    
	Toys_duck createToys();
	Suveniar_Duck createSuveniar();


}
