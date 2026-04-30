import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {
    @Test
    void sameCharacters(){
        String strOne = "Butterfly";
        String strTwo = "Butterfly";
        assertTrue(strOne.equals(strTwo));
    }

}
