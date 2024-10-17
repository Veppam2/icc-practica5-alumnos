package unam.ciencias.icc;

import java.awt.Color;
import java.util.Random;

public class BosqueEnLLamas extends Automata{

    protected double probaP;
    protected double probaF;

    protected static final int ARBOL_VACIO = 0;
    protected static final int ARBOL_NORMAL = 1;
    protected static final int ARBOL_ARDIENDO = 2;
    
    public BosqueEnLLamas( long semilla ){
        // TODO: Agrega tu solución
    }

    public BosqueEnLLamas( ){
        // TODO: Agrega tu solución
    }

    protected void generaEstadoInicial(){
        // TODO: Agrega tu solución
    }

    @Override
    public void evoluciona() {
        // TODO: Agrega tu solución
    }

    protected int obtenerTransicionSobreCoordenada( int[][] mundo, int i, int j){
        // TODO: Agrega tu solución

        return 1733;
    }
    /**
     *  Método para generar un número aleatorio al azar entre el 0.0 y 1.0 y verificar si entra dentro de la probabilidad P dada.
     * @return true si entra en la probabilidad, false en otro caso
     */
    protected boolean satisfaceProbabilidadP(){
        //Tip: usar el objeto Random de Java 
        //Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
        return true;
    }

    /**
     *  Método para generar un número aleatorio al azar entre el 0.0 y 1.0 y verificar si entra dentro de la probabilidad F dada.
     * @return true si entra en la probabilidad, false en otro caso
     */
    protected boolean satisfaceProbabilidadF(){
        //Tip: usar el objeto Random de Java 
        //Returns the next pseudorandom, uniformly distributed double value between 0.0 and 1.0 from this random number generator's sequence.
        return true;
    }

    protected boolean hayArbolArdiendoAlrededor(int[][] mundo, int i, int j){
        return false;
    }

    @Override
    protected int[][] obtenerCoordenadasDeVecinos(int[][] mundo, int i, int j) {
        return new int[1][1];

    }

}