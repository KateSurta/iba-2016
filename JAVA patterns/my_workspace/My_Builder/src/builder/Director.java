package builder;

public class Director {
	private ComputerBuilder computerBuilder;
	public void setComputerBuilder(ComputerBuilder computerBuilder){
		this.computerBuilder = computerBuilder;
	}
	public Computer getComputer(){
		return computerBuilder.getComputer();
	}
	public void constructComputer(){
		computerBuilder.CreateComputer();
		computerBuilder.buildDisplay();
		computerBuilder.buildSystemBlock();
		computerBuilder.buildManipulators();
		
	}
}
