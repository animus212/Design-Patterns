package HOTEL;

import Workers.Worker;

import java.util.ArrayList;

public class Hotel {//singleton
private ArrayList<Worker> workers;
private static Hotel hotelInstance;

    private Hotel() {
        workers = new ArrayList<>();
    }

    public static Hotel getHotelInstance(){
        if(hotelInstance == null){
            hotelInstance = new Hotel();
        }
        return hotelInstance;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "workers=" + workers +
                '}';
    }
}
