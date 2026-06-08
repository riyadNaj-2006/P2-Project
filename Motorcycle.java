class Motorcycle extends Vehicle {
    private double engineCapacity;
    private boolean hasSideCar;

    Motorcycle(String plateNumber, 
               String brand, String model, 
               double dailyPrice, 
               double engineCapacity,
               boolean hasSideCar) {
        super(plateNumber, brand, model, 
              dailyPrice, true);
        this.engineCapacity = engineCapacity;
        this.hasSideCar = hasSideCar;
    }

    public double getengineCapacity() {
        return engineCapacity;
    }

    public void setengineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public boolean gethasSideCar() {
        return hasSideCar;
    }

    public void sethasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void printInfo() {
        System.out.println(
            "Vehicle Type : Motorcycle");
        System.out.println(
            "Plate Number:" + plateNumber
          + ", brand: " + brand 
          + ", model: " + model);
        System.out.println(
            "Daily Price: " + dailyPrice
          + ", available: " + (available ? "Yes" : "No"));
        System.out.println(
            "Engine Capacity: " + engineCapacity
            + " CC" 
            + "Sidecar: " + (hasSideCar ? "Yes" : "No"));
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }

    @Override
    public double extraCost() {
        if (hasSideCar) {
            return 0.02;
        } else {
            return 0;
        }
    }
}
