package unam.ciencias.icc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@EnabledIf("testSuiteEnabled")
public class TransicionesGosperGunTest {

  private GosperGun automata= new GosperGun();

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
  public void testCasillasEsquinasMuertasConCeroVecinosVivos() {
        
    llenaMundo(GosperGun.CASILLA_MUERTA);

    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
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

  }

  @Test
  public void testCasillasEsquinasMuertasConUnVecinoVivo() {
        
    llenaMundo(GosperGun.CASILLA_MUERTA);
    mundo[1][1] = GosperGun.CASILLA_VIVA;
    mundo[2][1] = GosperGun.CASILLA_VIVA;
    mundo[1][2] = GosperGun.CASILLA_VIVA;
    mundo[2][2] = GosperGun.CASILLA_VIVA;

    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
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

  }

  @Test
  public void testCasillasEsquinasMuertasConDosVecinosVivos() {
        
    llenaMundo(GosperGun.CASILLA_MUERTA);
    mundo[1][0] = GosperGun.CASILLA_VIVA;
    mundo[1][1] = GosperGun.CASILLA_VIVA;
    mundo[2][0] = GosperGun.CASILLA_VIVA;
    mundo[2][1] = GosperGun.CASILLA_VIVA;
    mundo[1][2] = GosperGun.CASILLA_VIVA;
    mundo[1][3] = GosperGun.CASILLA_VIVA;
    mundo[2][2] = GosperGun.CASILLA_VIVA;
    mundo[2][3] = GosperGun.CASILLA_VIVA;

    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
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

  }

  @Test
  public void testCasillasEsquinasMuertasConTresVecinosVivos() {
        
    llenaMundo(GosperGun.CASILLA_VIVA);
    mundo[0][0] = GosperGun.CASILLA_MUERTA;
    mundo[mundo.length-1][mundo.length-1] = GosperGun.CASILLA_MUERTA;
    mundo[0][mundo.length-1] = GosperGun.CASILLA_MUERTA;
    mundo[mundo.length-1][0] = GosperGun.CASILLA_MUERTA;

    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

  }

@Test
public void testCasillaCentricaMuertaConVecinosAlRededor() {
        
    llenaMundo(GosperGun.CASILLA_MUERTA);

    int x = 1;
    int y = 1;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    mundo[0][0] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    mundo[0][1] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    mundo[0][2] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    mundo[1][2] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    mundo[2][2] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    mundo[2][1] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    mundo[2][0] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));

    mundo[1][0] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(-1, is(equalTo(nuevoEstado)));
  
 }

 @Test
  public void testCasillasEsquinasVivasConCeroVecinosVivos() {
        
    llenaMundo(GosperGun.CASILLA_MUERTA);
    mundo[0][0] = GosperGun.CASILLA_VIVA;
    mundo[mundo.length-1][mundo.length-1] = GosperGun.CASILLA_VIVA;
    mundo[0][mundo.length-1] = GosperGun.CASILLA_VIVA;
    mundo[mundo.length-1][0] = GosperGun.CASILLA_VIVA;


    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

  }

  @Test
  public void testCasillasEsquinasVivasConUnVecinoVivo() {
        
    llenaMundo(GosperGun.CASILLA_MUERTA);
    mundo[0][0] = GosperGun.CASILLA_VIVA;
    mundo[1][1] = GosperGun.CASILLA_VIVA;
    mundo[mundo.length-1][mundo.length-1] = GosperGun.CASILLA_VIVA;
    mundo[2][1] = GosperGun.CASILLA_VIVA;
    mundo[0][mundo.length-1] = GosperGun.CASILLA_VIVA;
    mundo[2][2] = GosperGun.CASILLA_VIVA;
    mundo[mundo.length-1][0] = GosperGun.CASILLA_VIVA;
    mundo[1][2] = GosperGun.CASILLA_VIVA;


    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

  }

  @Test
  public void testCasillasEsquinasVivasConDosVecinosVivos() {
        
    llenaMundo(GosperGun.CASILLA_VIVA);
    
    mundo[1][1] = GosperGun.CASILLA_MUERTA;
    mundo[2][1] = GosperGun.CASILLA_MUERTA;
    mundo[2][2] = GosperGun.CASILLA_MUERTA;
    mundo[1][2] = GosperGun.CASILLA_MUERTA;


    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

  }

  @Test
  public void testCasillasEsquinasVivasConTresVecinosVivos() {
        
    llenaMundo(GosperGun.CASILLA_VIVA);

    int x = 0;
    int y = 0;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=0;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=0;y=mundo.length-1;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    x=mundo.length-1;y=0;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

  }


  @Test
public void testCasillaCentricaVivaConVecinosAlRededor() {
        
    llenaMundo(GosperGun.CASILLA_MUERTA);


    int x = 1;
    int y = 1;

    mundo[x][y] = GosperGun.CASILLA_VIVA;

    int nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    mundo[0][0] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    mundo[0][1] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    mundo[0][2] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_VIVA, is(equalTo(nuevoEstado)));

    mundo[1][2] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    mundo[2][2] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    mundo[2][1] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    mundo[2][0] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));

    mundo[1][0] = GosperGun.CASILLA_VIVA;
    nuevoEstado = automata.obtenerTransicionSobreCoordenada(mundo, x, y);
    assertThat(GosperGun.CASILLA_MUERTA, is(equalTo(nuevoEstado)));
  
 }


}
