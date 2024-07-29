import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.Instant;

public class CarTest {
    private RockParking rockParking;

    @BeforeEach
    void setUp() {
        rockParking = new RockParking();
    }

    @Test
    void testEnter() {
        // Test initial state (no cars recorded)
        assertFalse(rockParking.hasCarEntered("AB23 XYZ"));
        assertFalse(rockParking.hasCarEntered("CD45 PQR"));
        assertFalse(rockParking.hasCarEntered("EF67 STU"));

        // After cars have entered:
        rockParking.enter("AB23 XYZ");
        rockParking.enter("CD45 PQR");
        rockParking.enter("EF67 STU");

        // Test that the cars have been recorded after entering
        assertTrue(rockParking.hasCarEntered("AB23 XYZ"));
        assertTrue(rockParking.hasCarEntered("CD45 PQR"));
        assertTrue(rockParking.hasCarEntered("EF67 STU"));
    }

    @Test
    void testIsCarRecorded() {
        // Simulate car entries
        rockParking.enter("AB23 XYZ");
        rockParking.enter("CD45 PQR");
        rockParking.enter("EF67 STU");

        // Test that the cars have been recorded
        assertTrue(rockParking.isCarRecorded("AB23 XYZ"));
        assertTrue(rockParking.isCarRecorded("CD45 PQR"));
        assertTrue(rockParking.isCarRecorded("EF67 STU"));

        // Test for a car that has not been entered
        assertFalse(rockParking.isCarRecorded("GH89 VWX"));
    }

    @Test
    void testAddParkingTicket() {
        // Simulate car entry and adding a parking ticket
        rockParking.enter("AB23 XYZ");
        rockParking.addParkingTicket("AB23 XYZ", 120); // 2-hour ticket

        // Verify that the ticket has been added (indirectly by checking carDeparture)
        rockParking.carDeparture("AB23 XYZ"); // Should print that the car has a valid parking ticket
    }

    @Test
    void testCarDepartureWithoutTicket() {
        // Simulate car entry
        rockParking.enter("CD45 PQR");

        // Simulate time passing for more than 60 minutes
        Instant enterTime = Instant.now().minus(Duration.ofMinutes(61));
        rockParking.setCarEntryTime("CD45 PQR", enterTime); // Manually set the entry time

        // Capture output for penalty check
        rockParking.carDeparture("CD45 PQR"); // Should issue a penalty for no valid parking ticket
    }

    @Test
    void testCarDepartureWithExpiredTicket() {
        // Simulate car entry and adding a parking ticket
        rockParking.enter("EF67 STU");
        rockParking.addParkingTicket("EF67 STU", 30); // 30-minute ticket

        // Simulate time passing for more than 30 minutes
        Instant enterTime = Instant.now().minus(Duration.ofMinutes(31));
        rockParking.setCarEntryTime("EF67 STU", enterTime); // Manually set the entry time

        // Capture output for penalty check
        rockParking.carDeparture("EF67 STU"); // Should issue a penalty for exceeded parking ticket validity
    }
}
