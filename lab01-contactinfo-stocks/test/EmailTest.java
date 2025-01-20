import static org.junit.Assert.assertEquals;

import information.EmailAddress;
import org.junit.Test;

/**
 * Unit tests for the EmailAddress class.
 */
public class EmailTest {

  @Test
  public void testGetUsername() {
    EmailAddress email = new EmailAddress("m.mouse", "example.com");

    assertEquals("m.mouse", email.getUsername());
  }

  @Test
  public void testGetDomain() {
    EmailAddress email = new EmailAddress("m.mouse", "example.com");

    assertEquals("example.com", email.getDomain());
  }
}


