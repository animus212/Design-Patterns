package Room;

public abstract class Room {
    protected boolean available;

    public Room(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    public abstract double getCost();
}
