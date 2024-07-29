import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RockParking {
    // Creating a HashMap that contains car plate number and time of entry (K, V pair) for all cars in RockParking
    private Map<String, Instant> cars = new HashMap<>();
    // Map to store the validity duration of parking tickets (in minutes)
    private Map<String, Integer> parkingTickets = new HashMap<>();

    // Action1: First action when car enters is to add its plate number and time of entry in cars HashMap
    public void enter(String plateNumber) {
        Instant timeOfEntry = Instant.now(); // Get the current time of entry
        cars.put(plateNumber, timeOfEntry); // Add plate number and time of entry to the cars map
        System.out.println("Car entered: " + plateNumber + " at " + timeOfEntry);
    }

    // Action2: Checking if car details (plate number and time of entry) have been entered into the hashmap
    public boolean isCarRecorded(String plateNumber) {
        return cars.containsKey(plateNumber); // Check if the car's plate number exists in the cars map
    }

    // Action3: New method to check if the car has entered
    public boolean hasCarEntered(String plateNumber) {
        return isCarRecorded(plateNumber);
    }

    // Method to add a parking ticket for a car
    public void addParkingTicket(String plateNumber, int validMinutes) {
        parkingTickets.put(plateNumber, validMinutes); // Store the validity duration of the ticket
    }

    // Method to issue a penalty
    private void issuePenalty(String plateNumber, String reason) {
        System.out.println("Penalty issued to car " + plateNumber + ": " + reason);
    }

    // Action5: New method to check when car leaves the lot and calculate duration of stay
    public void carDeparture(String plateNumber) {
        Instant endTime = Instant.now(); // Get the current time as the departure time
        Instant startTime = cars.get(plateNumber); // Retrieve the entry time

        if (startTime != null) {
            Duration durationOfStay = Duration.between(startTime, endTime); // Calculate the duration of stay
            long minutesStayed = durationOfStay.toMinutes(); // Convert the duration to minutes
            System.out.println("Car " + plateNumber + " stayed for " + minutesStayed + " minutes.");

            if (minutesStayed > 60) { // Check if the duration of stay is longer than an hour
                Integer validMinutes = parkingTickets.get(plateNumber); // Retrieve the ticket validity duration

                if (validMinutes == null) {
                    issuePenalty(plateNumber, "No valid parking ticket for stay over 60 minutes.");
                } else if (validMinutes < minutesStayed) {
                    issuePenalty(plateNumber, "Exceeded parking ticket validity.");
                } else {
                    System.out.println("Car " + plateNumber + " has a valid parking ticket.");
                }
            } else {
                System.out.println("Car " + plateNumber + " stayed for less than an hour. No ticket needed.");
            }

            cars.remove(plateNumber); // Remove the car from the map
            parkingTickets.remove(plateNumber); // Remove the ticket from the map
        } else {
            System.out.println("Car " + plateNumber + " was not found.");
        }
    }

    // Method to manually set the entry time for testing purposes
    void setCarEntryTime(String plateNumber, Instant entryTime) {
        cars.put(plateNumber, entryTime);
    }
}
