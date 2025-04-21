import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Ride> rides = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Theme Park Menu ---");
            System.out.println("1. Add Ride");
            System.out.println("2. Add Visitor");
            System.out.println("3. Start Ride");
            System.out.println("4. Show Rides");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // مصرف Enter

            switch (choice) {
                case 1:
                    addRide();
                    break;
                case 2:
                    addVisitor();
                    break;
                case 3:
                    startRide();
                    break;
                case 4:
                    showRides();
                    break;
                case 5:
                    System.out.println("Exiting... Bye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void addRide() {
        System.out.print("Enter ride name: ");
        String name = scanner.nextLine();
        System.out.print("Enter capacity: ");
        int capacity = scanner.nextInt();
        System.out.print("Enter duration: ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        rides.add(new Ride(name, capacity, duration));
        System.out.println("Ride added successfully!");
    }

    private static void addVisitor() {
        if (rides.isEmpty()) {
            System.out.println("No rides available.");
            return;
        }

        System.out.print("Visitor name: ");
        String name = scanner.nextLine();
        System.out.print("Is VIP? (yes/no): ");
        String vipInput = scanner.nextLine().toLowerCase();

        Visitor visitor = vipInput.equals("yes") ? new VIPVisitor(name) : new Visitor(name);

        System.out.println("Select a ride:");
        for (int i = 0; i < rides.size(); i++) {
            System.out.println((i + 1) + ". " + rides.get(i).getName());
        }

        int rideChoice = scanner.nextInt();
        scanner.nextLine();

        if (rideChoice > 0 && rideChoice <= rides.size()) {
            Ride selectedRide = rides.get(rideChoice - 1);
            selectedRide.addVisitor(visitor);
        } else {
            System.out.println("Invalid ride selection.");
        }
    }

    private static void startRide() {
        if (rides.isEmpty()) {
            System.out.println("No rides available.");
            return;
        }

        System.out.println("Select a ride to start:");
        for (int i = 0; i < rides.size(); i++) {
            System.out.println((i + 1) + ". " + rides.get(i).getName());
        }

        int rideChoice = scanner.nextInt();
        scanner.nextLine();

        if (rideChoice > 0 && rideChoice <= rides.size()) {
            rides.get(rideChoice - 1).startRide();
        } else {
            System.out.println("Invalid ride selection.");
        }
    }

    private static void showRides() {
        if (rides.isEmpty()) {
            System.out.println("No rides available.");
        } else {
            System.out.println("\nAvailable Rides:");
            for (Ride r : rides) {
                System.out.println("- " + r.getName());
            }
        }
    }
}