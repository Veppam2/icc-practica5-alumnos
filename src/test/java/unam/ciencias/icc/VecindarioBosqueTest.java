package unam.ciencias.icc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@EnabledIf("testSuiteEnabled")
public class VecindarioBosqueTest {

  private BosqueEnLLamas automata= new BosqueEnLLamas(100);
  private int[][] mundo  = new int[4][4];
  

  static boolean testSuiteEnabled() {
    return PropertiesLoader.getBooleanProperty("display.image.enabled");
  }

  private boolean mismasCoordenadas(int[][] reales, int[][] calculadas){

    assertThat(reales.length, is(equalTo(calculadas.length)));


    for( int r = 0; r < reales.length; r++){
      //Obtengo una coordenada real 
      int xr = reales[r][0];
      int yr = reales[r][1];
      //La busco en las coordenadas calculadas
      boolean encontrada = false;
      for(int c = 0; c < calculadas.length; c++){
        int xc = calculadas[c][0];
        int yc = calculadas[c][1];

        if(xr  == xc && yr == yc){
          encontrada = true;
          break;  
        }
      }
      //Si no la econtré, es que me falta alguna real
      if( ! encontrada )
        return false;
    }
    //Si logro encontrar todas las coordenadas reales, es que son las mismas coordenadas
    return true;

  }

  @Test
  public void testToroEsquinaSuperiorIzquierda() {

    int x = 0;
    int y = 0;

    int[][] vecinosReales = new int[][]{
      {3,3}, {0,3}, {1,3}, {3,0},{1,0},{3,1},{0,1},{1,1}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }


  @Test
  public void testToroEsquinaInferiorDerecha() {

    int x = mundo.length-1;
    int y = mundo.length-1;

    int[][] vecinosReales = new int[][]{
      {2,2},{3,2},{0,2},{2,3},{0,3},{2,0},{3,0},{0,3}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testToroEsquinaInferiorIzquierda() {

    int x = 0;
    int y = mundo.length-1;

    int[][] vecinosReales = new int[][]{
      {3,2},{0,2},{1,2},{3,3},{1,3},{3,0},{0,0},{1,0}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);

    // int[][] dummy = new int[coordVecinos.length-1][coordVecinos[0].length];
    // for(int i = 0; i< coordVecinos.length-1; i++){
    //   for(int j = 0; j<coordVecinos[i].length; j++){
    //     dummy[i][j] = coordVecinos[i][j];
    //   }
    // }

    // coordVecinos = dummy;

    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testToroEsquinaSuperiorDerecha() {

    int x = mundo.length-1;
    int y = 0;

    int[][] vecinosReales = new int[][]{
      {2,3},{3,3},{0,3},{2,0},{0,0},{2,1},{3,1},{0,1}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testToroCentrica() {

    int x = 1;
    int y = 1;

    int[][] vecinosReales = new int[][]{
      {0,0},{1,0},{2,0},{0,1},{2,1},{0,2},{1,2},{2,2}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

}
