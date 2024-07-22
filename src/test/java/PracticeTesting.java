import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PracticeTesting {

    @Test
    void twoPlusTwoMustEqualFour () {
         Practice sumP = new Practice();
        assertEquals(4, sumP.add(2, 2));
    }

    @Test
    void threePlusEightMustEqualEleven () {
        Practice sumP = new Practice();
        assertEquals(11, sumP.add(3, 8));
    }

}
