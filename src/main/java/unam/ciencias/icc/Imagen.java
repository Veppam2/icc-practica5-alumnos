package unam.ciencias.icc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Clase que representa una imagen en donde se va a pintar el automata celular. 
 * @author Manuel
 */
public class Imagen extends JPanel {

    /**
     * Tamanio de la celda para cada celula. 
     */
    public static final int sizeCell = 20;
    /**
     * Numero de celdas que contendra la malla. Este valor se aplica tanto para altura como para anchura.
     * Es decir la malla tendra numCellsxnumCell numero de celdas.
     */
    public static final int numCells = 40;
    /**
     * Tamanio real que debe de tener la malla considerando una linea divisoria entre las celdas, y el taminio de cada una. 
     * 
     * OBS] el tamaño extra (numCells + 1 ) tiene que ver con el grueso de las líneas de la rejilla y que no se amontonen con los cuadros de las celdas
     */
    private static final int tam = numCells * sizeCell + numCells + 1;
    /**
     * Objeto en donde se va a pintar.
     */
    private BufferedImage imagen;

    /**
     * Constructor de la clase.
     */
    public Imagen() {
        setSize(tam, tam);
        imagen = new BufferedImage(tam, tam, BufferedImage.TYPE_INT_RGB);
        createGrid();
    }

    /**
     * Metodo que dibuja las lineas en la imagen en color gris, para dar la apariencia de que es un entramado.
     */
    private void createGrid() {
        Graphics2D gc = imagen.createGraphics();
        // TODO: Agrega tu solución
    }

    /**
     * Metodo que mapea la matriz del automata a su representacion grafica. Este metodo considera
     * el tamanio de cada celda para poderla pintar. Se le pasa como parametro un arreglo de colores, 
     * para que cada vez que vea un valor en la matriz este lo busque en el arreglo de colores y pinte la celda de ese color.
     * Es necesario que la longitud del arreglo sea igual al maximo de los valores que se encuentran en la matriz.
     * @param matriz Representa la malla del automata con sus posibles estados. 
     * @param colores Se mapean a cada estado de la matriz para pintarlo de su respectivo color.
     */
    public void pinta(int[][] matriz, Color[] colores) {
	    Graphics2D gc = imagen.createGraphics();
        // TODO: Agrega tu solución
        
        updateUI();
    }

    @Override
    public void paint(Graphics g) {
        try{
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(imagen, null, 0, 0);
        }catch(NullPointerException e){}
    }
}
