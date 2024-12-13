package HOTEL;

import Rooms.Room;
import Resident.Resident;
import Workers.Receptionist;
import Workers.Worker;

import java.util.ArrayList;

public class Hotel {//singleton
private ArrayList<Worker> workers;
private ArrayList<Receptionist> receptionists;
private ArrayList<Resident> residents;
private ArrayList<Room> rooms;

private double bookingIncome;
private double halfBoardServicesIncome;
private double fullBoardServicesIncome;
private double bedAndBreakfastServicesIncome;
private double totalIncome;

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

    public ArrayList<Receptionist> getReceptionists() {
        return receptionists;
    }

    public void setReceptionists(ArrayList<Receptionist> receptionists) {
        this.receptionists = receptionists;
    }

    public ArrayList<Resident> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<Resident> residents) {
        this.residents = residents;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "workers=" + workers +
                ", receptionists=" + receptionists +
                ", residents=" + residents +
                ", rooms=" + rooms +
                ", totalIncome=" + totalIncome +
                '}';
    }

    public void monthlyIncome() {
    }

    public void weeklyIncome() {
    }

    public void annualIncome() {
    }
}
