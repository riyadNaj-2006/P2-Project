package Test;

import java.util.ArrayList;

class Main {

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
       System.out.println("customersManagementMenu()");
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
