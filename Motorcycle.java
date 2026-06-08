package programming2project;

class Motorcycle extends Vehicle {
    private double engineCapacity;
    private boolean hasSideCar;

    Motorcycle(String plateNumber, 
               String Brand, String Model, 
               double dailyPrice, 
               boolean Available,
               double engineCapacity,
               boolean hasSideCar) {
        super(plateNumber, Brand, Model, 
              dailyPrice, Available);
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
          + ", Brand: " + Brand 
          + ", Model: " + Model);
        System.out.println(
            "Daily Price: " + dailyPrice
          + ", Available: " + (Available ? "Yes" : "No"));
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
