import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AddOnServiceManager {
    private Map<String, List<Service>> servicesByReservation;

    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }
    public void addService(String reservationId, Service service) {
        // If the reservation doesn't exist in the map yet, create a new list for it, then add the service
        servicesByReservation.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }
    public double calculateTotalServiceCost(String reservationId) {
        List<Service> services = servicesByReservation.getOrDefault(reservationId, new ArrayList<>());
        double totalCost = 0.0;

        for (Service service : services) {
            totalCost += service.getPrice();
        }

        return totalCost;
    }
}