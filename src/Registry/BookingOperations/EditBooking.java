package Registry.BookingOperations;

import Reservation.Booking;

import java.util.ArrayList;

public class EditBooking extends BookingOperation {
    private int bookingIndex;

    public EditBooking(ArrayList<String> bookingData) {
        super(bookingData);
    }

    @Override
    protected void preOperation() {
        int index = 0;

        for (Booking storedBooking : REGISTRY.getBookings()) {
            if (storedBooking.getId() == Integer.parseInt(BOOKING_DATA.getFirst())) {
                bookingIndex = index;

                if (storedBooking.getRoomNumber() != Integer.parseInt(BOOKING_DATA.get(1)) &&
                        !REGISTRY.getRooms().get(Integer.parseInt(BOOKING_DATA.get(1))).isAvailable()) {
                    throw new IllegalArgumentException("Room is not available!");
                }

                return;
            }

            index += 1;
        }

        throw new IllegalArgumentException("Booking Does Not Exist!");
    }

    @Override
    protected void doOperation() {
        Booking booking = REGISTRY.getBookingCopy(bookingIndex);

        booking.setRoomNumber(Integer.parseInt(BOOKING_DATA.get(1)));
        booking.setDurationOfStay(Integer.parseInt(BOOKING_DATA.get(2)));
        booking.setBoardingType(BOOKING_DATA.get(3));

        REGISTRY.editBooking(bookingIndex, booking);
    }
}
