public abstract class Vehicle {

    protected String plateNumber;
    protected String brand;
    protected String model;
    protected double dailyPrice;
    protected boolean available;

    public Vehicle(String plateNumber,
                   String brand,
                   String model,
                   double dailyPrice,
                   boolean available) {

        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.dailyPrice = dailyPrice;
        this.available = available;
    }

    public abstract void printInfo();

    public abstract String getType();

    public abstract double extraCost();
}
