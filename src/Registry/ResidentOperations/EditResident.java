package Registry.ResidentOperations;

import Reservation.Resident;

public class EditResident extends ResidentOperation {
    public EditResident(Resident resident) {
        super(resident);
    }

    @Override
    protected void preOperation() {
        for (Resident storedResident : registry.getResidents()) {
            if (storedResident.getPhoneNumber().equalsIgnoreCase(resident.getPhoneNumber())) {
                registry.removeResident(storedResident);    // Remove storedResident here because resident is edited

                return;
            }
        }

        throw new IllegalArgumentException("Resident Does Not Exist!");
    }

    @Override
    protected void doOperation() {
        registry.addResident(resident);
    }
}
