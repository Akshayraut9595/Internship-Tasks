import java.util.*;

public class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<Passenger>();
    private Deque<Passenger> waitingList = new ArrayDeque<Passenger>();

    // Booking a flight
    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if (confirmedList.size() < CONFIRMEDLIST_LIMIT) {
            confirmedList.add(passenger);  // Add to confirmed list
            return true;
        } else if (waitingList.size() < WAITINGLIST_LIMIT) {
            waitingList.offer(passenger);  // Add to waiting list
            return true;
        } else {
            return false; // Both lists are full, booking failed
        }
    }

    // Cancel a reservation
    public boolean cancel(String confirmationNumber) {
        if (removePassenger(confirmedList.iterator(), confirmationNumber)) {
            // If the passenger was in the confirmed list, move the first from the waiting list
            if (!waitingList.isEmpty()) {
                confirmedList.add(waitingList.poll());
            }
            return true;
        }
        return removePassenger(waitingList.iterator(), confirmationNumber);
    }

    // Remove passenger using Iterator
    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            if (iterator.next().getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
