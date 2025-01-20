import static org.junit.Assert.assertEquals;

import org.junit.Test;
import stock.Stock;

/**
 * Unit tests for the Stock class.
 */
public class StockTest {

  @Test
  public void testStockCreation() {
    Stock stock = new Stock("Microsoft Corporation", "MSFT", 60.37,
        55.20, 75.40, 5000000, 10000000, 4);

    // Test getters
    assertEquals("Microsoft Corporation", stock.getCompanyName());
    assertEquals("MSFT", stock.getTickerSymbol());
    assertEquals(60.37, stock.getPricePerShare(), 0.01);
    assertEquals(55.20, stock.getLowestPrice52Weeks(), 0.01);
    assertEquals(75.40, stock.getHighestPrice52Weeks(), 0.01);
    assertEquals(5000000, stock.getTotalDebt(), 0.01);
    assertEquals(10000000, stock.getTotalAssets(), 0.01);
    assertEquals(4, stock.getAnalystRecommendation());
  }
}


