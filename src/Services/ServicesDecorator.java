package Services;

public abstract class ServicesDecorator extends Resident {
    private Float cost;
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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }
}
