class Truck extends Vehicle {
    private double loadCapacity;
    private boolean refrigerated;

    Truck(String plateNumber, String brand, 
          String model, double dailyPrice, 
          boolean available, double loadCapacity,
          boolean refrigerated) {
        super(plateNumber, brand, model, 
              dailyPrice, available);
        this.loadCapacity = loadCapacity;
        this.refrigerated = refrigerated;
    }

    public double getloadCapacity() {
        return loadCapacity;
    }

    public void setloadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public boolean getrefrigerated() {
        return refrigerated;
    }

    public void setrefrigerated(boolean refrigerated) {
        this.refrigerated = refrigerated;
    }

    @Override
    public void printInfo() {
     System.out.println("Vehicle Type : Truck");
     System.out.println(
         "Plate Number:" + plateNumber
       + ", Brand:" + Brand 
       + ", Model:" + Model);
     System.out.println(
         "Daily Price:" + dailyPrice
       + ", Available:" + (Available ? "Yes" : "No"));
     System.out.println(
         "Load Capacity:" + loadCapacity
       + "KG" 
       + ", Refrigerated:" + (refrigerated ? "Yes" : "No"));
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public double extraCost() {
        if (refrigerated) {
            return 0.05;
        } else {
            return 0;
        }
    }
}