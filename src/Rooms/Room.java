package Rooms;

public abstract class Room {
    protected final String type;
    protected double cost;
    protected RoomState state;


    public Room(String type, double cost) {
        this.type = type;
        this.cost = cost;
        this.state = new AvailableState();
    }

    public Room() {
        this.type = null;
        this.cost = 0;
        this.state = new AvailableState();
    }

    public boolean checkIn() {
        if (this.state instanceof AvailableState){
            this.state.checkIn(this);
            return true;
        }
        else
            return false;
    }

    public boolean checkOut() {
        if (this.state instanceof OccupiedState){
            this.state.checkOut(this);
            return true;
        }
        else
            return false;
    }

    public RoomState getState() {
        return state;
    }

    public void setState(RoomState state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }



    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean occupied(){
        return this.state instanceof OccupiedState;
    }

    @Override
    public String toString() {
        return "Room{" +
                "type='" + type + '\'' +
                ", cost=" + cost +
                ", state=" + state +
                '}';
    }
}
