abstract class Room {
    private int beds;
    private double size;
    private double price;

    // Constructor
    public Room(int beds, double size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    // Getters (Encapsulation)
    public int getBeds() {
        return beds;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Abstract method
    public abstract String getRoomType();

    // Method to display room details
    public void displayRoomDetails(int availability) {
        System.out.println("Room Type: " + getRoomType());
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price per night: $" + price);
        System.out.println("Available Rooms: " + availability);
        System.out.println("-----------------------------");
    }
}


// Single Room Class
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 200, 80);
    }

    public String getRoomType() {
        return "Single Room";
    }
}


// Double Room Class
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 350, 150);
    }

    public String getRoomType() {
        return "Double Room";
    }
}


// Suite Room Class
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 500, 300);
    }

    public String getRoomType() {
        return "Suite Room";
    }
}


// Main Application
public class BookMyStayApp {

    public static void main(String[] args) {

        // Static availability variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        // Creating room objects (Polymorphism)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Display details
        System.out.println("Welcome to Book My Stay");
        System.out.println("========================");

        single.displayRoomDetails(singleRoomAvailability);
        doubleRoom.displayRoomDetails(doubleRoomAvailability);
        suite.displayRoomDetails(suiteRoomAvailability);

        System.out.println("Thank you for using Book My Stay!");
    }
}