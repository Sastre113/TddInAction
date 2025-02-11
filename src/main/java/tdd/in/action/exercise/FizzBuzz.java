package tdd.in.action.exercise;

/*
 * Escribe una función que espera recibir un número entero y devolverá una
 * cadena de texto como resultado dependiendo de:
 * - Si es múltiplo de 3 por la palabra "fizz".
 * - Si es múltiplo de 5 por la palabra "buzz".
 * - Si es múltiplo de 3 y de 5 a la vez por la palabra "fizzbuzz".
 *
 */
public class FizzBuzz {

    public String get(int number) {
        StringBuilder strBuilder = new StringBuilder("");
        if (number % 3 == 0) {
            strBuilder.append("fizz");
        }

        if (number % 5 == 0) {
            strBuilder.append("buzz");
        }

        return strBuilder.toString();
    }
}
