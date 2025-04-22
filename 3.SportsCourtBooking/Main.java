import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Court> courts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sports Court Booking System ===");

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    bookCourt();
                    break;
                case 2:
                    addCourt();
                    break;
                case 3:
                    removeCourt();
                    break;
                case 4:
                    showCourts();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Book a court (Player)");
        System.out.println("2. Add a court (Admin)");
        System.out.println("3. Remove a court (Admin)");
        System.out.println("4. Show courts");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }

    private static void bookCourt() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine();
        Player player = new Player(name);

        showCourts();
        System.out.print("Enter court number to book: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < courts.size()) {
            player.bookCourt(courts.get(index));
        } else {
            System.out.println("Invalid court number!");
        }
    }

    private static void addCourt() {
        System.out.print("Enter sport type (e.g., Tennis, Football, Basketball): ");
        String type = scanner.nextLine();
        courts.add(new Court(type));
        System.out.println("Court added.");
    }

    private static void removeCourt() {
        showCourts();
        System.out.print("Enter court number to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine();

        if (index >= 0 && index < courts.size()) {
            courts.remove(index);
            System.out.println("Court removed.");
        } else {
            System.out.println("Invalid court number!");
        }
    }

    private static void showCourts() {
        if (courts.isEmpty()) {
            System.out.println("No courts available.");
        } else {
            System.out.println("\n--- List of Courts ---");
            for (int i = 0; i < courts.size(); i++) {
                Court c = courts.get(i);
                String status = c.isAvailable() ? "Available" : "Booked";
                System.out.println(i + ". " + c.getSportType() + " - " + status);
            }
        }
    }
}