package Reports;

import Registry.Registry;
import Reservation.Booking;
import Utility.Utility;

import java.time.LocalDate;
import java.util.ArrayList;

public class YearlyReport implements Report {
    @Override
    public double generateReport() {
        double yearlyIncome = 0;
        LocalDate[] lastYear = Utility.getPreviousYear(LocalDate.now());
        ArrayList<Booking> bookings = Registry.getInstance().getBookings();

        for (Booking booking : bookings) {
            if (!booking.getDATE().isBefore(lastYear[0]) && !booking.getDATE().isAfter(lastYear[1])) {
                yearlyIncome += booking.calculateCost();
            }
        }

        return yearlyIncome;
    }
}
