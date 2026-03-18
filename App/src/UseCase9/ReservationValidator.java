/**
 * CLASS ReservationValidator
 * Use Case 9: Error Handling & Validation
 * @version 9.0
 */
public class ReservationValidator {

    public void validate(String guestName, String roomType, RoomInventory inventory) throws InvalidBookingException {
        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room types (case-sensitive as per requirements)
        if (!roomType.equals("Single") && !roomType.equals("Double") && !roomType.equals("Suite")) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Check inventory to prevent negative values
        if (!inventory.hasAvailableRooms(roomType)) {
            throw new InvalidBookingException("No rooms available for the selected type.");
        }
    }
}