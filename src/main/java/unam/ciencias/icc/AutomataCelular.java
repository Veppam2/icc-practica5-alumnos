package unam.ciencias.icc;

import java.awt.Color;

/**
 * Interfaz que describe las caracteristicas mas importantes que deben de considerarse en un automata.
 * @author Manuel
 */
public interface AutomataCelular {

    /**
     * Obtiene el estado en el que se encuentra el automata. Este metodo tiene que ir ligado al metodo evoluciona()
     * ya que cada vez que esto sucude el automata se debe de encontrar en el siguiente estado que es el numero de evolucion.
     * @return Numero de veces que se ha llamado al metodo evoluciona.
     */
    public int getEvolucion();

    /**
     * Obtiene una representacion matricial de los valores que contiene este automata en un cierto estado de tiempo.
     * @return El estado actual de la matriz que representa el autómata
     */
    public int[][] getAutomata();

    /**
     * Obtiene los colores que representa los esatados del automata.
     * @return El arreglo de los colores que pueden tomar las casilla
     */
    public Color[] getColores();

    /**
     * Metodo que se invoca para que el automata evolucione. Esto nos da a entender de que si el automata se encontraba en 
     * un estado t, ahora tendra que estar en el estado t+1.
     */
    public void evoluciona();
}