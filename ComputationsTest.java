import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputationsTest {

    //Computations computation = new Computation;

    @Test
    void fibonacciThrows() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Computations.fibonacci(-1);
        });
        String expectedMessage = "n must be non-negative";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void fibonacciEdgeCase0() {
        assertEquals(0, Computations.fibonacci(0));
    }

    @Test
    void fibonacciEdgeCase1() {
        assertEquals(1, Computations.fibonacci(1));
    }

    @Test
    void isPrimeNegative() {
        assertFalse(Computations.isPrime(-5));
    }

    @Test
    void isPrime2() {
        assertTrue(Computations.isPrime(2));
    }

    @Test
    void isPrime3() {
        assertTrue(Computations.isPrime(3));
    }

    @Test
    void isEvenZeroTest() {
        assertTrue(Computations.isEven(0));
    }

    @Test
    void isEvenNegativeTest() {
        assertTrue(Computations.isEven(-2));
    }

    @Test
    void isEvenOddTest() {
        assertFalse(Computations.isEven(3));
    }

    @Test
    void isOddZero() {
        assertFalse(Computations.isOdd(0));
    }

    @Test
    void isOddNegative() {
        assertTrue(Computations.isOdd(-1));
    }

    @Test
    void isOddLarge() {
        assertTrue(Computations.isOdd(255));
    }

    @Test
    void toCelsiusFreezing() {
        assertEquals(0.0, Computations.toCelsius(32.0));
    }

    @Test
    void toCelsiusAbsoluteZero() {
        assertEquals(-273.15, Computations.toCelsius(-459.67));
    }

    @Test
    void toFahrenheitBoiling() {
        assertEquals(212, Computations.toFahrenheit(100));
    }
}