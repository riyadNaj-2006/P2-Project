public class Car extends Vehicle {
    private String fuelType;
    private boolean airConditioner;
    private int numberOfSeats;

    Car(String plateNumber,
        String brand, 
        String model, 
        double dailyPrice,
        String fuelType,
        int numberOfSeats,
        boolean airConditioner) {
        super(plateNumber, 
              brand, model, 
              dailyPrice, true);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        this.airConditioner = airConditioner;

    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean getAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(boolean airConditioner) {
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
            ", Brand: " + brand +
            ", Model: " + model);
        System.out.println(
            "Daily Price: " + dailyPrice +
            ", Available: " + (available ? "Yes" : "No"));
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
        if (fuelType.equalsIgnoreCase("Electric")) { 
            return 0.05;
        } else {
            return 0;
        }
    }
}
