package spring.impls.pool;

import java.util.Collection;

import spring.interfaces.Robot;
import spring.interfaces.RobotPool;

public class T1000Pool implements RobotPool {

	private Collection<Robot> robotCollection;

	public T1000Pool(Collection<Robot> robotCollection) {
		super();
		this.robotCollection = robotCollection;
	}

	
	public Collection<Robot> getRobotCollection() {
		return robotCollection;
	}

	public void beginShow() {
		for (Robot robot : robotCollection) {
			robot.action();
		}
	}

}
