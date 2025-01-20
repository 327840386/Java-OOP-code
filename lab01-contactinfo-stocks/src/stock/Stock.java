package stock;

/**
 * Represents a trading stock with various details.
 */
public class Stock {

  private final String companyName;
  private final String tickerSymbol;
  private final double pricePerShare;
  private final double lowestPrice52Weeks;
  private final double highestPrice52Weeks;
  private final double totalDebt;
  private final double totalAssets;
  private final int analystRecommendation;

  /**
   * Constructs a Stock with the given details.
   *
   * @param companyName            The name of the company.
   * @param tickerSymbol           The ticker symbol of the stock.
   * @param pricePerShare          The price per share of the stock.
   * @param lowestPrice52Weeks     The lowest price in the past 52 weeks.
   * @param highestPrice52Weeks    The highest price in the past 52 weeks.
   * @param totalDebt              The total debt of the company.
   * @param totalAssets            The total assets owned by the company.
   * @param analystRecommendation  The analyst recommendation score.
   */
  public Stock(String companyName, String tickerSymbol, double pricePerShare,
               double lowestPrice52Weeks, double highestPrice52Weeks,
               double totalDebt, double totalAssets, int analystRecommendation) {
    this.companyName = companyName;
    this.tickerSymbol = tickerSymbol;
    this.pricePerShare = pricePerShare;
    this.lowestPrice52Weeks = lowestPrice52Weeks;
    this.highestPrice52Weeks = highestPrice52Weeks;
    this.totalDebt = totalDebt;
    this.totalAssets = totalAssets;
    this.analystRecommendation = analystRecommendation;
  }

  /**
   * Gets the name of the company.
   *
   * @return The name of the company.
   */
  public String getCompanyName() {
    return companyName;
  }

  /**
   * Gets the ticker symbol of the stock.
   *
   * @return The ticker symbol.
   */
  public String getTickerSymbol() {
    return tickerSymbol;
  }

  /**
   * Gets the price per share of the stock.
   *
   * @return The price per share.
   */
  public double getPricePerShare() {
    return pricePerShare;
  }

  /**
   * Gets the lowest price of the stock in the past 52 weeks.
   *
   * @return The lowest price in the past 52 weeks.
   */
  public double getLowestPrice52Weeks() {
    return lowestPrice52Weeks;
  }

  /**
   * Gets the highest price of the stock in the past 52 weeks.
   *
   * @return The highest price in the past 52 weeks.
   */
  public double getHighestPrice52Weeks() {
    return highestPrice52Weeks;
  }

  /**
   * Gets the total debt of the company.
   *
   * @return The total debt.
   */
  public double getTotalDebt() {
    return totalDebt;
  }

  /**
   * Gets the total assets owned by the company.
   *
   * @return The total assets.
   */
  public double getTotalAssets() {
    return totalAssets;
  }

  /**
   * Gets the analyst recommendation score.
   *
   * @return The analyst recommendation score.
   */
  public int getAnalystRecommendation() {
    return analystRecommendation;
  }
}


