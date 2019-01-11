package main;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParkService {
    CarPark carPark = new CarPark();
    Map<Integer, Car> parkLoad = carPark.getParkLoad();

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

    public void park(Car car) {
        car.setTicketNr(carPark.getLatestTicketNumber());
        int spaceNr = getFirstFreeSpace(carPark) != 0 ? getFirstFreeSpace(carPark) : 0;
        if(spaceNr != 0) {
            parkLoad.put(getFirstFreeSpace(carPark), car);
            carPark.setLatestTicketNumber(carPark.getLatestTicketNumber() + 1);
        }

    }

    private int getFirstFreeSpace(CarPark carPark) {
        for (int i = 1; i <= 10; i++) {
            if (!parkLoad.keySet().contains(Integer.valueOf(i))) {
                return i;
            }
        }
        return 0;
    }

    public void unpark(int ticketNr) {
        Iterator<Map.Entry<Integer, Car>> entryIt = parkLoad.entrySet().iterator();
        while (entryIt.hasNext()) {
            Map.Entry<Integer, Car> entry = entryIt.next();
            if (entry.getValue().getTicketNr() == ticketNr) {
                parkLoad.remove(entry.getKey());
                break;
            }
        }
    }

    public void compact() {
        Map<Integer, Car> sortedMap = new TreeMap<>(parkLoad);
        Map<Integer, Car> compactedPark = new TreeMap<>();
        int parkPlace = 1;
        for (Map.Entry<Integer, Car> entry : sortedMap.entrySet()) {
            compactedPark.put(parkPlace, entry.getValue());
            parkPlace++;
        }
        parkLoad = compactedPark;
    }

    public String processInstructions(String instructions) {
        List<String> instrList = Arrays.asList(instructions.split(","));
        for (String instr : instrList) {
            if (instr.equals("c")) {
                compact();
            } else if (instr.startsWith("p")) {
                Car car = new Car(instr.substring(1));
                park(car);
            } else if (instr.startsWith("u")) {
                unpark(Integer.valueOf(instr.substring(1)));
            }
            else{
                System.out.println("Instructions incorrect");
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer,Car> entry:parkLoad.entrySet()){
            sb.append(entry.getValue().getPlate()+ ",");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb);
        return sb.toString();
    }


}
