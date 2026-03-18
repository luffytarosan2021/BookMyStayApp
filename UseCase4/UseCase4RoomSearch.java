import java.util.HashMap;
class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("SingleRoom", 5);
        inventory.put("DoubleRoom", 3);
        inventory.put("SuiteRoom", 0); // Example: unavailable room
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

// Abstract Room class (domain model)
abstract class Room {

    private double price;
    private int beds;

    public Room(double price, int beds) {
        this.price = price;
        this.beds = beds;
    }

    public double getPrice() {
        return price;
    }

    public int getBeds() {
        return beds;
    }

    public abstract String getRoomType();
}

// Room types
class SingleRoom extends Room {

    public SingleRoom() {
        super(80, 1);
    }

    public String getRoomType() {
        return "SingleRoom";
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(150, 2);
    }

    public String getRoomType() {
        return "DoubleRoom";
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(300, 3);
    }

    public String getRoomType() {
        return "SuiteRoom";
    }
}

// Search service (read-only logic)
class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchRooms(Room[] rooms) {

        System.out.println("Available Rooms:");
        System.out.println("----------------------");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.getRoomType());

            // show only available rooms
            if (available > 0) {
                System.out.println("Room Type: " + room.getRoomType());
                System.out.println("Price: $" + room.getPrice());
                System.out.println("Beds: " + room.getBeds());
                System.out.println("Available: " + available);
                System.out.println("----------------------");
            }
        }
    }
}

// Main class
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        Room[] rooms = {single, doubleRoom, suite};

        SearchService search = new SearchService(inventory);

        // Guest searches rooms
        search.searchRooms(rooms);
    }
}