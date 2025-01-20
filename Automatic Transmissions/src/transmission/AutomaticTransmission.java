package transmission;

/**
 * This class represents an automatic car transmission. It implements all the operations
 * defined by the Transmission interface.
 */
public class AutomaticTransmission implements Transmission {
  private final int speedThresholdOne;
  private final int speedThresholdTwo;
  private final int speedThresholdThree;
  private final int speedThresholdFour;
  private final int speedThresholdFive;
  private int speed;
  private int gear; // Using an integer to represent the gear

  /**
   * Constructor for the transmission object that includes 5 speed thresholds.
   * @param speedThresholdOne the speed that triggers the shift from gear one to two
   * @param speedThresholdTwo the speed that triggers the shift from gear two to three
   * @param speedThresholdThree the speed that triggers the shift from gear three to four
   * @param speedThresholdFour the speed that triggers the shift from gear four to five
   * @param speedThresholdFive the speed that triggers the shift from gear five to six
   * @throws IllegalArgumentException if any speed threshold is not positive or
   *                                  if the speed thresholds are not in increasing order
   */
  public AutomaticTransmission(int speedThresholdOne, int speedThresholdTwo,
                               int speedThresholdThree, int speedThresholdFour,
                               int speedThresholdFive) throws IllegalArgumentException {

    if (speedThresholdOne >= speedThresholdTwo || speedThresholdTwo >= speedThresholdThree
        || speedThresholdThree >= speedThresholdFour || speedThresholdFour >= speedThresholdFive) {
      throw new IllegalArgumentException("Speed thresholds must increase progressively.");
    }
    if (speedThresholdOne <= 0) {
      throw new IllegalArgumentException("Threshold speed cannot be zero or negative.");
    }

    this.speedThresholdOne = speedThresholdOne;
    this.speedThresholdTwo = speedThresholdTwo;
    this.speedThresholdThree = speedThresholdThree;
    this.speedThresholdFour = speedThresholdFour;
    this.speedThresholdFive = speedThresholdFive;
    this.speed = 0;
    this.gear = 0; // Start in idle gear
  }

  /**
   * Increase the car speed by 1.
   */
  @Override
  public void increaseSpeed() {
    this.speed += 1;
    updateGear();
  }
  /**
   * Decrease the car speed to a positive number.
   * @throws IllegalStateException if the resulting speed is negative
   */

  @Override
  public void decreaseSpeed() throws IllegalStateException {
    this.speed -= 1;
    if (this.speed < 0) {
      throw new IllegalStateException("Speed cannot be negative.");
    }
    updateGear();
  }
  /**
   * get speed for the car.
   * @return the car speed
   */

  @Override
  public int getSpeed() {
    return this.speed;
  }

  /**
   * get gear for the car.
   * @return the car gear level
   */
  @Override
  public int getGear() {
    return this.gear;
  }

  private void updateGear() {
    if (this.speed == 0) {
      this.gear = 0;
    } else if (this.speed < this.speedThresholdOne) {
      this.gear = 1;
    } else if (this.speed < this.speedThresholdTwo) {
      this.gear = 2;
    } else if (this.speed < this.speedThresholdThree) {
      this.gear = 3;
    } else if (this.speed < this.speedThresholdFour) {
      this.gear = 4;
    } else if (this.speed < this.speedThresholdFive) {
      this.gear = 5;
    } else {
      this.gear = 6;
    }
  }

  /**
   * String representation of the car transmission.
   * @return string representation of the car transmission
   */
  @Override
  public String toString() {
    return String.format("Transmission (speed = %d, gear = %d)", this.speed, this.gear);
  }
}
