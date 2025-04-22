import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("========== Word Guessing Game ==========");
            System.out.println("1. Start Game");
            System.out.println("2. How to Play");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Game game = new Game();
                    game.play();
                    break;
                case "2":
                    printInstructions();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            System.out.println(); // خط فاصله بین هر اجرا
        }

        scanner.close();
    }

    private static void printInstructions() {
        System.out.println("\n--- How to Play ---");
        System.out.println("1. A random word will be selected.");
        System.out.println("2. You must guess the word by entering one letter at a time.");
        System.out.println("3. You have a limited number of attempts (word length + 3).");
        System.out.println("4. Correct guesses will reveal letters; incorrect ones will decrease attempts.");
        System.out.println("5. Try to guess the full word before your attempts run out!");
    }
}