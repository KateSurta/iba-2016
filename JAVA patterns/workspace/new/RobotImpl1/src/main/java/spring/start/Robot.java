package spring.start;

import spring.objects.SonyHand;
import spring.objects.SonyHead;
import spring.objects.SonyLeg;

public class Robot {
	
	private SonyHand hand = new SonyHand();
	private SonyLeg leg = new SonyLeg();
	private SonyHead head = new SonyHead();
	
	public void action(){
		head.calc();
		hand.catchSomething();
		leg.go();
	}

}
