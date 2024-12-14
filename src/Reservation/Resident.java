package Reservation;

import java.util.ArrayList;

public class Resident {
    private String name;
    private int age;
    private String phoneNumber; // ID
    private final int bookingId;
    private ArrayList<String> serviceList;

    public Resident(String name, int age, String phoneNumber, int bookingId) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.bookingId = bookingId;
        this.serviceList = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBookingId() {
        return bookingId;
    }

    public ArrayList<String> getServiceList() {
        return serviceList;
    }

    public void setServiceList(ArrayList<String> serviceList) {
        this.serviceList = serviceList;
    }
}
