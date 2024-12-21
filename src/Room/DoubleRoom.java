package Room;

public class DoubleRoom extends Room {
    public DoubleRoom(boolean available) {
        super(available);
    }

    @Override
    public double getCost() {
        return 1000.0;
    }
}
