package Room;

public class RoomFactory {
    public Room createRoom(String RoomType, boolean available) {
        if (RoomType.equalsIgnoreCase("single")) {
            return new SingleRoom(available);
        } else if (RoomType.equalsIgnoreCase("double")) {
            return new DoubleRoom(available);
        } else if (RoomType.equalsIgnoreCase("triple")) {
            return new TripleRoom(available);
        }

        throw new IllegalArgumentException();
    }
}
