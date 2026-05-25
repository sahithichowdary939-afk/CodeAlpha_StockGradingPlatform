import java.util.ArrayList;
public class User {
    private String name;
    private double balance;
    private Portfolio portfolio;
    private ArrayList<Transaction> transactions;
    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.portfolio = new Portfolio();
        this.transactions = new ArrayList<>();
    }
    public double getBalance() {
        return balance;
    }
    public Portfolio getPortfolio() {
        return portfolio;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void buyStock(Stock stock, int quantity) {
        double totalCost = stock.getPrice() * quantity;
        if (balance >= totalCost) {
            balance -= totalCost;
            portfolio.buyStock(stock.getSymbol(), quantity);
            transactions.add(
                    new Transaction(
                            "BUY",
                            stock.getSymbol(),
                            quantity,
                            totalCost
                    )
            );
            System.out.println("Stock purchased successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public void sellStock(Stock stock, int quantity) {
        portfolio.sellStock(stock.getSymbol(), quantity);
        double totalAmount = stock.getPrice() * quantity;
        balance += totalAmount;
        transactions.add(
                new Transaction(
                        "SELL",
                        stock.getSymbol(),
                        quantity,
                        totalAmount
                )
        );
        System.out.println("Stock sold successfully.");
    }
    public void showTransactions() {
        System.out.println("\nTransaction History:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    public void displayBalance() {
        System.out.println("Available Balance: ₹" + balance);
    }
}