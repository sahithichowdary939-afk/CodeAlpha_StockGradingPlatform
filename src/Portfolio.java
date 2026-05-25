import java.util.HashMap;
public class Portfolio {
    private HashMap<String, Integer> holdings;
    public Portfolio() {
        holdings = new HashMap<>();
    }
    public void buyStock(String symbol, int quantity) {
        holdings.put(symbol,
                holdings.getOrDefault(symbol, 0) + quantity);
    }
    public void sellStock(String symbol, int quantity) {
        if (holdings.containsKey(symbol)) {
            int currentQty = holdings.get(symbol);
            if (currentQty >= quantity) {
                holdings.put(symbol, currentQty - quantity);
                if (holdings.get(symbol) == 0) {
                    holdings.remove(symbol);
                }
            } else {
                System.out.println("Not enough shares.");
            }
        } else {
            System.out.println("Stock not found in portfolio.");
        }
    }
    public HashMap<String, Integer> getHoldings() {
        return holdings;
    }
    public void displayPortfolio() {
        if (holdings.isEmpty()) {
            System.out.println("Portfolio is empty.");
            return;
        }
        System.out.println("\nYour Portfolio:");
        for (String symbol : holdings.keySet()) {
            System.out.println(symbol + " : " + holdings.get(symbol) + " shares");
        }
    }
}