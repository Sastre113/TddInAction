package tdd.in.action.exercise;

import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

    private static FizzBuzz fizzBuzz;

    @BeforeAll
    public static void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5})
    @DisplayName("Test que comprueba el tipo de retorno")
    @Order(1)
    public void givenAnyNumber_whenFizzBuzzGet_thenReturnAnyString(int number){
        // Act
        String word = fizzBuzz.get(number);

        // Assert
        Assertions.assertNotNull(word);
        Assertions.assertInstanceOf(String.class, word);
    }

    @Test
    @DisplayName("Test que comprueba que no sea múltiplo 3 ni 5")
    @Order(2)
    public void givenAnyNumberNotMultiple3or5_whenFizzBuzzGet_thenReturnEmptyString() {
        // Arrange
        int number = 4;

        // Act
        String word = fizzBuzz.get(number);

        // Assert
        Assertions.assertNotNull(word);
        Assertions.assertEquals("", word);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 12})
    @DisplayName("Test que comprueba el resultado cuando es múltiplo de 3")
    @Order(3)
    public void givenNumberMultipleOf3_whenFizzBuzzGet_thenReturnFizz(int number) {
        // Act
        String word = fizzBuzz.get(number);
        // Assert
        Assertions.assertEquals("fizz", word);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20})
    @DisplayName("Test que comprueba el resultado cuando es múltiplo de 5")
    @Order(4)
    public void givenNumberMultipleOf5_whenFizzBuzzGet_thenReturnBuzz(int number) {
        // Act
        String word = fizzBuzz.get(number);
        // Assert
        Assertions.assertEquals("buzz", word);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45})
    @DisplayName("Test que comprueba el resultado cuando es múltiplo de 3 y 5")
    @Order(5)
    public void givenNumberMultipleOf3or5_whenFizzBuzzGet_thenReturnFizzBuzz(int number) {
        // Act
        String word = fizzBuzz.get(number);
        // Assert
        Assertions.assertEquals("fizzbuzz", word);
    }
}
