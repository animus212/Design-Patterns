package Services;

import Rooms.Room;

import java.util.ArrayList;

public class Resident {
     String name = "";
     Integer age = 0;
     Integer durationOfStay = 0;
     Room assignedRoom = null;
     ArrayList<Resident> servicesList = null;
     double totalCost = 0f;

    public Resident() {
        this.servicesList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(Integer durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public Room getAssignedRoom() {
        return assignedRoom;
    }

    public void setAssignedRoom(Room assignedRoom) {
        this.assignedRoom = assignedRoom;
    }

    public ArrayList<Resident> getServicesList() {
        return servicesList;
    }

    public void setServicesList(ArrayList<Resident> servicesList) {
        this.servicesList = servicesList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", durationOfStay=" + durationOfStay +
                ", assignedRoom=" + assignedRoom +
                ", servicesList=" + servicesList +
                ", totalCost=" + totalCost +
                '}';
    }
}
