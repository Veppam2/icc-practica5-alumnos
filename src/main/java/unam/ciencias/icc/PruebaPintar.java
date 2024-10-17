package unam.ciencias.icc;

import java.awt.Color;

public class PruebaPintar implements AutomataCelular {

    @Override
    public int getEvolucion() {
        return 0;
    }

    @Override
    public int[][] getAutomata() {
        int[][] aux = new int[Imagen.numCells][Imagen.numCells];
        aux[0][0] = 1;
        return aux;
    }

    @Override
    public Color[] getColores() {
        Color[] c = new Color[]{Color.ORANGE, Color.BLUE};
        return c;
    }

    @Override
    public void evoluciona() {
    }
}
