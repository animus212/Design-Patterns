package Report;

import Registry.Registry;
import Reservation.Booking;
import Utility.Utility;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeeklyReport implements Report {
    @Override
    public double generateReport() {
        double weeklyIncome = 0;
        LocalDate[] lastWeek = Utility.getPreviousWeek(LocalDate.now());
        ArrayList<Booking> bookings = Registry.getInstance().getBookings();

        for (Booking booking : bookings) {
            if (!booking.getDate().isBefore(lastWeek[0]) && !booking.getDate().isAfter(lastWeek[1])) {
                weeklyIncome += booking.calculateCost();
            }
        }

        return weeklyIncome;
    }
}
