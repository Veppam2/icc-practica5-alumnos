package unam.ciencias.icc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@EnabledIf("testSuiteEnabled")
public class VecindarioReglaNoventaTest {

  private ReglaNoventa automata= new ReglaNoventa();
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
  public void testArregloBordeIzquierdo() {

    int x = 0;
    int renglon = 0;

    int[][] vecinosReales = new int[][]{
      {3,renglon},{1,renglon}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, renglon);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testArregloBordeDerecho() {

    int x = mundo.length-1;
    int renglon = 0;

    int[][] vecinosReales = new int[][]{
      {2,renglon},{0,renglon}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, renglon);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }

  @Test
  public void testArregloCentrico() {

    int x = 1;
    int renglon = 0;

    int[][] vecinosReales = new int[][]{
      {0,renglon},{2,renglon}
    };

    int[][] coordVecinos = automata.obtenerCoordenadasDeVecinos(mundo, x, renglon);
    boolean sonEquivalentes = mismasCoordenadas(vecinosReales, coordVecinos);

    assertThat(sonEquivalentes, is(equalTo(true)));
    
  }
}
