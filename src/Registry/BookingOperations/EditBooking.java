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

        for (Booking storedBooking : registry.getBookings()) {
            if (storedBooking.getId() == Integer.parseInt(bookingData.getFirst())) {
                bookingIndex = index;

                if (storedBooking.getRoomNumber() != Integer.parseInt(bookingData.get(1)) &&
                        !registry.getRooms().get(Integer.parseInt(bookingData.get(1))).isAvailable()) {
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
        Booking booking = registry.getBookingCopy(bookingIndex);

        booking.setRoomNumber(Integer.parseInt(bookingData.get(1)));
        booking.setDurationOfStay(Integer.parseInt(bookingData.get(2)));
        booking.setBoardingType(bookingData.get(3));

        registry.editBooking(bookingIndex, booking);
    }
}
