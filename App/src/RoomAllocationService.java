import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
public class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;
    public RoomAllocationService() {
        // Initialize the Set and Map to prevent NullPointerExceptions
        this.allocatedRoomIds = new HashSet<>();
        this.assignedRoomsByType = new HashMap<>();
    }
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();
        if (inventory.getAvailableCount(roomType) > 0) {
            String roomId = generateRoomId(roomType);
            while (allocatedRoomIds.contains(roomId)) {
                roomId = generateRoomId(roomType);
            }
            allocatedRoomIds.add(roomId);
            assignedRoomsByType.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);
            inventory.decrementInventory(roomType);
            reservation.setAssignedRoomId(roomId);
            reservation.setConfirmed(true);
            System.out.println("SUCCESS: Room " + roomId + " allocated to " + reservation.getGuestName());
        } else {
            System.out.println("FAILED: No available rooms of type '" + roomType + "' for " + reservation.getGuestName());
        }
    }

    private String generateRoomId(String roomType) {
        // Creates an ID like "DELUXE-A1B2C3" using UUID
        String prefix = roomType.length() >= 3 ? roomType.substring(0, 3).toUpperCase() : roomType.toUpperCase();
        String uniqueSuffix = UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        return prefix + "-" + uniqueSuffix;
    }
}