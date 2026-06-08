package programming2project;

import java.time.LocalDate;

public class Individual extends Customer {
    private String licenseNumber;
    private LocalDate birthDate;

    Individual(String ID, String Name, String Address, String phoneNumber, int numberOfContracts, String licenseNumber,
     LocalDate birthDate) {
        super(ID, Name, Address, phoneNumber, numberOfContracts);
        this.licenseNumber = licenseNumber;
        this.birthDate = birthDate;

    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String getType() {
        return "Individual";
    }

    @Override
    public double getDiscountRate() {
        return 0;
    }

    @Override
    public void printInfo() {
        System.out.println("Individual Customer Info");
        System.out.println(
                "ID:" + ID + "  |  Name:" + Name + "  |  Address:" + Address + "  |  Phone Number:" + phoneNumber);
        System.out.println("Driving License Number:" + licenseNumber + "  |  Birthdate:" + birthDate);
    }

}
