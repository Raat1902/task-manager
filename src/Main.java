import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("Welcome to your daily task manager! Choose an option:");
            System.out.println("1 = Add a task");
            System.out.println("2 = View your tasks");
            System.out.println("3 = Mark a task as complete");
            System.out.println("4 = Exit");

            int choice = readInt(scanner, "Enter your choice: ");

            if (choice == 1) {
                int n = readInt(scanner, "How many tasks do you want to add? ");
                if (n <= 0) {
                    System.out.println("Please enter a number bigger than 0.");
                    continue;
                }

                System.out.println("Enter " + n + " task(s):");
                for (int i = 0; i < n; i++) {
                    String task = readNonEmptyLine(scanner, "Task " + (i + 1) + ": ");
                    tasks.add(task);
                }
            } else if (choice == 2) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks added yet.");
                } else {
                    System.out.println("Your tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
            } else if (choice == 3) {
                if (tasks.isEmpty()) {
                    System.out.println("No tasks to mark as complete.");
                    continue;
                }

                System.out.println("Your tasks:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ". " + tasks.get(i));
                }

                int index = readInt(scanner, "Enter the task number to mark as complete: ");
                if (index < 1 || index > tasks.size()) {
                    System.out.println("Invalid task number.");
                } else {
                    tasks.remove(index - 1);
                    System.out.println("Task marked as complete and removed.");
                }
            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("That is not a number. Try again.");
            }
        }
    }

    private static String readNonEmptyLine(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Please type something.");
        }
    }
}