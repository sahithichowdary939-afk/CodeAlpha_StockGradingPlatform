import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Market market = new Market();
        System.out.println("===== STOCK TRADING PLATFORM =====");
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        User user = new User(name, 100000);
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Display Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Check Balance");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    market.displayMarketData();
                    break;
                case 2:
                    market.displayMarketData();
                    System.out.print("Enter Stock Symbol: ");
                    String buySymbol = sc.next();
                    Stock buyStock = market.findStock(buySymbol);
                    if (buyStock != null) {
                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();
                        user.buyStock(buyStock, qty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 3:
                    user.getPortfolio().displayPortfolio();
                    System.out.print("Enter Stock Symbol: ");
                    String sellSymbol = sc.next();
                    Stock sellStock = market.findStock(sellSymbol);
                    if (sellStock != null) {
                        System.out.print("Enter Quantity: ");
                        int sellQty = sc.nextInt();
                        user.sellStock(sellStock, sellQty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 4:
                    user.getPortfolio().displayPortfolio();
                    break;
                case 5:
                    user.showTransactions();
                    break;
                case 6:
                    user.displayBalance();
                    break;
                case 7:
                    System.out.println("Thank You for Using the Platform.");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        } while (choice != 7);
        sc.close();
    }
}