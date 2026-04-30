import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayTest {
    @Test
    void testValuesLessThan20 () {
        int [] testArray = {20, 50, 150, 23};
        for(int value : testArray) {
            assertTrue(value >= 20);
        }
    }
}
