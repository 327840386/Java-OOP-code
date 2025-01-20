package information;

/**
 * Represents a person with contact information.
 */
public class Person {
  private final String name;
  private final EmailAddress emailAddress;
  private final PhoneNumber phoneNumber;

  /**
   * Constructs a Person with the given name, email address, and phone number.
   *
   * @param name         The name of the person.
   * @param emailAddress The email address of the person.
   * @param phoneNumber  The phone number of the person.
   */
  public Person(String name, EmailAddress emailAddress, PhoneNumber phoneNumber) {
    this.name = name;
    this.emailAddress = emailAddress;
    this.phoneNumber = phoneNumber;
  }

  /**
   * Gets the name of the person.
   *
   * @return The name.
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the email address of the person.
   *
   * @return The email address.
   */
  public EmailAddress getEmailAddress() {
    return emailAddress;
  }

  /**
   * Gets the phone number of the person.
   *
   * @return The phone number.
   */
  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }
}


