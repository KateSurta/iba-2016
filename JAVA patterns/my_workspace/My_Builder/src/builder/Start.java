package builder;

public class Start {
	public static void main(String[] args) {
		Director director = new Director();
		ComputerBuilder CheapComputerBuilder = new CheapComputerBuilder();
		ComputerBuilder ExpComputerBuildder = new ExpComputerBuildder();
		
		
		
		director.setComputerBuilder(CheapComputerBuilder);
		director.setComputerBuilder(ExpComputerBuildder);	
		director.constructComputer();
		Computer computer = director.getComputer();	
		
		
		
		
	}

}
