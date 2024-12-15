package Room;

public abstract class Room {
    protected boolean available;
    protected double cost;

    public Room(boolean available, double cost) {
        this.available = available;
        this.cost = cost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
