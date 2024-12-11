package Services;

public abstract class ServicesDecorator extends Resident {
    private double cost;
    private Resident decoratedResident;

    public ServicesDecorator(Resident decoratedResident) {

        this.decoratedResident = decoratedResident;
    }

    public Resident getDecoratedResident() {
        return decoratedResident;
    }

    public void setDecoratedResident(Resident decoratedResident) {
        this.decoratedResident = decoratedResident;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
