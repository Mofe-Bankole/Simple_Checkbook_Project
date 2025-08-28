import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CheckBook {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java CheckbookBalancer <filename>");
            return;
        }

        try (Scanner scanner = new Scanner(new File(args[0]))) {
            double balance = 0.0;

            while (scanner.hasNextLine()) {
                String action = scanner.nextLine().trim().toLowerCase();

                if (!scanner.hasNextLine()) {
                    break;
                }

                String amountLine = scanner.nextLine().trim();
                double amount;

                try {
                    amount = Double.parseDouble(amountLine);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount: " + amountLine);
                    continue;
                }

                if (action.equals("deposit")) {
                    balance += amount;
                } else if (action.equals("withdraw")) {
                    balance -= amount;
                } else {
                    System.out.println("Invalid action: " + action);
                    continue;
                }

                System.out.printf("balance: %.2f%n", balance);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
        }
    }
}
