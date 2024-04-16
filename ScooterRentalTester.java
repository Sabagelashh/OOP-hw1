package homeworks.hw1.scooter;

/**
 * A tester class to demonstrate scooter rental and usage.
 */
public class ScooterRentalTester {

    public static void main(String[] args) {
        // Create a rental company
        RentalCompany rentalCompany = new RentalCompany();

        // Create a scooter and add it to the rental company
        Scooter scooter = new Scooter();
        scooter.setModel("Sparrow X10");
        scooter.setBatteryLevel(100);
        scooter.setAvailable(true);
        rentalCompany.addScooter(scooter);

        // Rent the scooter and go from home to the University
        rentalCompany.rentScooter(scooter.getId());
        System.out.println("Rented scooter to go to the University.");

        // Coordinates for the University
        double universityX = 41.7121106;
        double universityY = 44.7489232;

        // Leave the scooter at the University
        rentalCompany.returnScooter(scooter.getId(), universityX, universityY);
        System.out.println("Scooter left at the University.");

        // Wait for 1 hour (simulated)

        // Rent the scooter again
        rentalCompany.rentScooter(scooter.getId());
        System.out.println("Rented scooter again.");

        // Go back home
        // Coordinates for home (hypothetical)
        double homeX = /* Your home's X coordinate */;
        double homeY = /* Your home's Y coordinate */;

        // Leave the scooter near home
        rentalCompany.returnScooter(scooter.getId(), homeX, homeY);
        System.out.println("Scooter left near home.");
    }
}
