package Registry.ResidentOperations;

import Reservation.Resident;

import java.util.ArrayList;

public class AddResident extends ResidentOperation {
    public AddResident(ArrayList<String> residentData) {
        super(residentData);
    }

    @Override
    protected void preOperation() {
        for (Resident storedResident : registry.getResidents()) {
            if (storedResident.getPhoneNumber().equalsIgnoreCase(residentData.get(2))) {
                throw new IllegalArgumentException("Resident Already Exists!");
            }
        }
    }

    @Override
    protected void doOperation() {
        Resident newResident = new Resident(residentData.getFirst(), Integer.parseInt(residentData.get(1)),
                residentData.get(2), Integer.parseInt(residentData.get(3)));

        registry.addResident(newResident);
    }
}
