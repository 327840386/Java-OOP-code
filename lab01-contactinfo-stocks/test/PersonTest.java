import static org.junit.Assert.assertEquals;

import information.EmailAddress;
import information.Person;
import information.PhoneNumber;
import org.junit.Test;

/**
 * Unit tests for the Person class.
 */
public class PersonTest {

  @Test
  public void testGetEmailAddress() {
    EmailAddress email = new EmailAddress("m.mouse", "example.com");
    Person person = new Person("Mickey Mouse", email, null);

    assertEquals("m.mouse", person.getEmailAddress().getUsername());
    assertEquals("example.com", person.getEmailAddress().getDomain());
  }

  @Test
  public void testGetPhoneNumber() {
    PhoneNumber phoneNumber = new PhoneNumber(555, 123, 2024);
    Person person = new Person("Mickey Mouse", null, phoneNumber);

    assertEquals(555, person.getPhoneNumber().getAreaCode());
    assertEquals(123, person.getPhoneNumber().getPrefix());
    assertEquals(2024, person.getPhoneNumber().getLineNumber());
  }
}



