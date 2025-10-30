
// Import Scanner for User Input
import java.util.Scanner;

public class Driver { // Initializing Blueprint Class
    public static void main(String[] args) {
        new Driver(); // New Object of Driver Class
    }

    public Driver() { // Menu Logic in Constructor
        Scanner input = new Scanner(System.in);

        // Creates a CarPurchaseHelper Object
        CarPurchaserHelper carPurchaserHelper = new CarPurchaserHelper();

        // Calls Welcome message
        System.out.println(carPurchaserHelper.printWelcomeMessage());

        // Initialize to non-zero value, LCV to avoid infinite loop
        int choice = -1;

        final String RESET = "\u001B[0m"; // ANSI Code to reset colour
        final String CYAN = "\u001B[36m"; // ANSI Code to include Cyan colour

        // Menu Options Loop
        while (choice != 0) {
            System.out.println(CYAN + "\n************************" + RESET);
            System.out.println("🚘 Car Finance Menu 🚘");
            System.out.println(CYAN + "************************" + RESET);
            System.out.println("Select Option 1 to Calculate HP 💶");
            System.out.println("Select Option 2 to Calculate PCP 💸");
            System.out.println("Select Option 3 to Calculate Monthly Cost 💰");
            System.out.println("Select Option 4 to Calculate Projected Fuel Cost ⛽");
            System.out.println("Select Option 5 to Calculate Car Type Recommendation 🚙");
            System.out.println("Select Option 0 to Exit ❌\n");
            System.out.print("Enter your choice: ");

            // Check if a Number is entered for Menu Choice
            if (!input.hasNextInt()) {
                System.out.println("Invalid Entry! Please enter a number from 0-5");
                input.nextLine();
                continue;
            }

            // Read user choice
            choice = input.nextInt(); // Required to consume the newline, then user enters choice.

            // If user chooses Option 1, HP Calculation.
            if (choice == 1) {
                System.out.print("Enter car price: ");
                double hpPrice = input.nextDouble();
                System.out.print("Enter deposit: ");
                double hpDeposit = input.nextDouble();
                System.out.print("Enter annual interest rate (%): ");
                double hpInterest = input.nextDouble();
                System.out.print("Enter term in years: ");
                int hpTerm = input.nextInt();

                double hpMonthly = carPurchaserHelper.calculateHP(hpPrice, hpDeposit, hpInterest, hpTerm);

                // HP Monthly Payment formatted to 2 decimal places
                System.out.println("Monthly HP payment: €" + String.format("%.2f", hpMonthly));
                System.out.println();
            }

            // If user chooses Option 2, PCP Calculation.
            else if (choice == 2) {
                System.out.print("Enter car price: ");
                double pcpPrice = input.nextDouble();

                System.out.print("Enter deposit: ");
                double pcpDeposit = input.nextDouble();

                System.out.print("Enter annual interest rate (%): ");
                double pcpInterest = input.nextDouble();

                System.out.print("Enter term in years: ");
                int pcpTerm = input.nextInt();

                System.out.print("Enter GMFV percentage: ");
                double gmfvPercent = input.nextDouble();

                double pcpMonthly = carPurchaserHelper.pcpResultMonth(pcpPrice, pcpDeposit, pcpInterest, pcpTerm,
                        gmfvPercent);

                // PCP Monthly Payment formatted to 2 decimal places
                System.out.println("Monthly PCP payment: €" + String.format("%.2f", pcpMonthly));
                System.out.println();
            }

            // If user chooses Option 3, Calculate Monthly Cost.
            else if (choice == 3) {
                System.out.print("Enter car price: ");
                double price = input.nextDouble();

                System.out.print("Enter number of months: ");
                int months = input.nextInt();

                double monthlyCost = carPurchaserHelper.calculateMonthlyCost(price, months);

                // Monthly cost formatted to 2 decimal places
                System.out.println("Estimated Monthly Cost: €" + String.format("%.2f", monthlyCost));
                System.out.println();
            }

            // If user chooses Option 4, Calculate Cost of Fuel
            else if (choice == 4) {
                System.out.print("Enter kilometres per week: ");
                double kmsPerWeek = input.nextDouble();
                System.out.print("Enter cost of fuel per litre: ");
                double costOfFuel = input.nextDouble();
                double estimatedFuelCost = carPurchaserHelper.fuelCostEstimator(kmsPerWeek, costOfFuel);

                // Fuel cost formatted to 2 decimal places
                System.out.println("Estimated Monthly Fuel Cost: €" + String.format("%.2f", estimatedFuelCost));
                System.out.println();
            }

            // If user chooses Option 5, Car Type Recommendation
            else if (choice == 5) {
                input.nextLine(); // Consume from previous nextInt()
                System.out.print(
                        "Based on lifestyle choice, please choose one of the following: Family, Commute, Adventure, Luxury, Eco or Unsure: ");
                String lifestyle = input.nextLine();

                String recommendation = carPurchaserHelper.recommendCarType(lifestyle);
                System.out.println();
                System.out.println(recommendation);
                System.out.println();
            }

            // Goodbye Message
            else if (choice == 0) {
                System.out.println("Thank you for using the Car Purchaser Helper. Hope you have a great day!");
            }

            // Catch Invalid Choice
            else {
                System.out.println("Invalid choice, please try again.");
            }
        }
        input.close();
    }
}
