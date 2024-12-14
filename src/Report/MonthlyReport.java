package Report;

import Registry.*;
import Reservation.Booking;
import Utility.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonthlyReport implements Report {
    @Override
    public double generateReport() {
        double weeklyIncome = 0;
        LocalDate[] lastWeek = Utility.getPreviousMonth(LocalDate.now());
        ArrayList<Booking> bookings = Registry.getInstance().getBookings();

        for (Booking booking : bookings) {
            if (!booking.getDate().isBefore(lastWeek[0]) && !booking.getDate().isAfter(lastWeek[1])) {
                weeklyIncome += booking.calculateCost();
            }
        }

        return weeklyIncome;
    }
}
