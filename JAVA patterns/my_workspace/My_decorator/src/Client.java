
public class Client {
	
	public static void main(String[] args) {
        Car_int car = new SimpleCar();
        System.out.println("Price: " + car.getPrice() 
            + ", Model: " + car.getModel());
        
        car = new Parking_car(car);
        System.out.println("Price: " + car.getPrice() 
            + ", Model: " + car.getModel());
        
        car = new LeatherInterior(car);
        System.out.println("Price: " + car.getPrice() 
            + ", Model: " + car.getModel());
    }

}
