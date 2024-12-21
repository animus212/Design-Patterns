package Room;

public class SingleRoom extends Room {
    public SingleRoom(boolean available) {
        super(available);
    }

    @Override
    public double getCost() {
        return 500.0;
    }
}
