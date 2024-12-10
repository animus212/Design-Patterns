package Services;

public class BedAndBreakfast extends ServicesDecorator {

    public BedAndBreakfast(Resident resident) {
        super(resident);
        resident.setTotalCost(getCost() + resident.getTotalCost());
        resident.getServicesList().add(this);
    }

    @Override
    public Float getCost() {
        return (float)100.0;
    }
}
