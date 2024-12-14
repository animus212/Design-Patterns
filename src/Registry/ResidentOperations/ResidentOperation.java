package Registry.ResidentOperations;

import Reservation.Resident;
import Registry.Registry;

public abstract class ResidentOperation {
    protected final Resident resident;
    protected final Registry registry;

    public ResidentOperation(Resident resident) {
        this.registry = Registry.getInstance();

        this.resident = resident;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected abstract void preOperation();

    protected abstract void doOperation();
}
