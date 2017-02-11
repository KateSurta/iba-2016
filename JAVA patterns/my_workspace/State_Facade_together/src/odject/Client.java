package odject;

import Facade.HomeTheatreFacade;
import State_parts.Amplifier;
import State_parts.DVDPlayer;
import State_parts.Popkorn;
import State_parts.Screen;
import State_parts.StateInterface;
import context.Context;

public class Client {
	public static void main(String[] args) {
		 Context context = new Context();
		 StateInterface  statePopkorn = new Popkorn();
	        StateInterface stateScreen = new Screen();
	        StateInterface  stateDVDPlayer = new DVDPlayer();
	        StateInterface  stateAmplifier = new Amplifier(); 
	        

	        context.setState(statePopkorn);
	        context.action();

	        context.setState(stateDVDPlayer);
	        context.action();
	        
	        context.setState(stateScreen);
	        context.action();
	        
	        context.setState(stateAmplifier);
	        context.action();
	        
		 System.out.println("А теперь метод фасада: ");
			HomeTheatreFacade home = new HomeTheatreFacade();
			home.go();
	}
}
