package Room;

public class AvailableState implements RoomState {
    @Override
    public void checkIn(Room room) {
        System.out.println("Room checked in.");

        room.setState(new OccupiedState());
    }

    @Override
    public void checkOut(Room room) {
        System.out.println("Room is already available.");
    }

    @Override
    public String toString() {
        return "Available";
    }
}
