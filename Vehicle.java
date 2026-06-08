package programming2project;

    public abstract class Vehicle {
    protected String plateNumber;
    protected String Brand;
    protected String Model;
    protected double dailyPrice;
    protected boolean Available;

    Vehicle(String PlateNumber, String Brand, String Model, double DailyPrice, boolean Available) {
        this.plateNumber = PlateNumber;
        this.Brand = Brand;
        this.Model = Model;
        this.dailyPrice = DailyPrice;
        this.Available = Available;
    }

    public abstract void printInfo();

    public abstract String getType();

    public abstract double extraCost();
}
