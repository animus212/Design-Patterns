package Resident;

import Room.Room;

import java.util.ArrayList;

public class Resident {
    String name = "";
    int age = 0;
    int durationOfStay = 0;
    Room assignedRoom = null;
    ArrayList<String> serviceList = null;
    double totalCost = 0;

    public Resident() {
        this.serviceList = new ArrayList<String>();
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

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public Room getAssignedRoom() {
        return assignedRoom;
    }

    public void setAssignedRoom(Room assignedRoom) {
        this.assignedRoom = assignedRoom;
    }

    public ArrayList<String> getServicesList() {
        return serviceList;
    }

    public void setServicesList(ArrayList<String> serviceList) {
        this.serviceList = serviceList;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Resident{" + "name='" + name + '\'' + ", age=" + age + ", durationOfStay=" + durationOfStay + ", assignedRoom=" + assignedRoom + ", servicesList=" + serviceList + ", totalCost=" + totalCost + '}';
    }
}
