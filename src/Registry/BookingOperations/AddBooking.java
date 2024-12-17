package Registry.BookingOperations;

import Reservation.Booking;

import java.util.ArrayList;

public class AddBooking extends BookingOperation {
    int roomNumber;

    public AddBooking(ArrayList<String> bookingData) {
        super(bookingData);
    }

    @Override
    protected void preOperation() {
        String roomType = "";

        for (int i = 0; i < registry.getRooms().size(); i++) {
            roomType = registry.getRooms().get(i).getClass().getSimpleName();

            if (roomType.equals(bookingData.getLast()) && registry.getRooms().get(i).isAvailable()) {
                roomNumber = i;

                return;
            }
        }

        throw new NullPointerException("There are no available rooms of this type!");
    }

    @Override
    protected void doOperation() {
        Booking newBooking = new Booking(roomNumber, Integer.parseInt(bookingData.get(0)), bookingData.get(1));

        registry.addBooking(newBooking);
    }
}
