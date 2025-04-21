import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<MenuItem> menu = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        seedMenu();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Food Ordering System ===");
            System.out.println("1. View Menu");
            System.out.println("2. Place Order");
            System.out.println("3. View Orders");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    placeOrder();
                    break;
                case 3:
                    showOrders();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void seedMenu() {
        menu.add(new MenuItem("Pizza", 12.0));
        menu.add(new MenuItem("Burger", 9.0));
        menu.add(new MenuItem("Salad", 6.0));
        menu.add(new MenuItem("Soda", 2.0));
    }

    private static void showMenu() {
        System.out.println("\n--- Menu ---");
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.printf("%d. %s - $%.2f\n", i + 1, item.getName(), item.getPrice());
        }
    }

    private static void placeOrder() {
        Order order = new Order();

        while (true) {
            showMenu();
            System.out.print("Enter item number to add (0 to finish): ");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            if (choice > 0 && choice <= menu.size()) {
                order.addItem(menu.get(choice - 1));
                System.out.println("Item added to order.");
            } else {
                System.out.println("Invalid item number.");
            }
        }

        order.setStatus("Preparing");
        orders.add(order);
        System.out.println("Order placed successfully.");
    }

    private static void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }

        System.out.println("\n--- Orders ---");
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            System.out.println("Order #" + (i + 1));
            for (MenuItem item : order.getItems()) {
                System.out.printf("- %s - $%.2f\n", item.getName(), item.getPrice());
            }
            System.out.println("Status: " + order.getStatus());
            System.out.println("--------------------------");
        }
    }
}
