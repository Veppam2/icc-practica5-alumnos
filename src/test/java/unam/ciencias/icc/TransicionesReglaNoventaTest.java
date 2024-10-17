package unam.ciencias.icc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@EnabledIf("testSuiteEnabled")
public class TransicionesReglaNoventaTest {

  private ReglaNoventa automata= new ReglaNoventa();

  /*
  private int[][] dummyVariableMundos  = new int[][]{
    {ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_VIVA},
    {ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_MUERTA},
    {ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_VIVA},
    {ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_MUERTA},
    {ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_VIVA},
    {ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_VIVA,   ReglaNoventa.CASILLA_MUERTA},
    {ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_VIVA},
    {ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_MUERTA}
  };

   */

  private int[][] mundo  = new int[][]{
    {ReglaNoventa.CASILLA_VIVA, ReglaNoventa.CASILLA_VIVA, ReglaNoventa.CASILLA_VIVA, ReglaNoventa.CASILLA_VIVA, ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_MUERTA, ReglaNoventa.CASILLA_MUERTA},
    {ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_MUERTA},
    {ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA}
};

  static boolean testSuiteEnabled() {
    return PropertiesLoader.getBooleanProperty("display.image.enabled");
  }


  @Test
  public void testSiguienteEstadoCentrico() {
      
      int[] estadosEsperados = new int[]{
          ReglaNoventa.CASILLA_MUERTA,
          ReglaNoventa.CASILLA_VIVA,
          ReglaNoventa.CASILLA_MUERTA,
          ReglaNoventa.CASILLA_VIVA,
          ReglaNoventa.CASILLA_VIVA,
          ReglaNoventa.CASILLA_MUERTA,
          ReglaNoventa.CASILLA_VIVA,
          ReglaNoventa.CASILLA_MUERTA
        };
        
    int x = 1;

    for( int renglon = 0; renglon < estadosEsperados.length; renglon++){
        
        int nuevoEstado =  automata.obtenerTransicionSobreCoordenada( mundo, x, renglon);
        assertThat(estadosEsperados[renglon], is(equalTo(nuevoEstado)));

    }
    
  }

  @Test
  public void testSiguienteEstadoBordeIzquierdo() {
    int x = 0;

    int[] estadosEsperados = new int[]{
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA
    };

    for( int renglon = 0; renglon < estadosEsperados.length; renglon++){
        
        int nuevoEstado =  automata.obtenerTransicionSobreCoordenada( mundo, x, renglon);
        assertThat(estadosEsperados[renglon], is(equalTo(nuevoEstado)));

    }
    
  }

  @Test
  public void testSiguienteEstadoBordeDerecho() {
    int x = 2;

    int[] estadosEsperados = new int[]{
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_VIVA,
        ReglaNoventa.CASILLA_MUERTA,
        ReglaNoventa.CASILLA_MUERTA
    };

    for( int renglon = 0; renglon < estadosEsperados.length; renglon++){
        
        int nuevoEstado =  automata.obtenerTransicionSobreCoordenada( mundo, x, renglon);
        assertThat(estadosEsperados[renglon], is(equalTo(nuevoEstado)));

    }
    
  }


}
