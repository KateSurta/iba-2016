package Facade;

import parts.Amplifier;
import parts.DVDPlayer;
import parts.Popkorn_popper;
import parts.Screen;

public class HomeTheaterFacade {	
	 private Amplifier amp = new Amplifier();
	    private DVDPlayer dvd = new DVDPlayer();
	    private Popkorn_popper popkorn = new Popkorn_popper();
	    private Screen scr = new Screen();

	    public void go(){
	        dvd.turn_on();
	        dvd.turn_off();
	        scr.set_on();
	        scr.set_off();
	        amp.set_volume();
	        popkorn.cook();	        
	        
	    }        
	
}
