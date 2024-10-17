package unam.ciencias.icc;

import java.awt.Color;

public class GosperGun extends Automata{
    
    protected static final int CASILLA_VIVA = 0;
    protected static final int CASILLA_MUERTA = 1;


    GosperGun(){
        // TODO: Agrega tu solución
    }


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
    @Override
    protected void generaEstadoInicial(){
        
        // TODO: Agrega tu solución

        this.generaPrimerCuadro();
        this.generaNave();
        this.generaPistola();
        this.generaSegundoCuadro();

    }

    private void generaPrimerCuadro(){
        // TODO: Agrega tu solución
    }

    private void generaNave(){
        // TODO: Agrega tu solución
    }

    private void generaPistola(){
        // TODO: Agrega tu solución

    }

    private void generaSegundoCuadro(){
        // TODO: Agrega tu solución
    }

    @Override
    public void evoluciona() {
        // TODO: Agrega tu solución
    }

    protected int obtenerTransicionSobreCoordenada( int[][] mundo, int i, int j){
        // TODO: Agrega tu solución
        return 666;
    }

    private int cantidadDeVecinosVivos( int[][] mundo, int i, int j){

        // TODO: Agrega tu solución
        return 666;
    }

    @Override
    protected int[][] obtenerCoordenadasDeVecinos(int[][] mundo, int i, int j) {
        // TODO: Agrega tu solución
        return new int[1][1];
    }

}