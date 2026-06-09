public class Contract {
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

    // Print information for an (Ended Contract)
  public void printEndedContractsInfo() {

    System.out.println(
        "ID: " + ID 
      + ", Start Date: " + startDate 
 + ", Should-End Return Date: " + shouldReturnDate
 + ", Actual Return Date: " + actualReturnDate);
        
    System.out.println(
       "Number of Rent Days: " + numOfRentDays 
     + ", Number of Late Days: " + numOfLateDays);
        
        System.out.println(
                  "Base Price: " + basePrice 
                + ", Fines: " + fines 
                + ", Final Cost: " + finalCost);
    }

    // Print information for a (running/active contract)
    public void printRunningContractsInfo() {
        
      System.out.println(
          "ID: " + ID 
        + ", Start Date: " + startDate 
+ ", Should-End Return Date: " + shouldReturnDate 
+ ", Actual Return Date: -------");
        
      System.out.println(
         "Number of Rent Days: " + numOfRentDays 
       + ", Number of Late Days: -------");
        
      System.out.println(
        "Base Price: " + basePrice 
                + ", Fines: -------" 
                + ", Final Cost: -------");
    }

    // Display basic contract info
    public void displayContractInfo() {
      System.out.println("Contract ID: " + ID);

     System.out.println("Vehicle Plate Number: " + (vehicle != null ? vehicle.plateNumber : "N/A"));

        System.out.println("Customer ID: " + (customer != null ? customer.ID : "N/A"));

        System.out.println("Starting Date: " + startDate);

        System.out.println("Number of Rent Days: " + numOfRentDays);

        System.out.println("Base Price: " + basePrice);
    }
}
