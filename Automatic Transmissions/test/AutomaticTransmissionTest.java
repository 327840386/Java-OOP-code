import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import transmission.AutomaticTransmission;

/**
 * Unit tests for transmission class.
 */
public class AutomaticTransmissionTest {
  private AutomaticTransmission porsche;

  /**
   * Set up class objects for unit tests.
   */
  @Before
  public void setUp() {
    this.porsche = new AutomaticTransmission(15, 20, 25, 30, 35);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionForNegativeSpeed() {
    new AutomaticTransmission(-15, 20, 25, 30, 35);
    new AutomaticTransmission(15, -20, 25, 30, 35);
    new AutomaticTransmission(15, 20, -25, 30, 35);
    new AutomaticTransmission(15, 20, 25, -30, 35);
    new AutomaticTransmission(15, 20, 25, 30, -35);
    new AutomaticTransmission(0, 15, 20, 25, 30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testExceptionForSmallerThresholds() {
    new AutomaticTransmission(20, 10, 30, 40, 50);
    new AutomaticTransmission(20, 30, 10, 40, 50);
    new AutomaticTransmission(20, 30, 40, 10, 50);
    new AutomaticTransmission(20, 30, 40, 50, 10);
    new AutomaticTransmission(20, 20, 30, 40, 50);
  }


  @Test
  public void increaseSpeed() {
    for (int i = 0; i < 15; i++) {
      this.porsche.increaseSpeed();
    }
    assertEquals(15, this.porsche.getSpeed());
    assertEquals(2, this.porsche.getGear());
  }

  @Test(expected = IllegalStateException.class)
  public void decreaseSpeedBelowZero() {
    this.porsche.decreaseSpeed();
  }


  @Test
  public void decreaseSpeed() {
    for (int i = 0; i < 15; i++) {
      this.porsche.increaseSpeed();
    }
    for (int i = 0; i < 5; i++) {
      this.porsche.decreaseSpeed();
    }
    assertEquals(10, this.porsche.getSpeed());
    assertEquals(1, this.porsche.getGear());
  }

  @Test
  public void getSpeed() {
    this.porsche.increaseSpeed();
    assertEquals(1, this.porsche.getSpeed());
  }

  @Test
  public void getGear() {
    this.porsche.increaseSpeed();
    assertEquals(1, this.porsche.getGear());
  }

  @Test
  public void testToString() {
    assertEquals("Transmission (speed = 0, gear = 0)", this.porsche.toString());
  }
}