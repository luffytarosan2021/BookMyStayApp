public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {
        AddOnServiceManager manager = new AddOnServiceManager();
        Service spa = new Service("Spa", 1000.0);
        Service breakfast = new Service("Breakfast", 500.0);
        String reservationId = "Single-1";
        manager.addService(reservationId, spa);
        manager.addService(reservationId, breakfast);
        double totalCost = manager.calculateTotalServiceCost(reservationId);
        System.out.println("Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + totalCost);
    }
}