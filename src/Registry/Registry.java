package Registry;

import Resident.Resident;
import Room.*;
import Worker.Receptionist;
import Worker.Worker;

import java.util.ArrayList;

public class Registry {
  private ArrayList<Worker> workers;
  private ArrayList<Receptionist> receptionists;
  private ArrayList<Resident> residents;
  private ArrayList<Room> rooms;

  private double bookingIncome;
  private double halfBoardServicesIncome;
  private double fullBoardServicesIncome;
  private double bedAndBreakfastServicesIncome;
  private double totalIncome;

  private static Registry registry = new Registry();

  private Registry() {
    workers = new ArrayList<Worker>();
    receptionists = new ArrayList<Receptionist>();
    residents = new ArrayList<Resident>();
    rooms = new ArrayList<Room>();
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
    return "Hotel{" + "workers=" + workers + ", receptionists=" + receptionists + ", residents=" + residents + ", rooms=" + rooms + ", totalIncome=" + totalIncome + '}';
  }

  public void monthlyIncome() {}

  public void weeklyIncome() {}

  public void annualIncome() {}
}
