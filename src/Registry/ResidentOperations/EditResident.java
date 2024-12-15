package Registry.ResidentOperations;

import Reservation.Resident;

import java.util.ArrayList;

public class EditResident extends ResidentOperation {
    public EditResident(ArrayList<String> residentData) {
        super(residentData);
    }

    @Override
    protected void doOperation() {
        Resident newResident = new Resident(residentData.getFirst(), Integer.parseInt(residentData.get(1)),
                residentData.get(2), Integer.parseInt(residentData.get(3)));

        newResident.setServiceList(residentData.getLast());

        registry.editResident(residentIndex, newResident);
    }
}
