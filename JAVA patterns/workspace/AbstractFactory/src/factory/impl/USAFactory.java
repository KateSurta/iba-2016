package factory.impl;

import factory.interfaces.TransportFactory;
import transport.interfaces.Aircraft;
import transport.impl.aircraft.Boeing747;
import transport.interfaces.Car;
import transport.impl.car.Porsche;


public class USAFactory implements TransportFactory{

    
    public Car createCar() {
        return new Porsche();
    }

 
    public Aircraft createAircraft() {
        return new Boeing747();
    }

}
