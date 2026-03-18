import java.util.HashMap;
import java.util.Map;

public class RoomInventory {
    private Map<String, Integer> inventoryCount = new HashMap<>();

    public void setInitialCount(String roomType, int count) {
        inventoryCount.put(roomType, count);
    }

    public int getAvailableCount(String roomType) {
        return inventoryCount.getOrDefault(roomType, 0);
    }

    public void decrementInventory(String roomType) {
        if (getAvailableCount(roomType) > 0) {
            inventoryCount.put(roomType, inventoryCount.get(roomType) - 1);
        }
    }
}