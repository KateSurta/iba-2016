
public class Parking_car extends CarDecorator {
		    public Parking_car(Car_int car) {
		        super(car);
		    }
		    
		    public int getPrice() {
		        return car.getPrice() + 4000;
		    }
		    
		    public String getModel() {
		        return car.getModel() + " With Parking";
		    }

}
