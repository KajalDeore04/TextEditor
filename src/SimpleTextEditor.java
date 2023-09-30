import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();

        while (true) {
            System.out.println("Simple Text Editor");
            System.out.println("1. Enter Text");
            System.out.println("2. Edit Text");
            System.out.println("3. Save Text");
            System.out.println("4. Print Text");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String newText = scanner.nextLine();
                    text.append(newText).append("\n");
                    break;
                case 2:
                    System.out.println("Current Text:");
                    System.out.println(text.toString());
                    System.out.print("Edit text: ");
                    String editText = scanner.nextLine();
                    text = new StringBuilder(editText);
                    break;
                case 3:
                    saveText(text.toString());
                    break;
                case 4:
                    System.out.println("Current Text:");
                    System.out.println(text.toString());
                    break;
                case 5:
                    System.out.println("Exiting the text editor. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void saveText(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("saved_text.txt"))) {
            writer.write(content);
            System.out.println("Text saved successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
