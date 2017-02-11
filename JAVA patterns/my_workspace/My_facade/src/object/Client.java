package object;
import Facade.HomeTheaterFacade;
import parts.Amplifier;
import parts.DVDPlayer;
import parts.Popkorn_popper;
import parts.Screen;

public class Client {
	public static void main(String[] args) {
		
		Screen scr = new Screen();
		scr.set_on();
		
		DVDPlayer dvd = new DVDPlayer();
		dvd.turn_on();
		
		Popkorn_popper popkorn = new Popkorn_popper();
		popkorn.cook();		
		
		Amplifier amp = new Amplifier();
		amp.set_volume();		
		
		
		System.out.println("А теперь метод фасада: ");
		HomeTheaterFacade home = new HomeTheaterFacade();
		home.go();
		
	}

}
