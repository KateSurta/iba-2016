package test;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;

import zservant.Mover;
import zservant.Triangle;

public class testServant {

	@Test
	public void test() {
		 Triangle triangle = new Triangle(1, 3, 2, new Point(-1,0));
		 
		 //TODO handle it for Rectangle 
		 
		  /*Square square = new Square(2, 4, new Point(2,5));
		  Rectangle rec = new Rectangle(4, 3, -3,6);
		  Mover.moveTo(rec, new Point(3,2));
		  //assert equals on new position of rectangle object
		  assertEquals(new Point(3,2), rec.getPosition());
		  Mover.moveBy(square, 2, 4);
		  assertEquals(new Point(4,9), square.getPosition());*/
		  Mover.moveTo(triangle, new Point(-4,0));
		  assertEquals(new Point(-4,0), triangle.getPosition());
	}

}
