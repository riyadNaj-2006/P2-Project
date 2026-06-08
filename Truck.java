package programming2project;

class Truck extends Vehicle {
    private double loadCapacity;
    private boolean refrigerated;

    Truck(String PlateNumber, String Brand, String Model, double DailyPrice, boolean Available, double loadCapacity,
            boolean refrigerated) {
        super(PlateNumber, Brand, Model, DailyPrice, Available);
        this.loadCapacity = loadCapacity;
        this.refrigerated = refrigerated;
    }

    public double getloadCapacity() {
        return loadCapacity;
    }

    public void setloadCapacity(float loadCapacity) {
        loadCapacity = loadCapacity;
    }

    public boolean getrefrigerated() {
        return refrigerated;
    }

    public void setrefrigerated(boolean refrigerated) {
        refrigerated = refrigerated;
    }

    @Override
    public void printInfo() {
        System.out.println("Vehicle Type : Truck");
        System.out.println("Plate Number:" + plateNumber + "  |  Brand:" + Brand + "  |  Model:" + Model);
        System.out.println("Daily Price:" + dailyPrice + "  |  Available:" + (Available ? "Yes" : "No"));
        System.out.println("Load Capacity:" + loadCapacity + "KG  |  Refrigirated:" + (refrigerated ? "Yes" : "No"));
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