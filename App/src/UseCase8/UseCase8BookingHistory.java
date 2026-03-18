public class UseCase8BookingHistory {

    public static void main(String[] args) {
        // 1. Initialize History Storage and Reporting Service
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // 2. Simulate confirming several bookings over time
        System.out.println("System: Processing new reservations...");

        Reservation res1 = new Reservation("Alice Smith", "Single", "SIN-101");
        history.addReservation(res1);

        Reservation res2 = new Reservation("Bob Jones", "Double", "DBL-201");
        history.addReservation(res2);

        Reservation res3 = new Reservation("Charlie Brown", "Suite", "SUI-301");
        history.addReservation(res3);

        System.out.println("System: Reservations confirmed and archived.\n");

        // 3. Admin requests a report
        System.out.println("Admin: Generating End-of-Day Report...\n");
        reportService.generateSummaryReport(history);
    }
}