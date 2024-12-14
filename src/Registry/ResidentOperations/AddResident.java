package Registry.ResidentOperations;

import Reservation.Resident;

public class AddResident extends ResidentOperation {
    public AddResident(Resident resident) {
        super(resident);
    }

    @Override
    protected void preOperation() {
        for (Resident storedResident : registry.getResidents()) {
            if (storedResident.getPhoneNumber().equalsIgnoreCase(resident.getPhoneNumber())) {
                throw new IllegalArgumentException("Resident Already Exists!");
            }
        }
    }

    @Override
    protected void doOperation() {
        registry.addResident(resident);
    }
}
