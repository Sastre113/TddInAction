package tdd.in.action.exercise.how_many_days;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HowManyDaysTest {

    private static HowManyDays howManyDays;

    @BeforeAll
    public static void setUp() {
        howManyDays = new HowManyDays();
    }

    @Order(1)
    @Test
    public void givenTwoDate_thenReturnNotNullValue() {
        // Arrange
        String date1 = "18/02/2024";
        String date2 = "01/03/2024";

        // Act
        Integer days = howManyDays.howManyDays(date1, date2);

        // Assert
        System.out.println("Número de días: " + days);
        Assertions.assertNotNull(days);
    }

    @Order(2)
    @Test
    public void givenWrongDate_thenThrowException() {
        // Arrange
        String date1 = "18/02/2024";
        String date2 = "01/13/2024";

        // Assert
        Assertions.assertThrowsExactly(HowManyDaysException.class
                ,() -> howManyDays.howManyDays(date1, date2));
    }

    @Order(3)
    @Test
    public void givenAnyDate_thenReturnNumbersOfDaysLikeInteger() {
        // Arrange
        String date1 = "18/02/2024";
        String date2 = "01/03/2024";

        // Act
        Integer days = howManyDays.howManyDays(date1, date2);

        // Assert
        Assertions.assertNotNull(days);
        Assertions.assertEquals(12, days);
    }

}