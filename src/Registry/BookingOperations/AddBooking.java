package Registry.BookingOperations;

import Reservation.Booking;

import java.util.ArrayList;

public class AddBooking extends BookingOperation {
    private int roomNumber;

    public AddBooking(ArrayList<String> bookingData) {
        super(bookingData);
    }

    @Override
    protected void preOperation() {
        String roomType = "";

        for (int i = 0; i < REGISTRY.getRooms().size(); i++) {
            roomType = REGISTRY.getRooms().get(i).getClass().getSimpleName();

            if (roomType.equals(BOOKING_DATA.getLast()) && REGISTRY.getRooms().get(i).isAvailable()) {
                roomNumber = i;

                return;
            }
        }

        throw new NullPointerException("There are no available rooms of this type!");
    }

    @Override
    protected void doOperation() {
        Booking newBooking = new Booking(roomNumber, Integer.parseInt(BOOKING_DATA.get(0)), BOOKING_DATA.get(1));

        REGISTRY.addBooking(newBooking);
    }
}
