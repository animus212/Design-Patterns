package Room;

public class RoomFactory {
  public Room createRoom(String RoomType) {
    if (RoomType.equalsIgnoreCase("single")) {
      return new SingleRoom();
    } else if (RoomType.equalsIgnoreCase("double")) {
      return new DoubleRoom();
    } else if (RoomType.equalsIgnoreCase("triple")) {
      return new TripleRoom();
    }

    throw new IllegalArgumentException();
  }
}
