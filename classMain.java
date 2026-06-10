import java.util.ArrayList;

class Main {

public static boolean choiceMainMenu(){
  int choice = SafeInput.readIntRange("Enter the number of the service which you want: , 1, 4);
 
  switch(choice) {
    case 1: 
      vehiclesManagementMenu();
      break;
    case 2: 
      customersManagementMenu();
      break;
    case 3: 
      contractsManagementMenu();
      break;
    case 4: 
      System.out.println("Thanks for your time!");
      return false;
  }
}

public static void mainMenu() {
  boolean running = true;
  while(running){
   System.out.println("Welcome to our System, \nWhich service do you need?");
   System.out.println("1- Vehicles Management  \n
                       2- Customers Management \n
                       3- Contracts Management \n
                       4- Exit the Program     \n
    ");
   }
   running = choiceMainMenu();
}


public static void main(String[] args) {
mainMenu();



}
