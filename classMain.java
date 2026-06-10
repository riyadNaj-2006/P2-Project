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
    );
   running = choiceContractsManagementMenu();
   }
}

public static boolean choiceContractsManagementMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 3);
 
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
    default:
      return true;
}
  
public static void showAllContractsMenu() {
  boolean running = true;
  while(running){
   System.out.println("Enter the contracts status to display in the console: ");
   System.out.println(
        "1- Active contracts" 
      + "\n2- Expired contracts"
    );
   running = choiceShowAllContracts();
   }
}

public static boolean choiceShowAllContracts() {
   int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
  switch(choice) {
    case 1: 
      showActiveContracts();
      return true;
    case 2: 
      showExpiredContracts();
      return true;
    default:
      return true;
}

public static void showActiveContracts() {

}
  
public static void showExpiredContracts() {

}

public static void contractsAndVehiclesMenu() {
  boolean running = true;
  while(running){
   System.out.println("Enter the ..... ");
   System.out.println(
        "1- Rented vehicles" 
      + "\n2- Vehicles with fines"
      + "\n3- Rented vehicles within a specific period"
    );
   running = choiceContractsAndVehiclesMenu();
   }
}
  
public static void choiceContractsAndVehiclesMenu() {
   int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 3);
 
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
    default:
      return true;
}

public static void rentedVehicles() {

}
  
public static void vehiclesWithFine() {

}
  
public static void rentedVehiclesWithinAspecificPeriod() {

}

// Customers Management
public static void addCustomer() {

}

public static void searchForCustomer() {

}

public static void showCustomers() {

}

public static void editCustomer() {

}
  
public static boolean choiceCustomersManagementMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
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
    default:
      return true;
}
  
public static void customersManagementMenu() {
   boolean running = true;
  while(running){
   System.out.println("\"Customers Management Section\"");
   System.out.println(
        "1- Add customer" 
      + "\n2- Search for a customer"
      + "\n3- Show all the customers"
      + "\n4- Edit a customer's data"
    );
   running = choiceCustomersManagementMenu();
   }

}


// Vehicles Management
public static void searchForVehicle() {

}
  
public static void showVehicles() {

}
  
public static void removeVehicle() {

}
  
public static void addVehicle() {

}

public static boolean choiceVehiclesManagementMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
  switch(choice) {
    case 1: 
      addVehicle();
      return true;
    case 2: 
      removeVehicle();
      return true;
    case 3: 
      showVehicles();       
      return true;
    case 4: 
      searchForVehicle();
      return true;
    default:
      return true;
}
  
public static void vehiclesManagementMenu() {
   boolean running = true;
  while(running){
   System.out.println("\"Vehicles Management Section\"");
   System.out.println(
        "1- Add vehicle" 
      + "\n2- Remove vehicle"
      + "\n3- Show the vvailable vehicles"
      + "\n4- Search for a vehicle"
    );
   running = choiceVehiclesManagementMenu();
   }

}

// MAIN MENU
public static boolean choiceMainMenu() {
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: ", 1, 4);
 
  switch(choice) {
    case 1: 
      vehiclesManagementMenu();
      return true;
    case 2: 
      customersManagementMenu();
      return true;
    case 3: 
       System.out.println("contractsManagementMenu()");      
      return true;
    case 4: 
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
      + "\n4- Exit the Program"
    );
   running = choiceMainMenu();
   }
}


public static void main(String[] args) {
mainMenu();



}
}
