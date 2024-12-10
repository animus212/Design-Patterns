package Services;

public class FullBoard extends ServicesDecorator {

    public FullBoard(Resident resident) {
        super(resident);
        resident.setTotalCost(getCost() + resident.getTotalCost());
        resident.getServicesList().add(this);
    }

    @Override
    public Float getCost() {
        return (float)400.0;
    }
}
