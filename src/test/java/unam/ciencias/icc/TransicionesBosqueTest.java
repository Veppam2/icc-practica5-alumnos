package unam.ciencias.icc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@EnabledIf("testSuiteEnabled")
public class TransicionesBosqueTest {

  private BosqueEnLLamasHelper automata= new BosqueEnLLamasHelper();

  private double MAX_PROBA = 1.0;

  private int[][] mundo = new int[4][4];

  static boolean testSuiteEnabled() {
    return PropertiesLoader.getBooleanProperty("display.image.enabled");
  }

  private void llenaMundo(int val){
    for(int i=0; i<mundo.length;i++){
        for(int j=0; j<mundo[i].length;j++){
            mundo[i][j] = val;
       }
    }
  }

  @Test
  public void celdaArdiendoPasaACeldaVacia() {
    llenaMundo(BosqueEnLLamasHelper.ARBOL_VACIO);

    double p = MAX_PROBA;
    double f = MAX_PROBA;

    automata.setRandomP(p);
    automata.setRandomF(f);

    int x = 1;
    int y = 1;

    mundo[x][y] = BosqueEnLLamasHelper.ARBOL_ARDIENDO;
    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_VACIO, is(equalTo(nuevoEstado)));

  }

  @Test
  public void celdaConArbolYVecinoArdiendoPasaAArder() {
    llenaMundo(BosqueEnLLamasHelper.ARBOL_VACIO);

    double p = MAX_PROBA;
    double f = MAX_PROBA;

    automata.setRandomP(p);
    automata.setRandomF(f);

    int x = 1;
    int y = 1;

    mundo[x][y] = BosqueEnLLamasHelper.ARBOL_NORMAL;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));
    
    mundo[2][2] = BosqueEnLLamas.ARBOL_ARDIENDO;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_ARDIENDO, is(equalTo(nuevoEstado)));

    mundo[2][2] = BosqueEnLLamas.ARBOL_NORMAL;
    
    x=0;y=0;
    mundo[x][y] = BosqueEnLLamasHelper.ARBOL_NORMAL;
    mundo[3][3] = BosqueEnLLamas.ARBOL_ARDIENDO;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_ARDIENDO, is(equalTo(nuevoEstado)));

  }

  @Test
  public void CasillaVaciaConProbaPAceptadaPasaACeldaConArbol() {

    llenaMundo(BosqueEnLLamasHelper.ARBOL_VACIO);

    double p = 0;
    double f = MAX_PROBA;

    automata.setRandomP(p);
    automata.setRandomF(f);

    int x=0;
    int y=0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_NORMAL, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_NORMAL, is(equalTo(nuevoEstado)));
    
    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_NORMAL, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_NORMAL, is(equalTo(nuevoEstado)));

    x =1; y= 1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_NORMAL, is(equalTo(nuevoEstado)));
  }


  @Test
  public void CasillaVaciaConProbaPNegadaNoPasaACeldaConArbol() {

    llenaMundo(BosqueEnLLamasHelper.ARBOL_VACIO);

    double p = MAX_PROBA;
    double f = 0;

    automata.setRandomP(p);
    automata.setRandomF(f);

    int x=0;
    int y=0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));
    
    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x =1; y= 1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));
  }

  @Test
  public void CasillaConArbolYProbaFAceptadaPasaAIncendiarse() {

    llenaMundo(BosqueEnLLamasHelper.ARBOL_NORMAL);

    double f = 0;
    double p = MAX_PROBA;

    automata.setRandomP(p);
    automata.setRandomF(f);

    int x=0;
    int y=0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_ARDIENDO, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_ARDIENDO, is(equalTo(nuevoEstado)));
    
    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_ARDIENDO, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_ARDIENDO, is(equalTo(nuevoEstado)));

    x =1; y= 1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(BosqueEnLLamas.ARBOL_ARDIENDO, is(equalTo(nuevoEstado)));
  }

  @Test
  public void CasillaConArbolYProbaFNegadaNoSeIncendia() {

    llenaMundo(BosqueEnLLamasHelper.ARBOL_NORMAL);

    double f = MAX_PROBA;
    double p = MAX_PROBA;

    automata.setRandomP(p);
    automata.setRandomF(f);

    int x=0;
    int y=0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));
    
    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x =1; y= 1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));
  }
  
  
  
}
