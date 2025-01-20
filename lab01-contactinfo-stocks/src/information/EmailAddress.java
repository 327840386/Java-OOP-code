package information;

/**
 * Represents an email address with a username and domain.
 */
public class EmailAddress {
  private final String username;
  private final String domain;

  /**
   * Constructs an EmailAddress with the given username and domain.
   *
   * @param username The username part of the email address.
   * @param domain   The domain part of the email address.
   */
  public EmailAddress(String username, String domain) {
    this.username = username;
    this.domain = domain;
  }

  /**
   * Gets the username part of the email address.
   *
   * @return The username.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Gets the domain part of the email address.
   *
   * @return The domain.
   */
  public String getDomain() {
    return domain;
  }
}
