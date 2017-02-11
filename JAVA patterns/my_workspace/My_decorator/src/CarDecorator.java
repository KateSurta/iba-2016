
public class CarDecorator implements Car_int {
	
protected final Car_int car;
    
    public CarDecorator(Car_int car) {
        this.car = car;
    }

    
    public int getPrice() {
        return car.getPrice();
    }

    
    public String getModel() {
        return car.getModel();
    }

}
