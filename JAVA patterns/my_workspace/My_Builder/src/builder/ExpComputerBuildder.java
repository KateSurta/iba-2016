package builder;

public class ExpComputerBuildder extends ComputerBuilder{
	
	public void buildSystemBlock(){
		computer.setSystemBlock("HPP");
	}
	
	public void buildDisplay(){
		computer.setDisplay("Acer");
	}
	
	public void buildManipulators(){
		computer.setManipulators("mouse+keyboards+subbuffer");
	}


}
