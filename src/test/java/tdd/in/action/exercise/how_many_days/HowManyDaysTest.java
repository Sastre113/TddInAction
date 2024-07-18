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
    public void givenAnyDate_thenReturnNotNullValue() {
        // Arrange
        String date1 = "18/02/1993";
        String date2 = "01/03/1993";

        // Act
        Integer days = howManyDays.howManyDays(date1, date2);

        // Assert
        Assertions.assertNotNull(days);
    }

    @Order(2)
    @Test
    public void givenWrongDate_thenThrowException() {

    }

}