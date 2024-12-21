package Room;

public class TripleRoom extends Room {
    public TripleRoom(boolean available) {
        super(available);
    }

    @Override
    public double getCost() {
        return 5000.0;
    }
}
