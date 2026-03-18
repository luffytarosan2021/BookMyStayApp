import java.util.LinkedList;
import java.util.Queue;

public class UseCase6RoomAllocation {
    public static void main(String[] args) {
        System.out.println("--- Starting Hotel Booking Management System ---");

        RoomInventory inventory = new RoomInventory();
        inventory.setInitialCount("Single", 2);
        inventory.setInitialCount("Double", 1);

        RoomAllocationService allocationService = new RoomAllocationService();

        Queue<Reservation> requestQueue = new LinkedList<>();
        requestQueue.offer(new Reservation("Diya Shrestha", "Single"));
        requestQueue.offer(new Reservation("Ram Bahadur", "Double"));
        requestQueue.offer(new Reservation("Krishna Kumar", "Single"));
        requestQueue.offer(new Reservation("Hari Das", "Single"));

        System.out.println("\n--- Processing Booking Queue (FIFO) ---");

        while (!requestQueue.isEmpty()) {
            Reservation currentRequest = requestQueue.poll();
            System.out.println("Processing request for: " + currentRequest.getGuestName() + " (" + currentRequest.getRoomType() + ")");

            allocationService.allocateRoom(currentRequest, inventory);
        }

        System.out.println("\n--- Final Inventory State ---");
        System.out.println("Single Rooms Available: " + inventory.getAvailableCount("Single"));
        System.out.println("Double Rooms Available: " + inventory.getAvailableCount("Double"));
    }
}