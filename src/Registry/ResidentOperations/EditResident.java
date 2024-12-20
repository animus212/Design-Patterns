package Registry.ResidentOperations;

import Reservation.Resident;

import java.util.ArrayList;

public class EditResident extends ResidentOperation {
    public EditResident(ArrayList<String> residentData) {
        super(residentData);
    }

    @Override
    protected void doOperation() {
        Resident newResident = new Resident(RESIDENT_DATA.getFirst(), Integer.parseInt(RESIDENT_DATA.get(1)),
                RESIDENT_DATA.get(2), Integer.parseInt(RESIDENT_DATA.get(3)));

        newResident.setServiceList(RESIDENT_DATA.getLast());

        REGISTRY.editResident(residentIndex, newResident);
    }
}
