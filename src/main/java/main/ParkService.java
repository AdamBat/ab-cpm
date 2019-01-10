package main;

import java.util.Iterator;
import java.util.Map;

public class ParkService {
    CarPark carPark = new CarPark();
    Map<Integer,Car> parkLoad = carPark.getParkLoad();

    public CarPark getCarPark() {
        return carPark;
    }

    public void setCarPark(CarPark carPark) {
        this.carPark = carPark;
    }

    public Map<Integer, Car> getParkLoad() {
        return parkLoad;
    }

    public void setParkLoad(Map<Integer, Car> parkLoad) {
        this.parkLoad = parkLoad;
    }

    public void park(Car car){
        car.setTicketNr(carPark.getLatestTicketNumber());
        parkLoad.put(getFirstFreeSpace(carPark),car);
        carPark.setLatestTicketNumber(carPark.getLatestTicketNumber()+1);

    }
    private int getFirstFreeSpace(CarPark carPark){
        for(int i = 1; i<=10; i++){
            if(!carPark.getParkLoad().keySet().contains(Integer.valueOf(i))){
                return i;
            }
        }
        return 0;
    }

    public void unpark(int ticketNr){
        Iterator <Map.Entry<Integer,Car>> entryIt = parkLoad.entrySet().iterator();
        while(entryIt.hasNext()){
            Map.Entry<Integer, Car> entry = entryIt.next();
            if(entry.getValue().getTicketNr()==ticketNr){
                parkLoad.remove(entry.getKey());
                break;
            }
        }
    }



}
