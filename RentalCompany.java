package homeworks.hw1.scooter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a rental company that manages scooters.
 */
public class RentalCompany {

    private int uid = 0;

    List<Scooter> scooters = new ArrayList<>();

    /**
     * Retrieves a list of available scooters.
     * @return A list of available scooters.
     */
    public List<Scooter> availableScooters() {
        List<Scooter> result = new ArrayList<>();
        for (Scooter scooter: scooters) {
            if (scooter.isAvailable()) {
                result.add(scooter);
            }
        }
        return result;
    }

    /**
     * Adds a new scooter to the rental company.
     * @param scooter The scooter to add.
     */
    public void addScooter(Scooter scooter) {
        scooter.setId(uid++);
        scooters.add(scooter);
    }

    /**
     * Removes a scooter from the rental company by its ID.
     * @param id The ID of the scooter to remove.
     * @return True if the scooter was successfully removed, false otherwise.
     */
    public boolean removeScooter(int id) {
        boolean removed = false;
        for (Scooter scooter: scooters) {
            if (scooter.getId() == id) {
                scooters.remove(scooter);
                removed = true;
                break;
            }
        }
        return removed;
    }

    /**
     * Rents a scooter with the specified ID.
     * @param id The ID of the scooter to rent.
     */
    public void rentScooter(int id) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && scooter.isAvailable()) {
                scooter.setAvailable(false);
                System.out.println("Scooter with ID " + id + " has been rented.");
                return;
            }
        }
        System.out.println("Scooter with ID " + id + " is not available for rent.");
    }

    /**
     * Returns a rented scooter to the rental company and updates its location.
     * @param id The ID of the scooter to return.
     * @param x The new x-coordinate of the scooter.
     * @param y The new y-coordinate of the scooter.
     */
    public void returnScooter(int id, double x, double y) {
        for (Scooter scooter : scooters) {
            if (scooter.getId() == id && !scooter.isAvailable()) {
                scooter.setAvailable(true);
                scooter.setX(x);
                scooter.setY(y);
                System.out.println("Scooter with ID " + id + " has been returned.");
                return;
            }
        }
        System.out.println("Scooter with ID " + id + " cannot be returned.");
    }

    /**
     * Displays information about all the scooters in the rental company.
     */
    public void displayAllScooters() {
        System.out.println("List of all scooters:");
        for (Scooter scooter : scooters) {
            System.out.println(scooter);
        }
    }
}
