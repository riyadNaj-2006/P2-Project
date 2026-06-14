package Project_java2;
public abstract class Customer {
    static protected int nextIdCustomer=1;
    protected String ID;
    protected String Name;
    protected String Address;
    protected String phoneNumber;
    protected boolean isRented=false ;
    private int numberOfContracts;    // for vib Customer

    Customer( String Name, String Address, String phoneNumber) {
        this.ID = "CUS"+"_"+getType()+ "_"+String.format("%04d", nextIdCustomer++);
        this.Name = Name;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
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

    public abstract void printinfo();

    public abstract double getDiscountRate();

    public abstract String getType();

}

