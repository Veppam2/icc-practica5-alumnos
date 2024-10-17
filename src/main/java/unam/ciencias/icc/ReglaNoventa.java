package unam.ciencias.icc;

import java.awt.Color;

public class ReglaNoventa extends Automata{

    protected static final int CASILLA_VIVA = 0;
    protected static final int CASILLA_MUERTA = 1;

    ReglaNoventa(){
        // TODO: Agrega tu solución
    }
    
    @Override
    protected void generaEstadoInicial() {
        // TODO: Agrega tu solución
    }

    @Override
    public void evoluciona() {
        // TODO: Agrega tu solución
    }

    protected int obtenerTransicionSobreCoordenada( int[][] mundo, int i, int renglon){
        // TODO: Agrega tu solución
        return 1337;
    }

    @Override
    protected int[][] obtenerCoordenadasDeVecinos( int[][] mundo, int i, int renglon){
        // TODO: Agrega tu solución
        return new int[1][1];
    }


    
}