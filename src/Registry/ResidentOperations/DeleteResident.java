package Registry.ResidentOperations;

import Reservation.Resident;

public class DeleteResident extends ResidentOperation {
    public DeleteResident(Resident resident) {
        super(resident);
    }

    @Override
    protected void preOperation() {
        for (Resident storedResident : registry.getResidents()) {
            if (storedResident.getPhoneNumber().equalsIgnoreCase(resident.getPhoneNumber())) {
                return;
            }
        }

        throw new IllegalArgumentException("Resident Does Not Exist!");
    }

    @Override
    protected void doOperation() {
        registry.removeResident(resident);
    }
}
