
public class LeatherInterior extends CarDecorator {
    public LeatherInterior(Car_int car) {
        super(car);
    }
    
    public int getPrice() {
        return car.getPrice() + 3000;
    }
    
    public String getModel() {
        return car.getModel() + " with leather interior";
    
    }
    
}   
    
