package Registry.BookingOperations;

import Registry.Registry;

import java.util.ArrayList;

public abstract class BookingOperation {
    protected final ArrayList<String> BOOKING_DATA;
    protected final Registry REGISTRY;

    public BookingOperation(ArrayList<String> BOOKING_DATA) {
        this.REGISTRY = Registry.getInstance();

        this.BOOKING_DATA = BOOKING_DATA;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected abstract void preOperation();

    protected abstract void doOperation();
}
