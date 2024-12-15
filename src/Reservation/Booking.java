package Reservation;

import Boarding.BoardingFactory;
import Registry.Registry;

import java.time.LocalDate;

public class Booking implements Cloneable {
    private static int lastId = 0;
    private final int id;
    private int roomNumber; // Room index in the registry since rooms never change.
    private int durationOfStay;
    private final BoardingFactory factory;
    private String boardingType;
    private final LocalDate date;

    public Booking(int roomNumber, int durationOfStay, String boardingType) {
        this.id = lastId;
        this.roomNumber = roomNumber;
        this.durationOfStay = durationOfStay;
        this.factory = new BoardingFactory();
        this.boardingType = boardingType;
        this.date = LocalDate.now();

        lastId += 1;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
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

    public BoardingFactory getFactory() {
        return factory;
    }

    public String getBoardingType() {
        return boardingType;
    }

    public void setBoardingType(String boardingType) {
        this.boardingType = boardingType;
    }

    public double calculateCost() {
        return (Registry.getInstance().getRooms().get(roomNumber).getCost() +
                factory.createBoarding(boardingType).getCost()) * durationOfStay;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
