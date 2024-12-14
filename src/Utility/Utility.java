package Utility;

import java.time.LocalDate;

public class Utility {
    public static LocalDate[] getPreviousWeek(LocalDate date) {
        final int dayOfWeek = date.getDayOfWeek().getValue();
        final LocalDate from = date.minusDays(dayOfWeek + 6); // (dayOfWeek - 1) + 7
        final LocalDate to = date.minusDays(dayOfWeek);

        return new LocalDate[]{from, to};
    }

    public static LocalDate[] getPreviousMonth(LocalDate date) {
        final LocalDate from = date.minusDays(date.getDayOfMonth() - 1).minusMonths(1);
        final LocalDate to = from.plusMonths(1).minusDays(1);

        return new LocalDate[]{from, to};
    }

    public static LocalDate[] getPreviousYear(LocalDate date) {
        LocalDate startDate = date.withDayOfYear(1).minusYears(1);
        LocalDate endDate = startDate.plusYears(1).minusDays(1);

        return new LocalDate[]{startDate, endDate};
    }
}
