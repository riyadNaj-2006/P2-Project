public abstract class Customer {
    protected String ID;
    protected String name;
    protected String address;
    protected String phoneNumber;

    private int numberOfContracts;

    Customer(String ID, String name, 
             String address, 
             String phoneNumber,
             int numberOfContracts) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfContracts = numberOfContracts;
    }

    public int getNumberOfContracts() {
        return numberOfContracts;
    }

    public void setNumberOfContracts(int numberOfContracts) {
        this.numberOfContracts = numberOfContracts;
    }

public void incrementContracts() {
    this.numberOfContracts++;
}
    
    public abstract void printInfo();

    public abstract double getDiscountRate();

    public abstract String getType();

}
