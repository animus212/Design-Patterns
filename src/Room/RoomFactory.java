package Room;

public class RoomFactory {
    public Room createRoom(String RoomType, boolean available) {
        if (RoomType.equalsIgnoreCase("SingleRoom")) {
            return new SingleRoom(available);
        } else if (RoomType.equalsIgnoreCase("DoubleRoom")) {
            return new DoubleRoom(available);
        } else if (RoomType.equalsIgnoreCase("TripleRoom")) {
            return new TripleRoom(available);
        }

        throw new IllegalArgumentException();
    }
}
