package Test;
import java.util.ArrayList;

class Main {

// Contracts Management
public static void contractsManagementMenu() {
   boolean running = true;
  while(running){
   System.out.println("\"Contracts Management Section\"");
   System.out.println(
        "1- Show all contracts" 
      + "\n2- Contracts & Vehicles"
      + "\n3- Contracts & Customers"
      + "\n4- Back to previous menu"
    );
   running = choiceContractsManagementMenu();
   }
}

public static boolean choiceContractsManagementMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
  switch(choice) {
    case 1: 
      showAllContractsMenu();
      return true;
    case 2: 
      contractsAndVehiclesMenu();
      return true;
    case 3: 
      contractsAndCustomersMenu();       
      return true;
    case 4:        
      return false;
    default:
      return true;
  }
}

// Contracts Management - Show all contracts   
public static void showAllContractsMenu() {
  boolean running = true;
  while(running){
   System.out.println("Enter the contracts status to display in the console: ");
   System.out.println(
        "1- Active contracts" 
      + "\n2- Expired contracts"
      + "\n3- Back to previous menu"
    );
   running = choiceShowAllContracts();
   }
}

public static boolean choiceShowAllContracts() {
   int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 3);
 
  switch(choice) {
    case 1: 
      showActiveContracts();
      return true;
    case 2: 
      showExpiredContracts();
      return true;
    case 3: 
      return false;
    default:
      return true;
  }
}

public static void showActiveContracts() {

}
  
public static void showExpiredContracts() {

}

// Contracts Management - Contracts and Vehicle 
public static void contractsAndVehiclesMenu() {
  boolean running = true;
  while(running){
   System.out.println("Enter the ..... ");
   System.out.println(
        "1- Rented vehicles" 
      + "\n2- Vehicles with fines"
      + "\n3- Rented vehicles within a specific period"
      + "\n4- Back to previous menu"
    );
   running = choiceContractsAndVehiclesMenu();
   }
}
  
public static boolean choiceContractsAndVehiclesMenu() {
   int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
  switch(choice) {
    case 1: 
      rentedVehicles();
      return true;
    case 2: 
      vehiclesWithFines();
      return true;
    case 3: 
      rentedVehiclesWithinAspecificPeriod();
      return true;
    case 4: 
      return false;
    default:
      return true;
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
  boolean running = true;
  while(running){
   System.out.println("Enter the ..... ");
   System.out.println(
        "1- All contracts for a specific customer" 
      + "\n2- Show the customers who rented a specific car"
      + "\n3- Back to previous menu"
    );
   running = choiceContractsAndCustomersMenu();
   }
}
  
public static void choiceContractsAndCustomersMenu() {
   int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 3);
 
  switch(choice) {
    case 1: 
      contractsOfSpecificCustomerMenu();
      return true;
    case 2: 
      customerWhoRentedAspecificCar();
      return true;
    case 3: 
      customerWhoRentedAspecificCar();
      return false;
    default:
      return true;
  }
}

public static void contractsOfSpecificCustomerMenu() {

}
   
public static void customerWhoRentedAspecificCar() {

}

// Customers Management
public static void customersManagementMenu() {
   boolean running = true;
  while(running){
   System.out.println("\"Customers Management Section\"");
   System.out.println(
        "1- Add customer" 
      + "\n2- Search for a customer"
      + "\n3- Show all the customers"
      + "\n4- Edit a customer's data"
      + "\n5- Back to previous menu"
    );
   running = choiceCustomersManagementMenu();
   }
}

public static boolean choiceCustomersManagementMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 5);
 
  switch(choice) {
    case 1: 
      addCustomer();
      return true;
    case 2: 
      searchForCustomer();
      return true;
    case 3: 
      showCustomers();       
      return true;
    case 4: 
      editCustomer();
      return true;
    case 5: 
      return false;
    default:
      return true;
  }
}

public static void addCustomer() {

}

public static void searchForCustomer() {

}

public static void showCustomers() {

}

public static void editCustomer() {

}

   
// Vehicles Management
public static void vehiclesManagementMenu() {
   boolean running = true;
  while(running){
   System.out.println("\"Vehicles Management Section\"");
   System.out.println(
        "1- Add vehicle" 
      + "\n2- Remove vehicle"
      + "\n3- Show the available vehicles"
      + "\n4- Search for a vehicle"
      + "\n5- Show all vehicle"
      + "\n6- Back to previous menu"
    );
   running = choiceVehiclesManagementMenu();
   }
}

public static boolean choiceVehiclesManagementMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 6);
 
  switch(choice) {
    case 1: 
      addVehicle();
      return true;
    case 2: 
      removeVehicle();
      return true;
    case 3: 
      showTheAvailabeVehicles();       
      return true;
    case 4: 
      searchForVehicle();
      return true;
    case 5:
      showAllVehicles();
      return true;
    case 6:
      return false;
    default:
      return true;
  }
}

public static void addVehicle() {

}

public static void removeVehicle() {

}

public static void showTheAvailabeVehicles() {

}
   
public static void searchForVehicle() {

}
  
public static void showAllVehicles() {

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
mainMenu();



}
}
