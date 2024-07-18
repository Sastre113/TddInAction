package tdd.in.action.exercise.how_many_days;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/*
 * Crea una función que calcule y retorne cuántos días hay entre dos cadenas
 * de texto que representen fechas.
 * - Una cadena de texto que representa una fecha tiene el formato "dd/MM/yyyy".
 * - La función recibirá dos String y retornará un Int.
 * - La diferencia en días será absoluta (no importa el orden de las fechas).
 * - Si una de las dos cadenas de texto no representa una fecha correcta se
 *   lanzará una excepción.
 */
public class HowManyDays {

    public Integer howManyDays(String strDate1, String strDate2) {
        long timeResultat = Math.abs(this.strToEpoch(strDate1) - this.strToEpoch(strDate2));

        return Math.toIntExact(timeResultat);
    }


    private long strToEpoch(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDateTime.parse(date, formatter)
                    .atZone(ZoneId.systemDefault())
                    .toEpochSecond();
        } catch(Exception e){
            // TODO Añadir excepción propia
            throw e;
        }
    }

}
