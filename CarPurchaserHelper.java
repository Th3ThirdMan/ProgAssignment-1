public class CarPurchaserHelper {
    // Explain it in the reflection
    public double calculateHP(double carPrice, double deposit, double annualInterest, int termYears) {
        double amountToFinance = carPrice - deposit;
        double monthlyInterestRate = (annualInterest / 100) / 12;
        int totalMonths = termYears * 12;

        if (monthlyInterestRate == 0) {
            return amountToFinance / totalMonths;
        } else {
            // Calculate (1 + r)^n using a loop
            double factor = 1;
            for (int i = 0; i < totalMonths; i++) {
                factor *= (1 + monthlyInterestRate);
            }

            double monthlyPayment = amountToFinance * monthlyInterestRate * factor / (factor - 1);
            return monthlyPayment;
        }
    }
    // Explain it in the reflection
    public double pcpResultMonth(double carPrice, double deposit, double annualInterest, int termYears, double gmfvPercent) {
        double gmfv = carPrice * (gmfvPercent / 100);
        double amountToFinance = carPrice - deposit - gmfv;

        double monthlyInterestRate = (annualInterest / 100) / 12;
        int totalMonths = termYears * 12;

        double monthlyPayment;

        if (monthlyInterestRate == 0) {
            monthlyPayment = amountToFinance / totalMonths;
        } else {
            // Calculate (1 + r)^n using a loop
            double factor = 1;
            for (int i = 0; i < totalMonths; i++) {
                factor *= (1 + monthlyInterestRate);
            }

            monthlyPayment = amountToFinance * monthlyInterestRate * factor / (factor - 1);
        }

        return  monthlyPayment;
    }
    // Write a method called printWelcomeMessage() - returns a String 
    public String printWelcomeMessage() {
        return "Welcome to the Car Purchaser Helper!\n";  
    }

    // Write a method called printGoodbyeMessage() - returns a String
    public String printGoodbyeMessage() {
        return "Thank you for using the Car Purchaser Helper. Goodbye!";
    }
    // Write a method called calculateMonthlyCost(double, int) returns a Double
    public double calculateMonthlyCost(double carPrice, int months) {
        if(months <= 0) {
            return 0;
        }
        return carPrice/months;   
    }
    // Calculates roughly the monthly payment if the car is paid off over
    // a number of months.
    // Parameters : price of car and number of months

    // Write a method called fuelCostEstimator(double, double) returns a double
    public double fuelCostEstimator(double kmsPerWeek, double costOfFuel) {
        double litresPerWeek = (kmsPerWeek / 100) * 6;
        double weeklyFuelCost = litresPerWeek * costOfFuel;
        if (kmsPerWeek < 0 || costOfFuel < 0) {
            return 0;
        }
        return weeklyFuelCost * 4.34; // Approximate weeks per month.
    }

    // Estimates weekly fuel cost (e.g., assuming 6L per 100 km).
    // Parameters : kilometres per week and cost of fuel
    // work out litres per week by dividing weekly kms by 100 and mulitplying by 6, then multiply by cost


    // Write a method called recommendCarType(String) returns a String
    // Gives a recommendation based on the user's lifestyle
    // (Parameter : requirement e.g., “family,” “commute,” “adventure”).
    public String recommendCarType(String requirements) {
        if (requirements == null || requirements.isEmpty()) {
        return "Please enter a valid lifestyle requirement.";
    }
    // Make comparison case-insensitive
    String lower = requirements.toLowerCase();

    if (lower.equals("family")) {
        return "We recommend a spacious SUV or a minivan — perfect for families.";
    } 
    else if (lower.equals("commute")) {
        return "A fuel-efficient sedan or hybrid would suit your daily commute.";
    } 
    else if (lower.equals("adventure")) {
        return "An all-wheel-drive SUV or off-road vehicle is ideal for adventures.";
    } 
    else if (lower.equals("luxury")) {
        return "Consider a high-end sedan or electric luxury car for comfort and prestige.";
    } 
    else if (lower.equals("eco") || lower.equals("environment")) {
        return "A hybrid or fully electric car would be the best eco-friendly choice.";
    } 
    else {
        return "We recommend visiting our dealership for personalized advice!";
    }
}
}

