package tdd.in.action.exercise;

import java.util.ArrayList;
import java.util.List;

/*
 * Escribe un programa que retorne N números de la sucesión
 * de Fibonacci empezando en 0, pasándolo como parámetro.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */
public class Fibonacci {

    public List<Integer> generar(int cant) {
        List<Integer> sucessionList = new ArrayList<>();

        for(int i = 0; i < cant; i++) {
            if(i < 2){
                sucessionList.add(i);
            } else {
                sucessionList.add(sucessionList.get(i-1) + sucessionList.get(i-2));
            }
        }

        return sucessionList;
    }

}
