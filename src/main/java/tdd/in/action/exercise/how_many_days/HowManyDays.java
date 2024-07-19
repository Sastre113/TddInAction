package tdd.in.action.exercise.how_many_days;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
        long timeResultat = Math.abs(this.strDateToEpochDay(strDate1) - this.strDateToEpochDay(strDate2));
        return Math.toIntExact(timeResultat);
    }


    private long strDateToEpochDay(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(date, formatter).toEpochDay();
        } catch(Exception e){
            throw new HowManyDaysException("Formato de la fecha incorrecto");
        }
    }

}
