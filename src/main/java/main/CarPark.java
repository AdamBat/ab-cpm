package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarPark {
    private int parkPlace;
    private int latestTicketNumber =5000;
    private Car car;
    private Map<Integer,Car> parkLoad = new HashMap<>();

    public int getParkPlace() {
        return parkPlace;
    }

    public void setParkPlace(int parkPlace) {
        this.parkPlace = parkPlace;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getLatestTicketNumber() {
        return latestTicketNumber;
    }

    public void setLatestTicketNumber(int latestTicketNumber) {
        this.latestTicketNumber = latestTicketNumber;
    }

    public Map<Integer, Car> getParkLoad() {
        return parkLoad;
    }

    public void setParkLoad(Map<Integer, Car> parkLoad) {
        this.parkLoad = parkLoad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPark carPark = (CarPark) o;
        return parkPlace == carPark.parkPlace &&
                latestTicketNumber == carPark.latestTicketNumber &&
                Objects.equals(car, carPark.car) &&
                Objects.equals(parkLoad, carPark.parkLoad);
    }

    @Override
    public int hashCode() {

        return Objects.hash(parkPlace, latestTicketNumber, car, parkLoad);
    }
}
