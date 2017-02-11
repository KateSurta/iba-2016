package builder;

public class CheapComputerBuilder extends ComputerBuilder{
	public void buildSystemBlock(){
		computer.setSystemBlock("Everest");
	}
	
	public void buildDisplay(){
		computer.setDisplay("crt");
	}
	
	public void buildManipulators(){
		computer.setManipulators("mouse+keyboards");
	}

}
