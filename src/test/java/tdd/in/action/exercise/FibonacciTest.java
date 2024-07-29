package tdd.in.action.exercise;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FibonacciTest {

    private static Fibonacci fibonacci;

    @BeforeAll
    public static void setUp() {
        fibonacci = new Fibonacci();
    }


    @ParameterizedTest
    @Order(1)
    @ValueSource(ints = {1, 2, 3, 5})
    @DisplayName("Test que comprueba el tipo de retorno")
    void givenAnyNumber_thenNotEmptyList(int number){
        // Act
        List<Integer> sucessionList = fibonacci.generar(number);

        // Assert
        Assertions.assertNotNull(sucessionList);
        Assertions.assertInstanceOf(List.class, sucessionList);
        Assertions.assertEquals(number, sucessionList.size());
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(ints = {1, 2, 3, 5})
    @DisplayName("Test que comprueba el tipo de retorno")
    void givenAnyNumber_thenListSizeEqualsNumber(int number){
        // Act
        List<Integer> sucessionList = fibonacci.generar(number);

        // Assert
        Assertions.assertEquals(number, sucessionList.size());
    }

    @Test
    @Order(3)
    @DisplayName("Test que comprueba los 10 primeros dígitos son correcto")
    void givenFirstTenNumbers_thenExpectedListIsSameAsGenerated(){
        // Arrange
        List<Integer> expectedFibonacciList = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34);
        int number = expectedFibonacciList.size();

        // Act
        List<Integer> sucessionList = fibonacci.generar(number);

        // Assert
        Assertions.assertEquals(expectedFibonacciList.size(), sucessionList.size());

        for(int i = 0; i < number; i++){
            Assertions.assertEquals(expectedFibonacciList.get(i), sucessionList.get(i));
        }
    }

}