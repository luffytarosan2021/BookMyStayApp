import java.util.*;

// Helper class to manage room counts
class RoomInventory {
    private Map<String, Integer> counts = new HashMap<>();

    public RoomInventory() {
        counts.put("Deluxe", 5);
        counts.put("Suite", 2);
    }

    public void incrementCount(String roomType) {
        counts.put(roomType, counts.getOrDefault(roomType, 0) + 1);
        System.out.println("Inventory Updated: " + roomType + " count is now " + counts.get(roomType));
    }
}

// The core service logic
class CancellationService {
    private Stack<String> releasedRoomIds = new Stack<>();
    private Map<String, String> reservationRoomTypeMap = new HashMap<>();

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
        System.out.println("System: Registered " + reservationId + " (" + roomType + ")");
    }

    public void cancelBooking(String reservationId, RoomInventory inventory) {
        // Requirement: Validate existence
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Validation Error: Reservation " + reservationId + " does not exist.");
            return;
        }

        // Requirement: Release ID and restore inventory
        String roomType = reservationRoomTypeMap.remove(reservationId);
        inventory.incrementCount(roomType);

        // Requirement: LIFO Rollback Tracking
        releasedRoomIds.push(reservationId);

        System.out.println("Action: Successfully cancelled " + reservationId);
    }

    public void showRollbackHistory() {
        System.out.println("\n--- LIFO Rollback History ---");
        if (releasedRoomIds.isEmpty()) {
            System.out.println("No history found.");
            return;
        }
        while (!releasedRoomIds.isEmpty()) {
            System.out.println("Rollback processed for: " + releasedRoomIds.pop());
        }
    }
}

// The Public Main Class (File must be named UseCase10BookingCancellation.java)
public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        CancellationService service = new CancellationService();
        RoomInventory inventory = new RoomInventory();

        System.out.println("--- Starting Use Case 10: Booking Cancellation ---\n");

        // Step 1: Simulate existing bookings
        service.registerBooking("RES-101", "Deluxe");
        service.registerBooking("RES-102", "Suite");

        // Step 2: Perform cancellations
        service.cancelBooking("RES-102", inventory);
        service.cancelBooking("RES-101", inventory);

        // Step 3: Test validation (Invalid ID)
        service.cancelBooking("RES-999", inventory);

        // Step 4: Show recovery order
        service.showRollbackHistory();

        System.out.println("\n--- Process Complete ---");
    }
}