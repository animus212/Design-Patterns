package Registry.ResidentOperations;

import Registry.Registry;
import Reservation.Resident;

import java.util.ArrayList;

public abstract class ResidentOperation {
    protected final ArrayList<String> RESIDENT_DATA;
    protected final Registry REGISTRY;
    protected int residentIndex;

    public ResidentOperation(ArrayList<String> RESIDENT_DATA) {
        this.REGISTRY = Registry.getInstance();

        this.RESIDENT_DATA = RESIDENT_DATA;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected void preOperation() {
        int index = 0;

        for (Resident storedResident : REGISTRY.getResidents()) {
            if (storedResident.getPhoneNumber().equalsIgnoreCase(RESIDENT_DATA.get(2))) {
                residentIndex = index;

                return;
            }

            index += 1;
        }

        throw new IllegalArgumentException("Resident Does Not Exist!");
    }

    protected abstract void doOperation();
}
