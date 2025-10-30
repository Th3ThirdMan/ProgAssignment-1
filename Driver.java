import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        Scanner input = new Scanner(System.in);

        // Creates a CarPurchaseHelper Object
        CarPurchaserHelper carPurchaserHelper = new CarPurchaserHelper();

        // Call welcome message
        System.out.println(carPurchaserHelper.printWelcomeMessage());

        int choice = -1; // Initialize to non-zero value, LCV to avoid infinite loop

        final String RESET = "\u001B[0m"; // ANSI Code to reset colour
        final String CYAN = "\u001B[36m"; // ANSI Code to include Cyan colour

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
            choice = input.nextInt();
            // Needed for Car Type Recommendation to consume the newline
            // User enters choice

            // If user chooses HP
            // --- HP Calculation ---
            // Prints Menu
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
                // Format to 2 decimal places
                System.out.println("Monthly HP payment: €" + String.format("%.2f", hpMonthly));
                System.out.println();
            }

            // If user chooses PCP
            // --- PCP Calculation ---
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
                // Format to 2 decimal places
                System.out.println("Monthly PCP payment: €" + String.format("%.2f", pcpMonthly));
                System.out.println();
            }
            // Ask user to enter all the information required for
            // calculation and call the appropriate method

            // Add in remaining choices for the methods you have written
            // in the CarPurchaseHelper class

            // Calculate Monthly Cost

            else if (choice == 3) {
                System.out.print("Enter car price: ");
                double price = input.nextDouble();

                System.out.print("Enter number of months: ");
                int months = input.nextInt();

                double monthlyCost = carPurchaserHelper.calculateMonthlyCost(price, months);
                // Format to 2 decimal places
                System.out.println("Estimated Monthly Cost: €" + String.format("%.2f", monthlyCost));
                System.out.println();
            }

            // Calculate Cost of Fuel

            else if (choice == 4) {
                System.out.print("Enter kilometres per week: ");
                double kmsPerWeek = input.nextDouble();
                System.out.print("Enter cost of fuel per litre: ");
                double costOfFuel = input.nextDouble();
                double estimatedFuelCost = carPurchaserHelper.fuelCostEstimator(kmsPerWeek, costOfFuel);
                // Format to 2 decimal places
                System.out.println("Estimated Monthly Fuel Cost: €" + String.format("%.2f", estimatedFuelCost));
                System.out.println();
            }

            // Car Type Recommendation

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
