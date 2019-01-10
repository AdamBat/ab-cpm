package main;

import java.util.Objects;

public class Car {
    private String plate;
    private int ticketNr;

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getTicketNr() {
        return ticketNr;
    }

    public void setTicketNr(int ticketNr) {
        this.ticketNr = ticketNr;
    }

    public Car(String plate, int ticketNr) {
        this.plate = plate;
        this.ticketNr = ticketNr;
    }

    public Car(String plate) {
        this.plate = plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return ticketNr == car.ticketNr &&
                Objects.equals(plate, car.plate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(plate, ticketNr);
    }
}
