package unam.ciencias.icc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@EnabledIf("testSuiteEnabled")
public class ImagenTest {

  static boolean testSuiteEnabled() {
    return PropertiesLoader.getBooleanProperty("display.image.enabled");
  }

  @Test
  public void dummy() {
    var a = 1;
    assertThat(a, is(equalTo(a)));
  }

}
