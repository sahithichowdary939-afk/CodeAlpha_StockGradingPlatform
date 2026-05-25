import java.time.LocalDateTime;
public class Transaction {
    private String type;
    private String stockSymbol;
    private int quantity;
    private double totalAmount;
    private LocalDateTime dateTime;
    public Transaction(String type, String stockSymbol, int quantity, double totalAmount) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.dateTime = LocalDateTime.now();
    }
    @Override
    public String toString() {
        return dateTime + " | " + type + " | " + stockSymbol +
                " | Qty: " + quantity + " | ₹" + totalAmount;
    }
}