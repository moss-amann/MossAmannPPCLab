import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class threeUnitTest {
    @Test
    void firstTest() {
        int a = 1;
        assertTrue(a == 2);
    }

    @Test
    void secondTest() {
        int c = 10;
        assertFalse(c == 20);
    }

    @Test
    void thirdTest() {
        String cat = null;
        assertNull(cat);
    }
}
