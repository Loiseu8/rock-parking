import java.util.HashMap;
import java.util.Map;
import java.time.LocalDateTime;

public class RockParking {
    // Creating a HashMap that contains car plate number and time of entry (K, V pair) for all cars in RockParking
    private Map<String, LocalDateTime> cars = new HashMap<>();

    // Action1: First action when car enters is to add its plate number and time of entry in cars HashMap
    public void enter(String plateNumber) {
        LocalDateTime timeOfEntry = LocalDateTime.now(); // Get the current time of entry

        cars.put(plateNumber, timeOfEntry); // Add plate number and time of entry to the cars map
        System.out.println("Car entered: " + plateNumber + " at " + timeOfEntry);
    }

    //Action2: Checking if car details (plate number and time of entry) have been entered into the hashmap
    public boolean isCarRecorded(String plateNumber) {
        return cars.containsKey(plateNumber); // Check if the car's plate number exists in the cars map
    }

    // New method to check if the car has entered
    public boolean hasCarEntered(String plateNumber) {
        return isCarRecorded(plateNumber);
    }
    public static void main(String[] args) {
        RockParking rockParking = new RockParking();

        // Methods for when cars enter
        rockParking.enter("AB23 XYZ");
        rockParking.enter("CD45 PQR");
        rockParking.enter("EF67 STU");

        // Checking if specific cars are recorded
        System.out.println("Is AB23 XYZ recorded? " + rockParking.isCarRecorded("AB23 XYZ"));
        System.out.println("Is CD45 PQR recorded? " + rockParking.isCarRecorded("CD45 PQR"));
        System.out.println("Is EF67 STU recorded? " + rockParking.isCarRecorded("EF67 STU"));


    }
}
