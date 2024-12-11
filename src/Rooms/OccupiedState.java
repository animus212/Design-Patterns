package Rooms;

public class OccupiedState implements RoomState{

    @Override
    public void checkIn(Room room) {
        System.out.println("Room is already occupied.");
    }

    @Override
    public void checkOut(Room room) {
        System.out.println("Room checked out.");
        room.setState(new AvailableState());
    }

    @Override
    public String toString() {
        return "Occupied";
    }
}
