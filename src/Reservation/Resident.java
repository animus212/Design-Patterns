package Reservation;

public class Resident {
    private final String phoneNumber; // ID
    private final int bookingId;
    private String name;
    private int age;
    private String serviceList;

    public Resident(String name, int age, String phoneNumber, int bookingId) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.bookingId = bookingId;
        this.serviceList = "";
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

    public int getBookingId() {
        return bookingId;
    }

    public String getServiceList() {
        return serviceList;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
    }
}
