import static org.junit.Assert.assertEquals;

import information.PhoneNumber;
import org.junit.Test;

/**
 * Unit tests for the PhoneNumber class.
 */
public class PhoneNumberTest {

  @Test
  public void testGetAreaCode() {
    PhoneNumber phone = new PhoneNumber(555, 123, 2024);

    assertEquals(555, phone.getAreaCode());
  }

  @Test
  public void testGetPrefix() {
    PhoneNumber phone = new PhoneNumber(555, 123, 2024);

    assertEquals(123, phone.getPrefix());
  }

  @Test
  public void testGetLineNumber() {
    PhoneNumber phone = new PhoneNumber(555, 123, 2024);

    assertEquals(2024, phone.getLineNumber());
  }
}

