package unam.ciencias.icc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@EnabledIf("testSuiteEnabled")
public class VecindarioGosperGunTest {

  private GosperGun automata= new GosperGun();
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
  public void testEstrictoEsquinaSuperiorIzquierda() {

    int x = 0;
    int y = 0;

    int[][] vecinosReales = new int[][]{
      {1,0},{1,1},{0,1}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }


  @Test
  public void testEstrictoEsquinaInferiorDerecha() {

    int x = mundo.length-1;
    int y = mundo.length-1;

    int[][] vecinosReales = new int[][]{
        {2,3},{2,2},{3,2}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testEstrictoEsquinaInferiorIzquierda() {

    int x = 0;
    int y = mundo.length-1;

    int[][] vecinosReales = new int[][]{
        {0,2},{1,2},{1,3}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testEstrictoEsquinaSuperiorDerecha() {

    int x = mundo.length-1;
    int y = 0;

    int[][] vecinosReales = new int[][]{
        {2,0},{2,1},{3,1}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, y);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testEstrictoCentrica() {

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
