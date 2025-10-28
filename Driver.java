import org.w3c.dom.ls.LSOutput; // Will Remove in next push, as not used.

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        new Driver();
    }

    public Driver(){
        Scanner input = new Scanner(System.in);

        //Creates a CarPurchaseHelper Object
        CarPurchaserHelper carPurchaserHelper = new CarPurchaserHelper();


        //Call welcome message
        System.out.println(carPurchaserHelper.printWelcomeMessage());
        
        int choice = -1; // Initialize to non-zero value, LCV to avoid infinite loop
            while (choice != 0) {
                System.out.println("***** Car Finance Menu *****\n");
                System.out.println("Select Option 1 to Calculate HP");
                System.out.println("Select Option 2 to Calculate PCP");
                System.out.println("Select Option 3 to Calculate Monthly Cost");
                System.out.println("Select Option 4 to Calculate Projected Fuel Cost");
                System.out.println("Select Option 5 to Calculate Car Type Recommendation");
                System.out.println("Select Option 0 to Exit\n");
                System.out.print("Enter your choice: ");

            // Read user choice
            choice = input.nextInt();
            input.nextLine(); // Needed for Car Type Recommendation to consume the newline
            //ToDo :user enters choice

            //If user chooses HP
            // --- HP Calculation ---
            //Prints menu
                if(choice == 1) {
                    System.out.print("Enter car price: ");
                    double hpPrice = input.nextDouble();
                    System.out.print("Enter deposit: ");
                    double hpDeposit = input.nextDouble();
                    System.out.print("Enter annual interest rate (%): ");
                    double hpInterest = input.nextDouble();
                    System.out.print("Enter term in years: ");
                    int hpTerm = input.nextInt();

                    double hpMonthly = carPurchaserHelper.calculateHP(hpPrice, hpDeposit, hpInterest, hpTerm);
                    System.out.println("Monthly HP payment: €" + hpMonthly);
                }
        
            // If user chooses PCP
                // --- PCP Calculation ---
                else if(choice == 2) {
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

                    double pcpMonthly = carPurchaserHelper.pcpResultMonth(pcpPrice, pcpDeposit, pcpInterest, pcpTerm, gmfvPercent);
                    System.out.println("Monthly PCP payment: €" + pcpMonthly);
                }
            //Ask user to enter all the information required for
            //calculation and call the appropriate method


            //Add in remaining choices for the methods you have written
            //in the CarPurchaseHelper class

            // Calculate Monthly Cost

                else if(choice == 3) {
                    System.out.print("Enter car price: ");
                    double price = input.nextDouble();

                    System.out.print("Enter number of months: ");
                    int months = input.nextInt();

                    double monthlyCost = carPurchaserHelper.calculateMonthlyCost(price, months);
                    System.out.println("Estimated Monthly Cost: €" + monthlyCost);
                }

                // Calculate Cost of Fuel

                else if(choice == 4) {                    
                    System.out.print("Enter kilometres per week: ");
                    double kmsPerWeek = input.nextDouble();
                    System.out.print("Enter cost of fuel per litre: ");
                    double costOfFuel = input.nextDouble();
                    double estimatedFuelCost = carPurchaserHelper.fuelCostEstimator(kmsPerWeek, costOfFuel);
                    System.out.println("Estimated Monthly Fuel Cost: €" + estimatedFuelCost);   
                }

            // Car Type Recommendation

                else if (choice == 5) {
                    System.out.print("Enter your lifestyle requirement (family, commute, adventure, luxury, eco): ");
                    String lifestyle = input.nextLine();

                    String recommendation = carPurchaserHelper.recommendCarType(lifestyle);
                    System.out.println(recommendation);
                }

            // Goodbye Message

                else if (choice == 0) {
                    System.out.println("Thank you for using the Car Purchaser Helper. Goodbye!");
            }

            // Catch Invalid Choice
                else {
                    System.out.println("Invalid choice, please try again.");
            }

                input.close();
            }
        }

    }


