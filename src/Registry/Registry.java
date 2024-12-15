package Registry;

import Reservation.*;
import Room.*;
import Employee.Worker;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Worker> workers;
    private ArrayList<Resident> residents;
    private ArrayList<Room> rooms;
    private ArrayList<Booking> bookings;

    private static final Registry registry = new Registry();

    private Registry() {
        this.workers = new ArrayList<Worker>();
        this.residents = new ArrayList<Resident>();
        this.rooms = new ArrayList<Room>();
        this.bookings = new ArrayList<Booking>();
    }

    public static Registry getInstance() {
        return registry;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<Worker> workers) {
        this.workers = workers;
    }

    public void addWorker(Worker newWorker) {
        workers.add(newWorker);
    }

    public void removeWorker(int workerIndex) {
        workers.remove(workerIndex);
    }

    public void editWorker(int workerIndex, Worker newWorker) {
        workers.set(workerIndex, newWorker);
    }

    public ArrayList<Resident> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<Resident> residents) {
        this.residents = residents;
    }

    public void addResident(Resident newResident) {
        residents.add(newResident);
    }

    public void removeResident(Resident oldResident) {
        residents.remove(oldResident);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }
}
