package Registry.BookingOperations;

import Reservation.Booking;

import java.util.ArrayList;

public class AddBooking extends BookingOperation {
    public AddBooking(ArrayList<String> bookingData) {
        super(bookingData);
    }

    @Override
    protected void preOperation() {
        return;
    }

    @Override
    protected void doOperation() {
        Booking newBooking = new Booking(Integer.parseInt(bookingData.getFirst()),
                Integer.parseInt(bookingData.get(1)), bookingData.get(2));

        registry.addBooking(newBooking);
    }
}
