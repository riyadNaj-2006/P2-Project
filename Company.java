public class Company extends Customer {
    private String commercialRecord;
    private double discountRate;

    Company(String ID, 
            String name, String address, 
            String phoneNumber, 
            int numberOfContracts, 
            double discountRate,
            String commercialRecord) {
        super(ID, name, address, 
               phoneNumber, 
               numberOfContracts);
        this.discountRate = discountRate;
        this.commercialRecord = commercialRecord;
    }

    public String getcommercialRecord() {
        return commercialRecord;
    }

    public void setcommercialRecord(String commercialRecord) {
        this.commercialRecord = commercialRecord;
    }

    @Override
    public double getDiscountRate() {
        return discountRate / 100;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public void printInfo() {
        System.out.println("Company Customer Info");
        System.out.println(
          "ID:" + ID 
        + ", Name:" + name
        + ", Address:" + address
        + ", Phone Number:" + phoneNumber);
        System.out.println(
          "commercialRecord:" + commercialRecord
        + ", Discount Rate:" + discountRate);
    }

    @Override
    public String getType() {
        return "Company";
    }
}
