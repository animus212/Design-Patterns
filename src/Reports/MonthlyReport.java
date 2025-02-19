package Reports;

import Registry.Registry;
import Reservation.Booking;
import Utility.Utility;

import java.time.LocalDate;
import java.util.ArrayList;

public class MonthlyReport implements Report {
    @Override
    public double generateReport() {
        double monthlyIncome = 0;
        LocalDate[] lastMonth = Utility.getPreviousMonth(LocalDate.now());
        ArrayList<Booking> bookings = Registry.getInstance().getBookings();

        for (Booking booking : bookings) {
            if (!booking.getDATE().isBefore(lastMonth[0]) && !booking.getDATE().isAfter(lastMonth[1])) {
                monthlyIncome += booking.calculateCost();
            }
        }

        return monthlyIncome;
    }
}
