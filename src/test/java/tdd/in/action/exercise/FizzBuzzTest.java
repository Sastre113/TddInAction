package tdd.in.action.exercise;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {

    private static FizzBuzz fizzBuzz;

    @BeforeAll
    public static void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    @DisplayName("Test que comprueba el tipo de retorno")
    public void method_fizzBuzz_must_return_something(){
        // Arrange
        int number = 1;

        // Act
        String word = fizzBuzz.get(number);

        // Assert
        Assertions.assertNotNull(word);
        Assertions.assertInstanceOf(String.class, word);
    }

    @Test
    @DisplayName("Test que comprueba que no sea múltiplo 3 ni 5")
    public void fizzBuzzGet_not_multiple_3_or_5() {
        // Arrange
        int number = 4;

        // Act
        String word = fizzBuzz.get(number);

        // Assert
        Assertions.assertNotNull(word);
        Assertions.assertEquals("", word);
    }

}
