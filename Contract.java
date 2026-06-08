package programming2project;

import java.time.LocalDate;

public class Contract {
    String ID;
    Vehicle vehicle;
    Customer customer;
    LocalDate startDate;
    int numOfRentDays;
    double basePrice;
    LocalDate shouldReturnDate;
    LocalDate actualReturnDate;
    int numOfLateDays;

    Contract(String ID, Vehicle vehicle, Customer customer, LocalDate startDate, int numOfRentDays, double basePrice,
            LocalDate shouldReturnDate, LocalDate actualReturnDate, int numOfLateDays) {
        this.ID = ID;
        this.vehicle = vehicle;
        this.customer = customer;
        this.startDate = startDate;
        this.numOfRentDays = numOfRentDays;
        this.basePrice = basePrice;
        this.shouldReturnDate = shouldReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.numOfLateDays = numOfLateDays;
    }

    private final double startPrice = (basePrice + vehicle.extraCost());
    private final double startPriceWithDiscount = startPrice * (1 - customer.getDiscountRate());
    private final int LateDays = actualReturnDate.getDayOfYear() - shouldReturnDate.getDayOfYear();
    double fines = LateDays * startPriceWithDiscount * 0.1;
    private final double finalCost = startPriceWithDiscount + fines;

    public double finalCost() {
        return finalCost;
    }

    public void printEndedContractsInfo() {
        System.out.println("ID:" + ID + "  |  Start Date:" + startDate + "  |  Should-End Return Date:"
                + shouldReturnDate + "  |  Actual Return Date:" + actualReturnDate);
        System.out.println("Number of Rentdays:" + numOfRentDays + "  |  Number of Late Days:" + numOfLateDays);
        System.out.println("Base Price:" + basePrice + "  |  Fines:" + fines + "  |  Final Cost:" + finalCost());
    }

    public void printRunningContractsInfo() {
        System.out.println("ID:" + ID + "  |  Start Date:" + startDate + "  |  Should-End Return Date:"
                + shouldReturnDate + "  |  Actual Return Date:-------");
        System.out.println("Number of Rentdays:" + numOfRentDays + "  |  Number of Late Days:-------");
        System.out.println("Base Price:" + basePrice + "  |  Fines:-------" + "  |  Final Cost:-------");
    }

    void displayContractInfo() {

        System.out.println("Contract ID: " + ID);
        System.out.println("Vehicle plateNumber:" + vehicle.plateNumber);
        System.out.println("Customer ID: " + customer.ID);
        System.out.println("Starting Date: " + startDate);
        System.out.println("Number of Rent Days: " + numOfRentDays);
        System.out.println("Base Price : " + basePrice);
    }
}
