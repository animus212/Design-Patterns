package Registry.ResidentOperations;

import Reservation.Resident;

import java.util.ArrayList;

public class AddResident extends ResidentOperation {
    public AddResident(ArrayList<String> residentData) {
        super(residentData);
    }

    @Override
    protected void preOperation() {
        for (Resident storedResident : REGISTRY.getResidents()) {
            if (storedResident.getPHONE_NUMBER().equalsIgnoreCase(RESIDENT_DATA.get(2))) {
                throw new IllegalArgumentException("Resident Already Exists!");
            }
        }
    }

    @Override
    protected void doOperation() {
        Resident newResident = new Resident(RESIDENT_DATA.getFirst(), Integer.parseInt(RESIDENT_DATA.get(1)),
                RESIDENT_DATA.get(2), Integer.parseInt(RESIDENT_DATA.get(3)));

        REGISTRY.addResident(newResident);
    }
}
