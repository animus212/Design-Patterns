package Reservation;

import Boarding.BoardingFactory;
import Registry.Registry;

import java.time.LocalDate;

public class Booking implements Cloneable {
    private static int lastId = 0;
    private final int ID;
    private final BoardingFactory FACTORY;
    private final LocalDate DATE;
    private int roomNumber; // Room index in the REGISTRY since rooms never change.
    private int durationOfStay;
    private String boardingType;

    public Booking(int roomNumber, int durationOfStay, String boardingType) {
        this.ID = lastId;
        this.roomNumber = roomNumber;
        this.durationOfStay = durationOfStay;
        this.FACTORY = new BoardingFactory();
        this.boardingType = boardingType;
        this.DATE = LocalDate.now();

        lastId += 1;
    }

    public Booking(int ID, int roomNumber, int durationOfStay, String boardingType, LocalDate DATE) {
        this.ID = ID;
        this.roomNumber = roomNumber;
        this.durationOfStay = durationOfStay;
        this.boardingType = boardingType;
        this.DATE = DATE;
        this.FACTORY = new BoardingFactory();
    }

    public static int getLastId() {
        return lastId;
    }

    public static void setLastId(int lastId) {
        Booking.lastId = lastId;
    }

    public LocalDate getDATE() {
        return DATE;
    }

    public int getID() {
        return ID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getDurationOfStay() {
        return durationOfStay;
    }

    public void setDurationOfStay(int durationOfStay) {
        this.durationOfStay = durationOfStay;
    }

    public BoardingFactory getFACTORY() {
        return FACTORY;
    }

    public String getBoardingType() {
        return boardingType;
    }

    public void setBoardingType(String boardingType) {
        this.boardingType = boardingType;
    }

    public double calculateCost() {
        return (Registry.getInstance().getRooms().get(roomNumber).getCost() +
                FACTORY.createBoarding(boardingType).getCost()) * durationOfStay;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
