public abstract class Customer {
    protected String ID;
    protected String Name;
    protected String Address;
    protected String phoneNumber;

    private int numberOfContracts;

    Customer(String ID, String Name, 
             String Address, 
             String phoneNumber,
             int numberOfContracts) {
        this.ID = ID;
        this.Name = Name;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
        this.numberOfContracts = numberOfContracts;
    }

    public int getNumberOfContracts() {
        return numberOfContracts;
    }

    public void setNumberOfContracts(int numberOfContracts) {
        this.numberOfContracts = numberOfContracts;
    }
    
    public abstract void printInfo();

    public abstract double getDiscountRate();

    public abstract String getType();

}
