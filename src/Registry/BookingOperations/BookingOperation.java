package Registry.BookingOperations;

import Registry.Registry;

import java.util.ArrayList;

public abstract class BookingOperation {
    protected final ArrayList<String> bookingData;
    protected final Registry registry;

    public BookingOperation(ArrayList<String> bookingData) {
        this.registry = Registry.getInstance();

        this.bookingData = bookingData;
    }

    public final void execute() {
        preOperation();
        doOperation();
    }

    protected abstract void preOperation();

    protected abstract void doOperation();
}
