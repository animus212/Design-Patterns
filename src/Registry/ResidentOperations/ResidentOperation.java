package Registry.ResidentOperations;

import Registry.Registry;
import Reservation.Resident;

import java.util.ArrayList;

public abstract class ResidentOperation {
    protected final ArrayList<String> residentData;
    protected final Registry registry;
    protected int residentIndex;

    public ResidentOperation(ArrayList<String> residentData) {
        this.registry = Registry.getInstance();

        this.residentData = residentData;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected void preOperation() {
        int index = 0;

        for (Resident storedResident : registry.getResidents()) {
            if (storedResident.getPhoneNumber().equalsIgnoreCase(residentData.get(2))) {
                residentIndex = index;

                return;
            }

            index += 1;
        }

        throw new IllegalArgumentException("Resident Does Not Exist!");
    }

    protected abstract void doOperation();
}
