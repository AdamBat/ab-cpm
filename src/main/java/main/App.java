package main;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        ParkService parkService = new ParkService();

        Car car = new Car("ABC");
        Car car1 = new Car("XYZ");
        parkService.park(car);
        parkService.park(car1);
        parkService.unpark(5000);
    }
}
