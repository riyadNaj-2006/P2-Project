import java.util.ArrayList;

class Main {

public static String choiceMainMenu(){
  while(true) {
    Char choice = SafeInput.readChar("Enter the number of the service which you want: );
     if(Char == '1' || Char == '2' || Char == '3' || Char == '4')
       return;
      else
        System.out.println("Error: You only have 4 choices!");
   }

  switch(choice) {
    case '1': vehiclesManagementMenu();
    case '2': customersManagementMenu();
    case '3': contractsManagementMenu();
    case '4':
      
   
  }
}

public static void mainMenu(){
  System.out.println("Welcome to our System, \nWhich service do you need?");
  System.out.println("1- Vehicles Management  \n
                      2- Customers Management \n
                      3- Contracts Management \n
                      4- Exit the Program     \n
  ");
  choiceMainMenu();
}


public static void main(String[] args) {
mainMenu();



}
