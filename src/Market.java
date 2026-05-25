import java.util.ArrayList;

public class Market {

    private ArrayList<Stock> stocks;

    public Market() {

        stocks = new ArrayList<>();

        stocks.add(new Stock("TCS", "Tata Consultancy Services", 3500));
        stocks.add(new Stock("INFY", "Infosys", 1500));
        stocks.add(new Stock("RELIANCE", "Reliance Industries", 2800));
        stocks.add(new Stock("WIPRO", "Wipro Limited", 450));
    }

    public void displayMarketData() {

        System.out.println("\nAvailable Stocks:");

        for (Stock stock : stocks) {
            stock.displayStock();
        }
    }

    public Stock findStock(String symbol) {

        for (Stock stock : stocks) {

            if (stock.getSymbol().equalsIgnoreCase(symbol)) {
                return stock;
            }
        }

        return null;
    }
}