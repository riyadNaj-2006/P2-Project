import java.time.LocalDate;
import java.time.temporal.ChronoUnit; // Just to calculate the time between days

public class rentContract {
    // Basic attributes
    String ID;
    Vehicle vehicle;
    Customer customer;
    LocalDate startDate;
    int numOfRentDays;
    double basePrice;
    LocalDate shouldReturnDate;
    
    // Attributes calculated and set only upon contract termination
    LocalDate actualReturnDate;
    int numOfLateDays;
    double fines;       
    double finalCost;   

    // (The Genesis)
    public Contract(String ID, 
                    Vehicle vehicle, 
                    Customer customer, 
                   LocalDate startDate, 
                    int numOfRentDays,
                    double basePrice) {
        this.ID = ID;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.numOfRentDays = numOfRentDays;
        this.basePrice = basePrice;
        
        // Automatically calculate the expected return date
        this.shouldReturnDate = startDate.plusDays(numOfRentDays);
        
        // Initial default values since the vehicle is still rented
        this.actualReturnDate = null; 
        this.numOfLateDays = 0;
        this.fines = 0.0;
        this.finalCost = 0.0;

        // Automatically increments the customer's    contract counter
        this.customer.incrementContracts();
    }

    // The Termination
    public void endContract(LocalDate returnDate) {
        // 1. Record the actual return date
        this.actualReturnDate = returnDate;
        
        // 2. Calculate late days if the customer returned it past the due date
        if (actualReturnDate.isAfter(shouldReturnDate)) {
            this.numOfLateDays = (int) ChronoUnit.DAYS.between(shouldReturnDate, actualReturnDate);
        } else {
            this.numOfLateDays = 0;
        }

        // 3. Perform financial calculations and lock the final values
        double startPrice = this.basePrice + vehicle.extraCost();
        double startPriceWithDiscount = startPrice * (1 - customer.getDiscountRate());
        
        this.fines = this.numOfLateDays * startPriceWithDiscount * 0.1;
        this.finalCost = startPriceWithDiscount + this.fines;

        // 4. Print confirmation message
        System.out.println("The contract has been terminated successfully.");
    }

    public double finalCost() {
        return finalCost;
     }

    public void printEndedContractsInfo() {
      System.out.println(
          "ID:" + ID
        + ", Start Date:" + startDate
        + ", Should-End Return Date:"
        + shouldReturnDate 
        + ", Actual Return Date:" 
        + actualReturnDate);
      System.out.println(
          "Number of Rentdays:" + numOfRentDays 
        + ", Number of Late Days:" 
        + numOfLateDays);
        System.out.println(
          "Base Price:" + basePrice
        + ", Fines:" + fines
        + ", Final Cost:" + finalCost());
    }

    public void printRunningContractsInfo() {
     System.out.println(
        "ID:" + ID
      + ", Start Date:" + startDate
      + ", Should-End Return Date:"
      + shouldReturnDate
      + ", Actual Return Date:-------");

     System.out.println(
        "Number of Rentdays:" + numOfRentDays
      + ", Number of Late Days:-------");
        
     System.out.println(
        "Base Price:" + basePrice 
      + ", Fines:-------"
      + ", Final Cost:-------");
    }

    void displayContractInfo() {

        System.out.println("Contract ID: " + ID);
        System.out.println("Vehicle plateNumber:" 
                           + vehicle.plateNumber);
        System.out.println("Customer ID: " 
                           + customer.ID);
        System.out.println("Starting Date: " 
                           + startDate);
        System.out.println("Number of Rent Days: " 
                           + numOfRentDays);
        System.out.println("Base Price : " 
                           + basePrice);
    }
}