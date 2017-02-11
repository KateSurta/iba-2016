package builder;

abstract class ComputerBuilder {
	protected Computer computer;

	public Computer getComputer(){
		return computer;
	} 
	
	public void CreateComputer(){
		computer = new Computer();	
	}
	
	public abstract void buildSystemBlock();
	public abstract void buildDisplay();
	public abstract void buildManipulators();
	
			
}
