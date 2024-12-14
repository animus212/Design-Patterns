package Reservation;

import Room.*;
import Boarding.*;

import java.time.LocalDate;

public class Booking {
    private static int lastId = 0;
    private final int id;
    private Room room;
    private int durationOfStay;
    private BoardingFactory factory;
    private String boardingType;
    private final LocalDate date;

    public Booking(Room room, int durationOfStay, String boardingType, LocalDate date) {
        this.id = lastId;
        this.room = room;
        this.durationOfStay = durationOfStay;
        this.factory = new BoardingFactory();
        this.boardingType = boardingType;
        this.date = date;

        lastId += 1;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

    public void setFactory(BoardingFactory factory) {
        this.factory = factory;
    }

    public String getBoardingType() {
        return boardingType;
    }

    public void setBoardingType(String boardingType) {
        this.boardingType = boardingType;
    }

    public double calculateCost() {
        return (room.getCost() + factory.createBoarding(boardingType).getCost()) * durationOfStay;
    }
}
