public class Car extends Vehicle {
    private String fuelType;
    private boolean airConditioner;
    private int numberOfSeats;

    Car(String plateNumber,
        String brand, 
        String model, 
        double dailyPrice, 
        boolean available,
        String fuelType,
        int numberOfSeats,
        boolean airConditioner) {
        super(plateNumber, 
              brand, model, 
              dailyPrice, available);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.airConditioner = airConditioner;

    }

    public String getfuelType() {
        return fuelType;
    }

    public void setfuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean getairConditioner() {
        return airConditioner;
    }

    public void setairConditioner(boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }



    @Override
    public void printInfo() {
        System.out.println("Vehicle Type: Car");
        System.out.println(
            "Plate Number: " + plateNumber +
            ", Brand: " + Brand +
            ", Model: " + Model);
        System.out.println(
            "Daily Price: " + dailyPrice +
            ", Available: " + (Available ? "Yes" : "No"));
        System.out.println(
           "Fuel Type: " + fuelType +
           ", Number of Seats: " + numberOfSeats +
           ", Air Condition: " + (airConditioner ? "Yes" : "No"));
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public double extraCost() {
        if (fuelType.equalsIgnoreCase("electric")) {
            return 0.05;
        } else {
            return 0;
        }
    }
}
