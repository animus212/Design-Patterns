package Services;

public class HalfBoard extends ServicesDecorator {

    public HalfBoard(Resident resident) {
        super(resident);
        setTotalCost(200 + resident.getTotalCost());
        getServicesList().add(this);
    }

    @Override
    public double getCost() {
        return getDecoratedResident().getTotalCost();
    }


}
