package patternsdemo.factorymethod;

// fctory method exanple
public class CarSelector {
    
    // Factory method
    public Car getCar(RoadType roadType) {
        Car car = null;
        switch (roadType) {
            case CITY:
                car = new Porsche();
                break;
            case OFF_ROAD:
                car = new Geep();
                break;
            case GAZON:
                car = new NewGeep();
                break;
            case HIGWAY:
                car = new Citroen();
                break;    
                
        }

        return car;
    }
}
