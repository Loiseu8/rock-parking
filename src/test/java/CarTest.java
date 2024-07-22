import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
}
