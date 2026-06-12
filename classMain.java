import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

class Main {
  
  static Scanner scanner = new Scanner(System.in);
    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Contract> contracts = new ArrayList<>();
    static ArrayList<Contract> runningContracts = new ArrayList<>();
    static ArrayList<Contract> endedContracts = new ArrayList<>();
    static double balance = 100000;

// Reports and Statistics
public static void contractsAndVehiclesMenu() {

  while(true){
   System.out.println("Enter the ..... ");
   System.out.println(
        "1- Company revenues" 
      + "\n2- Most rented vehicles"
      + "\n3- VIP customers"
      + "\n4- Back to previous menu"
    );
  
     int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
     switch(choice) {
       case 1: 
         companyRevenues();
         break;
       case 2: 
         mostRentedVehicles();
         break;
       case 3: 
         vipCustomers();
         break;
       case 4: return;
     }
  }
}

public static void companyRevenues() {

}
  
public static void mostRentedVehicles() {

}
  
public static void vipCustomers() {

}

// Contracts Management
public static void contractsManagementMenu() {
  
  while(true){
    System.out.println("\"Contracts Management Section\"");
    System.out.println(
        "1- Show all contracts" 
      + "\n2- Contracts & Vehicles"
      + "\n3- Contracts & Customers"
      + "\n4- Back to previous menu"
     );

     int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
     switch(choice) {
       case 1: 
         showAllContractsMenu();
         break;
       case 2: 
         contractsAndVehiclesMenu();
         break;
       case 3: 
         contractsAndCustomersMenu();       
         break;
       case 4: return;
     }

   }
}

// Contracts Management - Show all contracts   
public static void showAllContractsMenu() {
  
  while(true){
   System.out.println("Enter the contracts status to display in the console: ");
   System.out.println(
        "1- Active contracts" 
      + "\n2- Expired contracts"
      + "\n3- Back to previous menu"
    );
  
     int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 3);
 
     switch(choice) {
        case 1: 
          showActiveContracts();
          break;
        case 2: 
          showExpiredContracts();
          break;
        case 3: return;
      }

   }
}

public static void showActiveContracts() {

}
  
public static void showExpiredContracts() {

}

// Contracts Management - Contracts and Vehicle 
public static void contractsAndVehiclesMenu() {

  while(true){
   System.out.println("Enter the ..... ");
   System.out.println(
        "1- Rented vehicles" 
      + "\n2- Vehicles with fines"
      + "\n3- Rented vehicles within a specific period"
      + "\n4- Back to previous menu"
    );
  
     int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
     switch(choice) {
       case 1: 
         rentedVehicles();
         break;
       case 2: 
         vehiclesWithFines();
         break;
       case 3: 
         rentedVehiclesWithinAspecificPeriod();
         break;
       case 4: return;
     }
  }
}

public static void rentedVehicles() {

}
  
public static void vehiclesWithFine() {

}
  
public static void rentedVehiclesWithinAspecificPeriod() {

}

// Contracts Management - Contracts and Customers
public static boolean contractsAndCustomersMenu() {
  while(true){
   System.out.println("Enter the ..... ");
   System.out.println(
        "1- All contracts for a specific customer" 
      + "\n2- Show the customers who rented a specific car"
      + "\n3- Back to previous menu"
    );
   
     int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 3);
 
  switch(choice) {
    case 1: 
      contractsOfSpecificCustomerMenu();
      break;
    case 2: 
      customerWhoRentedAspecificCar();
      break
    case 3: 
      return;
    }
  }
}
  
public static void contractsOfSpecificCustomerMenu() {

}
   
public static void customerWhoRentedAspecificCar() {

}

// Customers Management
public static void customersManagementMenu() {
  
  while(true){
   System.out.println("\"Customers Management Section\"");
   System.out.println(
        "1- Add customer" 
      + "\n2- Search for a customer"
      + "\n3- Show all the customers"
      + "\n4- Edit a customer's data"
      + "\n5- Back to previous menu"
    );
   
     int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 5);
 
  switch(choice) {
    case 1: 
      addCustomer();
      break;
    case 2: 
      searchForCustomer();
      break;
    case 3: 
      showCustomers();       
      break;
    case 4: 
      editCustomer();
      break;
    case 5: 
      return;
    }
  }
}

public static void addCustomer() {
    int type;
        System.out.println
        type = SafeInput.readIntRange("Enter customer type: 1-Individual \n2-Company",1,2);
        scanner.nextLine();
  
        System.out.println("Fill the following form:");
  
        String ID = SafeInput.readNumericString("ID: "); // edittttt
  
        String name = SafeInput.readString("Name: ");
  
        System.out.print("Address: ");
        String address = SafeInput.readString("Name: ");
  
        String phoneNumber = SafeInput.readString("Phone Number: ");

        Customer customer = null;

        switch (type) {
            case 1:
                String license = SafeInput.readString("Driving License Number: ");
                LocalDate birth = SafeInput.readDate("Birth Date");
                customer = new Individual(ID, name, address, phoneNumber, 0, license, birth);
                break;

            case 2:
                String commercialRegistrationNumber = SafeInput.readNumericString("Commercial Registration Number: ");
                double discountPercentage =  SafeInput.readDouble("Discount Percentage: ");
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

public static void searchForCustomer() {
        String ID = SafeInput.readString("Enter customer ID: "); //  edittttt
        scanner.nextLine();
  
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.ID.equals(ID)) {
                customer.printinfo();
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Customer not found");
        }
}

public static void showCustomers() {
  if (customers.size() != 0) {
            for (int i = 0; i < customers.size(); i++) {
                customers.get(i).printinfo();
                System.out.println();
            }
        } else {
            System.out.println("There are no customers");
        }
}

public static void editCustomer() {
        String ID = SafeInput.readNumericString("Enter Customer ID to update: ");
        scanner.nextLine();
  
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.ID.equals(ID)) {
                found = true;
                System.out.println("Current customer info:");
                customer.printinfo();
                System.out.println("Enter new info, or leave blank to keep current info");
                String newName = SafeInput.readString("New name: ");
                if (!newName.isEmpty()) {
                    customer.Name = newName;
                }
                String newAddress = SafeInput.readNumericString("Address: ");
                if (!newAddress.isEmpty()) {
                    customer.Address = newAddress;
                }
                String newPhoneNumber = SafeInput.readNumericString("Phone Number: ");
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

   
// Vehicles Management
public static void vehiclesManagementMenu() {
  
  while(true){
   System.out.println("\"Vehicles Management Section\"");
   System.out.println(
        "1- Add vehicle" 
      + "\n2- Remove vehicle"
      + "\n3- Show the available vehicles"
      + "\n4- Search for a vehicle"
      + "\n5- Show all vehicle"
      + "\n6- Back to previous menu"
    );
   
    int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 6);
 
  switch(choice) {
    case 1: 
      addVehicle();
      break;
    case 2: 
      removeVehicle();
      break;
    case 3: 
      showTheAvailabeVehicles();       
      break;
    case 4: 
      searchForVehicle();
      break;
    case 5:
      showAllVehicles();
      break;
    case 6:
      return;
    }
  }
}

public static void addVehicle() {
  int type;
        System.out.println();
        type = SafeInput.readIntRange("Enter vehicle type: 1-Car \n2-Motorcycle \n3-Truck", 1, 3);
        scanner.nextLine();
  
        System.out.println("Fill the following form:");
        
        String plateNumber = SafeInput.readNumericString("Plate Number: ");
        
        String brand = SafeInput.readNumericString("Brand: ");
  
        String model = SafeInput.readNumericString("Model: ");

        double dailyPrice = SafeInput.readDouble("Daily Price: ");
        scanner.nextLine();
  
        boolean available = SafeInput.readBoolean("Available (true/false): ");
        scanner.nextLine();

        Vehicle vehicle = null;

        switch (type) {
            case 1:
                String fuelType = SafeInput.readString("Fuel Type (petrol/diesel/electric): ");
                int numOfSeats = SafeInput.readInt("Number of Seats: ");
                scanner.nextLine();
                boolean AC = SafeInput.readBoolean("Air Condition (true/false): ");
                scanner.nextLine();
                vehicle = new Car(plateNumber, brand, model, dailyPrice, available, fuelType, numOfSeats, AC);
                break;
            
            case 2:
                double engineCapacity = SafeInput.readDouble("Engine Capacity (CC): ");
                scanner.nextLine();
                boolean sidecarAvailability = SafeInput.readBoolean("Sidecar Availability (true/false): ");
                scanner.nextLine();
                vehicle = new Motorcycle(plateNumber, brand, model, dailyPrice, available, engineCapacity,
                        sidecarAvailability);
                break;
            
            case 3:
                double load = SafeInput.readDouble("Load Capacity (KG): ");
                scanner.nextLine();
                boolean fridge = SafeInput.readBoolean("Refrigeration Support (true/false): ");
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

}

public static void removeVehicle() {
        String plateNum = SafeInput.readNumericString("Enter vehicle plate number to remove: ");
        scanner.nextLine();
  
        boolean removed = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).PlateNumber.equals(plateNum)) {
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

public static void showTheAvailabeVehicles() {
   boolean found = false;
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).Available) {
                vehicles.get(i).printinfo();
                found = true;
                System.out.println();
            }
        }
        if (!found) {
            System.out.println("There are no available vehicles");
        }
}
   
public static void searchForVehicle() { // editttttttt
        String plateNum = SafeInput.readNumericString("Enter plate number: ");
        scanner.nextLine();
  
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.PlateNumber.equals(plateNum)) {
                vehicle.printinfo();
                found = true;
                break;
            }
        }
        if (found == false) {
            System.out.println("Vehicle not found");
        }
}
  
public static void showAllVehicles() {
  if (vehicles.size() != 0) {
            for (int i = 0; i < vehicles.size(); i++) {
                vehicles.get(i).printinfo();
                System.out.println();
            }
        } else {
            System.out.println("There are no vehicles");
        }
}
   
// MAIN MENU
public static boolean choiceMainMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 5);
 
  switch(choice) {
    case 1: 
      vehiclesManagementMenu();
      return true;
    case 2: 
      customersManagementMenu();
      return true;
    case 3: 
      contractsManagementMenu();     
      return true;
    case 4: 
      reportsAndStatistics();
      return true;
    case 5: 
      System.out.println("Exit Successful.");
      return false;
    default:
      return true;
  }
}

public static void mainMenu() {
  boolean running = true;
  while(running){
   System.out.println("Welcome to our System\nWhich service do you need?");
   System.out.println(
        "1- Vehicles Management" 
      + "\n2- Customers Management"
      + "\n3- Contracts Management"
      + "\n4- Reports and Statistics"
      + "\n5- Exit the Program"
    );
   running = choiceMainMenu();
   }
}


public static void main(String[] args) {

   vehicles.add(new Car("007568", "Toyota", "Camry", 50, true, "petrol", 5, true));
        vehicles.add(new Car("007345", "Tesla", "Model 3", 42, true, "electric", 5, true));
        vehicles.add(new Motorcycle("006578", "Harley", "Davidson", 35, true, 1200, true));
        vehicles.add(new Motorcycle("002348", "Kawasaki", "Ninja H2R", 190, true, 998, false));
        vehicles.add(new Truck("005364", "Volvo", "FH16", 90, true, 8000, true));

        customers.add(
          new Individual("0066", "Yessayie", "Damascus", "0994 592 915", 0, "06001237",
              LocalDate.of(2007, 7, 13)));
        customers.add(
          new Company("0024", "Cham City Center", "Damascus", "011 562 8889", 0, 23, "CCDU7782"));

        mainMenu();

}
}
