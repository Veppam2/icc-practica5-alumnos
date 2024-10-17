package unam.ciencias.icc;

import java.awt.Color;
import java.util.Random;

public abstract class Automata implements AutomataCelular{

    Automata(long semilla){
        // TODO: Agrega tu solución
    }
    Automata(){
        // TODO: Agrega tu solución
    }

    protected abstract void generaEstadoInicial();
    /*
     * OBS: 
     *           i  j
     *  automata[1][3] ->
     *  
     *          0 1                 |       |
     *        0|_|_|        i-1,j-1 | i,j-1 | i+1, j-1
     *        1|_|_|       _________ _______ _________
     *        2|_|_|          i-1,j |  i,j  |  i+1,j
     *        3|_|*|        ________ _______ __________
     *                      i-1,j+1 | i,j+1 | i+1, j+1
     *                              |       |
     */
    /**
     * Método que te regresa las coordenadas en un arreglo bidimensional de los vecinos de la casilla en la posición (i,j) dentro del mundo
     * @param mundo El mundo donde se van a buscar los vecinos
     * @param i La coordenada x 
     * @param j La coordenada y
     * @return Un arreglo bidimensional int[n][2] con las casillas contenidas donde n es el número de vecinos y 2 representa el par x,y que es la coordenada del vecino
     */
    protected abstract int[][] obtenerCoordenadasDeVecinos(int[][] mundo, int i, int j );

    /**
     * Dada una coordenada (i,j) dentro del mundo, regresa cuál sería el siguiente estado dadas las reglas de transiciones del autómata en cuestión dado el mundo que recibe.
     * @param mundo El mundo para tomar en cuenta en las transiciones
     * @param i La coordenada x de la casilla
     * @param j La coordenada y de lla casilla
     * @return El siguiente estado que le corresponde, o -1 si las reglas de transición no cubren el caso especificado (la casilla se queda igual).
     */
    protected abstract int obtenerTransicionSobreCoordenada( int[][] mundo, int i, int j);

    @Override
    public int getEvolucion() {
        // TODO: Agrega tu solución
        return 9999;
    }

    @Override
    public int[][] getAutomata() {
        // TODO: Agrega tu solución
        return new int[1][1];
    }

    @Override
    public Color[] getColores() {
        // TODO: Agrega tu solución
        return new Color[1];
    }

}