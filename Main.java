package programming2project;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Contract> contracts = new ArrayList<>();
    static ArrayList<Contract> runningContracts = new ArrayList<>();
    static ArrayList<Contract> endedContracts = new ArrayList<>();
    static double balance = 100000;

    public static void main(String[] args) {
        vehicles.add(new Car("007568", "Toyota", "Camry", 50, true, "petrol", 5, true));
        vehicles.add(new Car("007345", "Tesla", "Model 3", 42, true, "electric", 5, true));
        vehicles.add(new Motorcycle("006578", "Harley", "Davidson", 35, true, 1200, true));
        vehicles.add(new Motorcycle("002348", "Kawasaki", "Ninja H2R", 190, true, 998, false));
        vehicles.add(new Truck("005364", "Volvo", "FH16", 90, true, 8000, true));

        customers.add(new Individual("0066", "Yessayie", "Damascus", "0994 592 915", 0, "06001237",
                LocalDate.of(2007, 7, 13)));
        customers.add(new Company("0024", "Cham City Center", "Damascus", "011 562 8889", 0, 23, "CCDU7782"));
        int choice = 0;
        do {
            System.out.println("1- Add Vehicle");
            System.out.println("2- Remove Vehicle");
            System.out.println("3- Search Vehicle");
            System.out.println("4- List All Vehicles");
            System.out.println("5- List Available Vehicles");
            System.out.println("6- Add Customer");
            System.out.println("7- Search Customer");
            System.out.println("8- List All Customers");
            System.out.println("9- Update Customer Info");
            System.out.println("10- Rent Vehicle");
            System.out.println("11- Return Vehicle");
            System.out.println("12- List Ended Contracts");
            System.out.println("13- List Running Contracts");
            System.out.println("14- Display Customer Contracts by Name");
            System.out.println("15- Display Company Customers");
            System.out.println("16- List Rented Vehicles");
            System.out.println("17- List Vehicles with Fines Now");
            System.out.println("18- List Rented Vehicles in Specific Time");
            System.out.println("19- List Rented Motorcycles in Specific Time");
            System.out.println("20- List Customers who Rented Specific Vehicle");
            System.out.println("21- Show Shop Balance");
            System.out.println("22- Show VIP Customers");
            System.out.println("23- Exit Program");
            System.out.println("Enter your Choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    searchVehicle();
                    break;
                case 4:
                    ListAllVehicles();
                    break;
                case 5:
                    ListAvailableVehicles();
                    break;
                case 6:
                    addCustomer();
                    break;
                case 7:
                    searchCustomer();
                    break;
                case 8:
                    ListAllCustomer();
                    break;
                case 9:
                    updateCustomerInfo();
                    break;
                case 10:
                    RentVehicle();
                    break;
                case 11:
                    ReturnVehicle();
                    break;
                case 12:
                    ListEndedContracts();
                    break;
                case 13:
                    ListRunningContracts();
                    break;
                case 14:
                    displayCustomerContractsByName();
                    break;
                case 15:
                    displayCustomerContractsByCompany();
                    break;
                case 16:
                    ListRentedvehicles();
                    break;
                case 17:
                    ListVehiclesWithFinesNow();
                    break;
                case 18:
                    ListRentedVehicleInSpecificTime();
                    break;
                case 19:
                    ListRentedMotorcyclesInSpecificTime();
                case 20:
                    ListCustomersWhoRentedSpecificVehicle();
                    break;
                case 21:
                    showBalance();
                    break;
                case 22:
                    ListVIPcustomers();
                    break;
                case 23:
                    System.out.println("Thanks for Using our Program");
                    break;
                default:
                    System.out.println("Please Enter a Valid number");
                    break;
            }
        } while (choice != 23);
    }

    static void addVehicle() {
        int type;
        System.out.println("Enter vehicle type: 1-Car | 2-Motorcycle | 3-Truck");
        type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Fill the following form:");
        System.out.print("Plate Number: ");
        String plateNumber = scanner.nextLine();
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Daily Price: ");
        double dailyPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Available (true/false): ");
        boolean available = scanner.nextBoolean();
        scanner.nextLine();

        Vehicle vehicle = null;

        switch (type) {
            case 1:
                System.out.print("Fuel Type (petrol/diesel/electric): ");
                String fuelType = scanner.nextLine();
                System.out.print("Number of Seats: ");
                int numOfSeats = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Air Condition (true/false): ");
                boolean AC = scanner.nextBoolean();
                scanner.nextLine();
                vehicle = new Car(plateNumber, brand, model, dailyPrice, available, fuelType, numOfSeats, AC);
                break;
            case 2:
                System.out.print("Engine Capacity (CC): ");
                double engineCapacity = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Sidecar Availability (true/false): ");
                boolean sidecarAvailability = scanner.nextBoolean();
                scanner.nextLine();
                vehicle = new Motorcycle(plateNumber, brand, model, dailyPrice, available, engineCapacity,
                        sidecarAvailability);
                break;
            case 3:
                System.out.print("Load Capacity (KG): ");
                double load = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Refrigeration Support (true/false): ");
                boolean fridge = scanner.nextBoolean();
                scanner.nextLine();
                vehicle = new Truck(plateNumber, brand, model, dailyPrice, available, load, fridge);
                break;
            default:
                System.out.println("Invalid vehicle type!");
                return;
        }
        vehicles.add(vehicle);
        System.out.println("The " + vehicle.getType() + " has been added ");
        System.out.println();
    }

    static void removeVehicle() {
        System.out.print("Enter vehicle plate number to remove: ");
        String plateNum = scanner.next();
        scanner.nextLine();
        boolean removed = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).plateNumber.equals(plateNum)) {
                if (vehicles.get(i).Available == true) {
                    vehicles.remove(vehicles.get(i));
                    removed = true;
                    System.out.println("Vehicle removed");
                    break;
                } else {
                    System.out.println("Can't remove vehicle, vehicle is rented");
                }
            }
        }
        if (removed == false) {
            System.out.println("Vehicle could not be found");
        }
    }

    static void searchVehicle() {
        System.out.print("Enter plate number: ");
        String plateNum = scanner.next();
        scanner.nextLine();
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.plateNumber.equals(plateNum)) {
                vehicle.printInfo();
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Vehicle not found");
        }
    }

    static void ListAllVehicles() {
        if (vehicles.size() != 0) {
            for (int i = 0; i < vehicles.size(); i++) {
                vehicles.get(i).printInfo();
                System.out.println();
            }
        } else {
            System.out.println("There are no vehicles");
        }
    }

    static void ListAvailableVehicles() {
        boolean found = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).Available) {
                vehicles.get(i).printInfo();
                found = true;
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("There are no available vehicles");
        }
    }

    static void addCustomer() {
        int type;
        System.out.println("Enter customer type: 1-Individual | 2-Company");
        type = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Fill the following form:");
        System.out.print("ID: ");
        String ID = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        Customer customer = null;

        switch (type) {
            case 1:
                System.out.print("Driving License Number: ");
                String license = scanner.nextLine();
                System.out.println("Birth Date:");
                System.out.print("Day:");
                int day = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                System.out.print("Month:");
                int month = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                System.out.print("Year:");
                int year = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                LocalDate birth = LocalDate.of(year, month, day);
                customer = new Individual(ID, name, address, phoneNumber, 0, license, birth);
                break;
            case 2:
                System.out.print("Commercial Registration Number: ");
                String commercialRegistrationNumber = scanner.nextLine();
                System.out.print("Discount Percentage: ");
                double discountPercentage = scanner.nextDouble();
                scanner.nextLine();
                customer = new Company(ID, name, address, phoneNumber, 0, discountPercentage,
                        commercialRegistrationNumber);
                System.out.println();
                break;
            default:
                System.out.println("Invalid Customer type");
                return;
        }
        customers.add(customer);
        System.out.println("Customer added");
    }

    static void searchCustomer() {
        System.out.print("Enter customer ID: ");
        String ID = scanner.next();
        scanner.nextLine();
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.ID.equals(ID)) {
                customer.printInfo();
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Customer not found");
        }
    }

    static void ListAllCustomer() {
        if (customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                customers.get(i).printInfo();
                System.out.println();
            }
        } else {
            System.out.println("There are no customers");
        }
    }

    static void updateCustomerInfo() {
        System.out.print("Enter Customer ID to update: ");
        String ID = scanner.next();
        scanner.nextLine();
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.ID.equals(ID)) {
                found = true;
                System.out.println("Current customer info:");
                customer.printInfo();
                System.out.println("Enter new info, or leave blank to keep current info");
                System.out.print("New name: ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    customer.Name = newName;
                }
                System.out.print("Address: ");
                String newAddress = scanner.nextLine();
                if (!newAddress.isEmpty()) {
                    customer.Address = newAddress;
                }
                System.out.print("Phone Number: ");
                String newPhoneNumber = scanner.nextLine();
                if (!newPhoneNumber.isEmpty()) {
                    customer.phoneNumber = newPhoneNumber;
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Customer could not be found");
        }
    }

    static void RentVehicle() {
        if (vehicles.size() == 0) {
            System.out.println("There are no vehicles available for rent");
            return;
        }
        System.out.println("Here are the available vehicles");
        ListAvailableVehicles();

        System.out.print("Enter the plate number of the vehicle you want to rent: ");
        String plateNum = scanner.next();
        scanner.nextLine();

        Vehicle selectedVehicle = null;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.plateNumber.equals(plateNum)) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Vehicle not found or invalid plate number");
            return;
        }

        if (!selectedVehicle.Available) {
            System.out.println("This vehicle is not available for rent");
            return;
        }

        System.out.println("This is your vehicle:");
        selectedVehicle.printInfo();
        System.out.println("The daily price of the vehicle is: $" + selectedVehicle.dailyPrice);

        if (selectedVehicle.getType().equals("Car")) {
            System.out.println("The electric car costs extra 5%");
        } else if (selectedVehicle.getType().equals("Motorcycle")) {
            System.out.println("The sidecar costs extra 2%");
        } else if (selectedVehicle.getType().equals("Truck")) {
            System.out.println("The refrigeration costs extra 5%");
        }

        System.out.println("Each late day of the return costs extra 10%");
        System.out.println(
                "If you rent a vehicle and return it before the return date, you still have to pay for the full contract days");

        ListAllCustomer();
        Customer contractCustomer = null;

        while (contractCustomer == null) {
            System.out.println("\nPress 1 to enter your ID");
            System.out.println("Press 2 to add yourself as a new customer");
            System.out.println("Press 3 to cancel rental");
            System.out.print("Your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Enter your ID: ");
                String ID = scanner.nextLine();

                boolean customerFound = false;
                for (Customer customer : customers) {
                    if (customer.ID.equals(ID)) {
                        contractCustomer = customer;
                        customerFound = true;
                        break;
                    }
                }

                if (!customerFound) {
                    System.out.println("Customer ID not found. Please try again or register as a new customer.");
                }

            } else if (choice == 2) {
                System.out.println("Please use the 'Add Customer' option from the main menu first.");
                System.out.println("Then come back to rent a vehicle.");
                return;

            } else if (choice == 3) {
                System.out.println("Rental cancelled.");
                return;

            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }

        String prefix = "";
        if (selectedVehicle.getType().equals("Car")) {
            prefix = "CAR";
        } else if (selectedVehicle.getType().equals("Motorcycle")) {
            prefix = "MTR";
        } else if (selectedVehicle.getType().equals("Truck")) {
            prefix = "TRK";
        }

        int number = contracts.size() + 101;
        String finalContractID = prefix + number;

        System.out.println("=== Rental Dates ===");
        System.out.print("Enter start date day: ");
        int startDateDay = scanner.nextInt();
        System.out.print("Enter start date month: ");
        int startDateMonth = scanner.nextInt();
        System.out.print("Enter start date year: ");
        int startDateYear = scanner.nextInt();
        scanner.nextLine();
        LocalDate rentStartDate = LocalDate.of(startDateYear, startDateMonth, startDateDay);

        System.out.print("Enter end date day: ");
        int endDateDay = scanner.nextInt();
        System.out.print("Enter end date month: ");
        int endDateMonth = scanner.nextInt();
        System.out.print("Enter end date year: ");
        int endDateYear = scanner.nextInt();
        scanner.nextLine();
        LocalDate rentEndDate = LocalDate.of(endDateYear, endDateMonth, endDateDay);

        int numOfRentDays = ((rentEndDate.getYear() * 365) + rentEndDate.getDayOfYear())
                - ((rentStartDate.getYear() * 365) + rentStartDate.getDayOfYear());

        if (numOfRentDays <= 0) {
            System.out.println("Error: End date must be after start date!");
            return;
        }

        double contractBasePrice = selectedVehicle.dailyPrice * numOfRentDays;

        selectedVehicle.Available = false;

        Contract contract = new Contract(finalContractID, selectedVehicle, contractCustomer,
                rentStartDate, numOfRentDays, contractBasePrice,
                rentEndDate, null, 0);
        contracts.add(contract);
        runningContracts.add(contract);

        System.out.println("Rental successful!");
        System.out.println("Contract ID: " + finalContractID);
        System.out.println("Total days: " + numOfRentDays);
        System.out.println("Base price: $" + contractBasePrice);
        System.out.println("Vehicle has been marked as unavailable.");
    }

    static void ReturnVehicle() {
        System.out.println("Enter contract ID");
        scanner.nextLine();
        String contractID = scanner.nextLine();
        boolean found = false;
        for (Contract contract : contracts) {
            if (contract.ID.equals(contractID)) {
                found = true;
                System.out.print("Enter the return date:");
                System.out.print("Day:");
                int returnDay = scanner.nextInt();
                System.out.print("Month:");
                int returnMonth = scanner.nextInt();
                System.out.print("Year:");
                int returnYear = scanner.nextInt();
                scanner.nextLine();

                LocalDate ReturnDate = LocalDate.of(returnYear, returnMonth, returnDay);

                if (((ReturnDate.getYear() * 365) + ReturnDate.getDayOfYear())
                        - ((contract.shouldReturnDate.getYear() * 365)
                                + contract.shouldReturnDate.getDayOfYear()) > 0) {
                    contract.numOfLateDays = ((ReturnDate.getYear() * 365) + ReturnDate.getDayOfYear())
                            - ((contract.shouldReturnDate.getYear() * 365)
                                    + contract.shouldReturnDate.getDayOfYear());
                    contract.actualReturnDate = ReturnDate;
                } else {
                    contract.actualReturnDate = ReturnDate;
                }

                int lateDays = ((ReturnDate.getYear() * 365) + ReturnDate.getDayOfYear())
                        - ((contract.shouldReturnDate.getYear() * 365) + contract.shouldReturnDate.getDayOfYear());
                if (lateDays > 0) {
                    contract.numOfLateDays = lateDays;
                    double startPrice = contract.basePrice + contract.vehicle.extraCost();
                    double startPriceWithDiscount = startPrice * (1 - contract.customer.getDiscountRate());
                    contract.fines = lateDays * startPriceWithDiscount * 0.1;
                } else {
                    contract.numOfLateDays = 0;
                    contract.fines = 0;
                }

                System.out.println("Final Bill");
                System.out.println("Base Cost: $" + contract.basePrice);
                System.out.println("Fines: $" + contract.fines);
                System.out.println("Final Cost: $" + contract.finalCost());
                balance += contract.finalCost();
                contract.customer.setNumberOfContracts(contract.customer.getNumberOfContracts() + 1);
                contract.vehicle.Available = true;
                runningContracts.remove(contract);
                endedContracts.add(contract);
                break;
            }
        }
        if (!found) {
            System.out.println("Couldn't find contract ID ");
        }
    }

    static void ListEndedContracts() {
        if (endedContracts.size() != 0) {
            for (Contract contract : endedContracts) {
                contract.printEndedContractsInfo();
            }
        } else {
            System.out.println("There are no ended contracts");
        }
    }

    static void ListRunningContracts() {
        if (runningContracts.size() != 0) {
            for (Contract contract : runningContracts) {
                contract.printRunningContractsInfo();
            }
        } else {
            System.out.println("There are no running contracts");
        }
    }

    static void displayCustomerContractsByName() {
        scanner.nextLine();
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        int i = 1;
        boolean found = false;
        boolean foundContracts = false;
        for (Customer customer : customers) {
            if (customer.Name.equalsIgnoreCase(name)) {
                found = true;
                for (Contract contract : contracts) {
                    if (contract.customer == customer) {
                        foundContracts = true;
                        System.out.println("Contract " + i + ":");
                        contract.displayContractInfo();
                        i++;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("The name dosen't exist");
        }
        if (!foundContracts) {
            System.out.println("The customer doesn't have any contracts");
        }
    }

    static void displayCustomerContractsByCompany() {
        int i = 1;
        boolean found = false;
        for (Contract contract : contracts) {
            if (contract.customer.getType().equals("Company")) {
                found = true;
                System.out.println("Contract " + i + ":");
                contract.displayContractInfo();
                i++;
            }
        }
        if (!found) {
            System.out.println("There are no contracts opened by a company");
        }
    }

    static void ListRentedvehicles() {
        int i = 1;
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.Available) {
                System.out.println("vehicle " + i + ":");
                vehicle.printInfo();
                i++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("There are no rented vehicles now");
        }
    }

    static void ListVehiclesWithFinesNow() {
        int i = 1;
        boolean found = false;
        for (Contract contract : runningContracts) {
            if (contract.shouldReturnDate.isBefore(LocalDate.now())) {
                System.out.println("vehicle " + i + ":");
                contract.vehicle.printInfo();
                i++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("There are no vehicles with fines now");
        }
    }

    static void ListRentedVehicleInSpecificTime() {
        boolean found = false;
        System.out.print("Enter the day of the First Date: ");
        int day1 = scanner.nextInt();
        System.out.print("Enter the day of the Second Date: ");
        int day2 = scanner.nextInt();
        System.out.print("Enter the month of the First Date: ");
        int month1 = scanner.nextInt();
        System.out.print("Enter the month of the Second Date: ");
        int month2 = scanner.nextInt();
        System.out.print("Enter the year of the First Date: ");
        int year1 = scanner.nextInt();
        System.out.print("Enter the year of the Second Date: ");
        int year2 = scanner.nextInt();
        scanner.nextLine();

        LocalDate firstDate = LocalDate.of(year1, month1, day1);
        LocalDate secondDate = LocalDate.of(year2, month2, day2);

        int i = 1;
        for (Contract contract : contracts) {
            if (contract.startDate.isAfter(firstDate)) {
                if (contract.startDate.isBefore(secondDate)) {
                    System.out.println("vehicle " + i + ":");
                    contract.vehicle.printInfo();
                    found = true;
                    i++;
                }
            }
        }
        if (!found) {
            System.out.println("There are no vehicles rented in this time");
        }
    }

    static void ListRentedMotorcyclesInSpecificTime() {
        boolean found = false;
        System.out.print("Enter the day of the First Date: ");
        int day1 = scanner.nextInt();
        System.out.print("Enter the day of the Second Date: ");
        int day2 = scanner.nextInt();
        System.out.print("Enter the month of the First Date: ");
        int month1 = scanner.nextInt();
        System.out.print("Enter the month of the Second Date: ");
        int month2 = scanner.nextInt();
        System.out.print("Enter the year of the First Date: ");
        int year1 = scanner.nextInt();
        System.out.print("Enter the year of the Second Date: ");
        int year2 = scanner.nextInt();
        scanner.nextLine();

        LocalDate firstDate = LocalDate.of(year1, month1, day1);
        LocalDate secondDate = LocalDate.of(year2, month2, day2);

        int i = 1;
        for (Contract contract : contracts) {
            if (contract.startDate.isAfter(firstDate)) {
                if (contract.startDate.isBefore(secondDate)) {
                    if (contract.vehicle.getType().equals("Motorcycle")) {
                        System.out.println("Motorcycle " + i + ":");
                        contract.vehicle.printInfo();
                        found = true;
                        i++;
                    }

                }
            }
        }
        if (!found) {
            System.out.println("There are no motorcycles rented in this time");
        }
    }

    static void ListCustomersWhoRentedSpecificVehicle() {
        scanner.nextLine();
        System.out.print("Enter vehicle Plate Number:");
        String plateNum = scanner.nextLine();
        int i = 1;
        boolean found = false;
        for (Contract contract : contracts) {
            if (contract.vehicle.plateNumber.equals(plateNum)) {
                System.out.println("Customer " + i + ":");
                contract.customer.printInfo();
                i++;
                found = true;
            }
        }
        if (!found) {
            System.out.println("This vehicle has not been rented");
        }
    }

    static void showBalance() {
        System.out.println("Balance: $" + balance);
    }

    static void ListVIPcustomers() {
        boolean found = false;
        int i = 1;
        for (Customer customer : customers) {
            if (customer.getNumberOfContracts() >= 5) {
                System.out.println("Customer " + i + ":");
                customer.printInfo();
                found = true;
                i++;
            }
        }
        if (!found) {
            System.out.println("There are no VIP customers");
        }
    }
}