package zservant;

import java.awt.Point;

public class Mover {
	 /**
	  * Private constructor
	  */
	 private Mover(){};
	 
	 /**
	  * Move movable object to specified position.
	  * @param moved - moved object
	  * @param position - final position
	  */
	 public static void moveTo(IMovable moved, Point position){
	  Point previousPosition = moved.getPosition();
	  System.out.printf("Moving smoothly from position x=%d,y=%d to position x=%d,y=%d \n",
	    previousPosition.x,
	    previousPosition.y,
	    position.x,
	    position.y);
	  moved.setPosition(position);
	 }
	 
	 /**
	  * Move movable object by specified distances.
	  * @param moved - object to be moved
	  * @param x - difference in x-axis
	  * @param y - difference in y-axis
	  */
	 public static void moveBy(IMovable moved, int x, int y){
	  Point previousPosition = moved.getPosition();
	  System.out.printf("Moving smoothly from position x=%d,y=%d to position x=%d,y=%d \n",
	    previousPosition.x,
	    previousPosition.y,
	    previousPosition.x + x,
	    previousPosition.y + y);
	  moved.setPosition(new Point(previousPosition.x + x, previousPosition.y + y));
	 }

}
