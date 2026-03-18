import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class BookingHistory {
    private List<Reservation> history;

    public BookingHistory() {
        this.history = new ArrayList<>();
    }
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }
    public List<Reservation> getHistory() {
        return Collections.unmodifiableList(history);
    }
}