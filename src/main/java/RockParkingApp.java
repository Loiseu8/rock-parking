public class RockParkingApp {
    public static void main(String[] args) {
        RockParking rockParking = new RockParking();

        // Methods for when cars enter
        rockParking.enter("AB23 XYZ");
        rockParking.enter("CD45 PQR");
        rockParking.enter("EF67 STU");

        // Adding parking tickets
        rockParking.addParkingTicket("AB23 XYZ", 120); // 2-hour ticket for AB23 XYZ
        rockParking.addParkingTicket("CD45 PQR", 30);  // 30-minute ticket for CD45 PQR

        // Simulate some time passing (e.g., wait, sleep, or perform other operations)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Checking if specific cars are recorded
        System.out.println("Is AB23 XYZ recorded? " + rockParking.isCarRecorded("AB23 XYZ"));
        System.out.println("Is CD45 PQR recorded? " + rockParking.isCarRecorded("CD45 PQR"));
        System.out.println("Is EF67 STU recorded? " + rockParking.isCarRecorded("EF67 STU"));

        // Simulate more time passing for penalty demonstration
        try {
            Thread.sleep(60000); // Sleep for 1 minute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Methods for when cars depart
        rockParking.carDeparture("AB23 XYZ");
        rockParking.carDeparture("CD45 PQR");
        rockParking.carDeparture("EF67 STU");
    }
}
