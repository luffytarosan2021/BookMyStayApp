import java.io.*;
import java.util.*;

// ================== MAIN CLASS ==================
public class UseCase12PersistenceSimulation {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        PersistenceService service = new PersistenceService();

        RoomInventory inventory = service.loadInventory();

        if (inventory == null) {
            System.out.println("No valid inventory data found. Starting fresh.\n");
            inventory = new RoomInventory();
        } else {
            System.out.println("Inventory restored successfully.\n");
        }

        inventory.printInventory();

        service.saveInventory(inventory);
        System.out.println("\nInventory saved successfully.");
    }
}

// ================== ROOM INVENTORY ==================
class RoomInventory implements Serializable {

    private Map<String, Integer> rooms = new HashMap<>();

    public RoomInventory() {
        rooms.put("Single", 5);
        rooms.put("Double", 3);
        rooms.put("Suite", 2);
    }

    public void printInventory() {
        System.out.println("Current Inventory:");
        System.out.println("Single: " + rooms.get("Single"));
        System.out.println("Double: " + rooms.get("Double"));
        System.out.println("Suite: " + rooms.get("Suite"));
    }
}

// ================== PERSISTENCE SERVICE ==================
class PersistenceService {

    private static final String FILE_NAME = "inventory.dat";

    // 🔁 Load inventory
    public RoomInventory loadInventory() {
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (RoomInventory) ois.readObject();

        } catch (Exception e) {
            return null; // important for "Starting fresh"
        }
    }

    // 💾 Save inventory
    public void saveInventory(RoomInventory inventory) {
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);

        } catch (IOException e) {
            System.out.println("Error saving inventory.");
        }
    }
}