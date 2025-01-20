package information;

/**
 * Represents a phone number with area code, prefix, and line number.
 */
public class PhoneNumber {
  private final int areaCode;
  private final int prefix;
  private final int lineNumber;

  /**
   * Constructs a PhoneNumber with the given area code, prefix, and line number.
   *
   * @param areaCode    The area code of the phone number.
   * @param prefix      The prefix of the phone number.
   * @param lineNumber  The line number of the phone number.
   */
  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNumber = lineNumber;
  }

  /**
   * Gets the area code of the phone number.
   *
   * @return The area code.
   */
  public int getAreaCode() {
    return areaCode;
  }

  /**
   * Gets the prefix of the phone number.
   *
   * @return The prefix.
   */
  public int getPrefix() {
    return prefix;
  }

  /**
   * Gets the line number of the phone number.
   *
   * @return The line number.
   */
  public int getLineNumber() {
    return lineNumber;
  }
}

