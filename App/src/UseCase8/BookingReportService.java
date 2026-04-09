import java.util.List;

public class BookingReportService {

    public void generateSummaryReport(BookingHistory bookingHistory) {
        List<Reservation> history = bookingHistory.getHistory();

        System.out.println("======================================");
        System.out.println("      OPERATIONAL BOOKING REPORT      ");
        System.out.println("======================================");
        System.out.println("Total Confirmed Bookings: " + history.size());
        System.out.println("--------------------------------------");

        if (history.isEmpty()) {
            System.out.println("No booking history available.");
        } else {
            for (Reservation res : history) {
                // The List inherently preserves the chronological insertion order
                System.out.println(res.toString());
            }
        }
        System.out.println("======================================");
    }
}