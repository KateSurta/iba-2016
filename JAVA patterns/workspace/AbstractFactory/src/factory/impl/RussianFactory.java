package factory.impl;

import factory.interfaces.TransportFactory;
import transport.interfaces.Aircraft;
import transport.interfaces.Car;
import transport.impl.car.Niva;
import transport.impl.aircraft.TU134;


public class RussianFactory implements TransportFactory{

    
    public Car createCar() {
        return new Niva();
    }

   
    public Aircraft createAircraft() {
        return new TU134();
    }

}
