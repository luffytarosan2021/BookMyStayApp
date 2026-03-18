import java.util.HashMap;
import java.util.Map;
public class Reservation {
    private String guestName;
    private String roomType;
    private String assignedRoomId;
    private boolean isConfirmed;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.isConfirmed = false;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public void setAssignedRoomId(String id) { this.assignedRoomId = id; }
    public void setConfirmed(boolean status) { this.isConfirmed = status; }
}