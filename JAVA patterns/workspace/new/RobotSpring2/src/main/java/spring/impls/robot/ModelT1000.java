package spring.impls.robot;

import spring.interfaces.Hand;
import spring.interfaces.Head;
import spring.interfaces.Leg;
import spring.interfaces.Robot;

public class ModelT1000 implements Robot {

	private Hand hand;
	private Leg leg;
	private Head head;

	public ModelT1000() {
	}

	public ModelT1000(Hand hand, Leg leg, Head head) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
	}

	public void action() {
		head.calc();
		hand.catchSomething();
		leg.go();
	}

	public void dance() {
		System.out.println("T1000 is dancing!");
	}

}
