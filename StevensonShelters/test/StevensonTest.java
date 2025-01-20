import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import weather.Stevenson;


/**
 * Unit tests for class Stevenson.
 */
public class StevensonTest {
  private Stevenson first;
  private Stevenson second;

  /**
   * Setup for the unit tests.
   */
  @Before
  public void setUp() {
    this.first = new Stevenson(20, -20, 40, 80);
    this.second = new Stevenson(-20, -20, 60, 5);
  }

  /**
   * Test that an exception is thrown when a negative number is provided for windSpeed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeWindSpeed() {
    new Stevenson(15, 20, 15, 80);
  }

  /**
   * Test that an exception is thrown when a negative number is provided for totalRain.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeTotalRain() {
    new Stevenson(20, 8, 20, -10);
  }

  /**
   * Test that an exception is thrown when a dew point > temperature.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testDewGreaterThanTemp() {
    new Stevenson(3.5, 4.5, 10.2, 100);
  }

  /**
   * Test getTemperature().
   */
  @Test
  public void testGetTemperature() {
    assertEquals(20, this.first.getTemperature());
    assertEquals(-20, this.second.getTemperature());
  }

  /**
   * Test getDewPoint().
   */
  @Test
  public void testGetDewPoint() {
    assertEquals(-20, this.first.getDewPoint());
    assertEquals(-20, this.second.getDewPoint());
  }

  /**
   * Test getWindSpeed().
   */
  @Test
  public void testGetWindSpeed() {
    assertEquals(40, this.first.getWindSpeed());
    assertEquals(60, this.second.getWindSpeed());
  }

  /**
   * Test getTotalRain().
   */
  @Test
  public void testGetTotalRain() {
    assertEquals(80, this.first.getTotalRain());
    assertEquals(5, this.second.getTotalRain());
  }

  /**
   * Test getRelativeHumidity().
   */
  @Test
  public void testGetRelativeHumidity() {
    assertEquals(5, this.first.getRelativeHumidity());
    assertEquals(100, this.second.getRelativeHumidity());
  }

  /**
   * Test getHeatIndex().
   */
  @Test
  public void testHeatIndex() {
    assertEquals(20, this.first.getHeatIndex());
    assertEquals(245, this.second.getHeatIndex());
  }

  /**
   * Test getWindChill().
   */
  @Test
  public void testWindChill() {
    assertEquals(19, this.first.getWindChill());
    assertEquals(-39, this.second.getWindChill());
  }

  /**
   * Test toString() method.
   */
  @Test
  public void testToString() {
    String strVan;
    String strTor;
    strVan = "temperature = 20, dewPoint = -20, windSpeed = 40, totalRain = 80";
    strTor = "temperature = -20, dewPoint = -20, windSpeed = 60, totalRain = 5";
    assertEquals(strVan, this.first.toString());
    assertEquals(strTor, this.second.toString());
  }


}
