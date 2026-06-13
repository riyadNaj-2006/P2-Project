class Truck extends Vehicle {
    private double loadCapacity;
    private boolean refrigerated;

    Truck(String plateNumber, String brand, 
          String model, double dailyPrice, 
          double loadCapacity,
          boolean refrigerated) {
        super(plateNumber, brand, model, 
              dailyPrice, true);
        this.loadCapacity = loadCapacity;
        this.refrigerated = refrigerated;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public boolean getRefrigerated() {
        return refrigerated;
    }

    public void setRefrigerated(boolean refrigerated) {
        this.refrigerated = refrigerated;
    }

    @Override
    public void printInfo() {
     System.out.println("Vehicle Type : Truck");
     System.out.println(
         "Plate Number:" + plateNumber
       + ", Brand:" + brand 
       + ", Model:" + model);
     System.out.println(
         "Daily Price:" + dailyPrice
       + ", Available:" + (available ? "Yes" : "No"));
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