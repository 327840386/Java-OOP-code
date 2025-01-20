package weather;

/**
 * Class representing a weather reading from a Stevenson station.
 */
public final class Stevenson {

  private final double temperature;
  private final double dewPoint;
  private final double windSpeed;
  private final int totalRain;
  private final double[] pressure;

  /**
   * Constructor.
   *
   * @param temperature the air temperature in Celsius
   * @param dewPoint    the dew point in Celsius
   * @param windSpeed   the wind speed
   * @param totalRain   the total rain
   * @throws IllegalArgumentException if any of the values are illegal.
   */
  public Stevenson(final double temperature, final double dewPoint, final double windSpeed,
                   final int totalRain) throws IllegalArgumentException {
    if (dewPoint > temperature || windSpeed < 0 || totalRain < 0) {
      throw new IllegalArgumentException("Invalid parameters:"
          + "Dew point must not exceed temperature, "
          + "wind speed and total rain must be non-negative.");
    }
    this.dewPoint = dewPoint;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.totalRain = totalRain;
    double actualVaporPressure = 6.11 * Math.pow(10, (7.5 * this.dewPoint)
        / (237.3 + this.dewPoint));
    double calculateHeatIndex = 6.11 * Math.pow(10, (7.5 * this.temperature)
        / (237.3 + this.temperature));
    this.pressure = new double[]{actualVaporPressure, calculateHeatIndex};
  }

  /**
   * temperature conversion private function.
   *
   * @param celsius the temperature in Celsius
   * @return the temperature in Fahrenheit
   */
  private double celsiusToFahrenheit(double celsius) {
    return 32 + (celsius) * 9.0 / 5.0;
  }

  /**
   * temperature conversion private function.
   *
   * @param fahrenheit the temperature in Celsius
   * @return the temperature in Fahrenheit
   */
  private double fahrenheitToCelsius(double fahrenheit) {
    return (fahrenheit - 32) / 9.0 * 5.0;
  }

  /**
   * Get the temperature of the reading rounded to the nearest integer.
   *
   * @return the temperature
   */
  public int getTemperature() {
    return (int) Math.round(this.temperature);
  }

  /**
   * Get the dew point for the reading rounded to the nearest integer.
   *
   * @return the dew point
   */
  public int getDewPoint() {
    return (int) Math.round(this.dewPoint);
  }

  /**
   * Get the wind speed for the reading rounded to the nearest integer.
   *
   * @return the wind speed
   */
  public int getWindSpeed() {
    return (int) Math.round(this.windSpeed);
  }

  /**
   * Get the total rain.
   *
   * @return the total rain
   */
  public int getTotalRain() {
    return this.totalRain;
  }

  /**
   * Calculates and returns the relative humidity rounded to the nearest integer.
   * Utilizes the vapor pressure values.
   *
   * @return Rounded relative humidity as an integer.
   */
  public int getRelativeHumidity() {
    double rh;
    rh = (this.pressure[0] / this.pressure[1]) * 100;
    return (int) Math.round(rh);
  }

  /**
   * Returns the relative humidity without rounding.
   * Based on actual and saturated vapor pressures.
   *
   * @return Relative humidity as a double.
   */
  public double getRelativeHumidityWithoutRound() {
    double rh;
    rh = (this.pressure[0] / this.pressure[1]) * 100;
    return rh;
  }

  /**
   * Get the heat index for the weather reading rounded to the nearest integer.
   *
   * @return the heat index
   */
  public int getHeatIndex() {
    // the following constants c1 to c9 are fixed in a formula
    final double c1 = -8.78469475556;
    final double c2 = 1.61139411;
    final double c3 = 2.33854883889;
    final double c4 = -0.14611605;
    final double c5 = -0.012308094;
    final double c6 = -0.0164248277778;
    final double c7 = 0.002211732;
    final double c8 = 0.00072546;
    final double c9 = -0.000003582;
    double heatIndex = c1 + c2 * this.temperature + c3 * this.getRelativeHumidityWithoutRound()
        + c4 * this.temperature * this.getRelativeHumidityWithoutRound()
        + c5 * Math.pow(this.temperature, 2)
        + c6 * Math.pow(this.getRelativeHumidityWithoutRound(), 2)
        + c7 * Math.pow(this.temperature, 2)
        * this.getRelativeHumidityWithoutRound()
        + c8 * Math.pow(this.getRelativeHumidityWithoutRound(), 2) * this.temperature + c9
        * Math.pow(this.getRelativeHumidityWithoutRound(), 2)
        * Math.pow(this.temperature, 2);
    return (int) Math.round(heatIndex);
  }

  /**
   * Get the wind chill rounded to the nearest integer.
   *
   * @return the wind chill
   */
  public int getWindChill() {
    double tempInF = celsiusToFahrenheit(this.temperature);
    double windChillF = 35.74 + 0.6215 * tempInF - 35.75 * Math.pow(this.windSpeed, 0.16)
        + 0.4275 * tempInF * Math.pow(this.windSpeed, 0.16);
    double windChillC = fahrenheitToCelsius(windChillF);
    return (int) Math.round(windChillC);
  }

  @Override
  public String toString() {
    String str;
    str = "Reading: " + String.format("T = %d, ", this.getTemperature())
        + String.format("D = %d, ", this.getDewPoint())
        + String.format("v = %d, ", this.getWindSpeed())
        + String.format("rain = %d", this.getTotalRain());
    return str;
  }

}