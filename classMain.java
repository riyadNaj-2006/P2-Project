package Test;
import java.util.ArrayList;

class Main {

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

}

public static void searchForCustomer() {

}

public static void showCustomers() {

}

public static void editCustomer() {

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
