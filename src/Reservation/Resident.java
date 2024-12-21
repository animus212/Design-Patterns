package Reservation;

public class Resident {
    private final String PHONE_NUMBER; // ID
    private final int BOOKING_ID;
    private String name;
    private int age;
    private String serviceList;

    public Resident(String name, int age, String PHONE_NUMBER, int BOOKING_ID) {
        this.name = name;
        this.age = age;
        this.PHONE_NUMBER = PHONE_NUMBER;
        this.BOOKING_ID = BOOKING_ID;
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

    public String getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public int getBOOKING_ID() {
        return BOOKING_ID;
    }

    public String getServiceList() {
        return serviceList;
    }

    public void setServiceList(String serviceList) {
        this.serviceList = serviceList;
    }
}
