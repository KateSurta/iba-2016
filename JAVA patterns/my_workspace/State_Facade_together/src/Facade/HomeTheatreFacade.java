package Facade;

import State_parts.Amplifier;
import State_parts.DVDPlayer;
import State_parts.Popkorn;
import State_parts.Screen;

public class HomeTheatreFacade {	
		 private Amplifier amp = new Amplifier();
		 private DVDPlayer dvd = new DVDPlayer();
		 private Popkorn popkorn = new Popkorn();
		 private Screen scr = new Screen();

		    public void go(){
		    	dvd.action();	
		    	amp.action();
		        popkorn.action();
		        scr.action();
		        
		        
		    }        

}
