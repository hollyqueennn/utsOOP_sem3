import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main{

    static ArrayList<Animal> animalList = new ArrayList<Animal>();

    public static void menuZoo(){

        System.out.println("| --------------------------------------------- |");
        System.out.println("|       > > > Zoo Management System < < <       |");
        System.out.println("| --------------------------------------------- |");
        System.out.println("|                1. Input Data                  |");
        System.out.println("|                2. Delete Data                 |");
        System.out.println("|                3. Delete All Data             |");
        System.out.println("|                4. Show All Zoo Data           |");
        System.out.println("|                5. Exit                        |");
        System.out.println("| --------------------------------------------- |");
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int menu;

        do{
            menuZoo();
            System.out.print(" => ");
            menu = scan.nextInt();
            scan.nextLine();

            switch (menu){
                case 1:
                    inputData();
                    break;
                case 2:
                    deleteData();
                    break;
                case 3:
                    deleteAllData();
                    break;
                case 4:
                    showAllData();
                    break;
                case 5:
                    exitProgram();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        } while (menu != 5);
    }

    // Input Function
    private static void inputData(){

        Scanner scan = new Scanner(System.in);
        Integer id, typeofAnimal, quantity, yearofArrival = null;
        String animalName = null;

        // ID
        System.out.print("ID (001 - 020) : ");
        id = scan.nextInt();
        scan.nextLine();
        while (id < 1 || id > 20){
            System.out.println("Your Input is Invalid");
            System.out.print("ID (001 - 020) : ");
            id = scan.nextInt();
            scan.nextLine();
        }

        // Animal Name
        System.out.print("Animal Name : ");
        animalName = scan.nextLine();

        // Type Of Animal
        System.out.print("Type of Animal : ");
        typeofAnimal = scan.nextInt();
        scan.nextLine();
        if (typeofAnimal == 0 || typeofAnimal == 1){
            System.out.println(typeofAnimal + " LEG");
        } else if (typeofAnimal > 1) {
            System.out.println(typeofAnimal + " LEGS");
        }

        // Quantity
        System.out.print("Quantity : ");
        quantity = scan.nextInt();
        scan.nextLine();

        while (quantity < 1 || quantity > 10){
            System.out.println("Your Input is Invalid");
            System.out.print("Quantity : ");
            quantity = scan.nextInt();
            scan.nextLine();
        }

        // Year Of Arrival
        System.out.print("Year of Arrival : ");
        yearofArrival = scan.nextInt();
        scan.nextLine();

        while (yearofArrival < 2000 || yearofArrival > 2020){
            System.out.println("Your Input is Invalid");
            System.out.print("Year Of Arrival : ");
            yearofArrival = scan.nextInt();
            scan.nextLine();
        }
        Animal anName = new Animal(id, typeofAnimal, quantity, yearofArrival, animalName);
        animalList.add(anName);
    }

    // Delete Function
    private static void deleteData(){
		
		if(animalList.isEmpty()){
			System.out.println("Your list is empty");
			return;
		}
		
		Scanner scan = new Scanner(System.in);
		int deleteID, deleteQuantity;
		
		System.out.print("Enter ID : ");
		deleteID = scan.nextInt(); scan.nextLine();
		System.out.print("Enter Quantity: ");
		deleteQuantity = scan.nextInt(); scan.nextLine();
		for(Animal animal : animalList){
			if(animal.id.equals(deleteID) && animal.quantity.equals(deleteQuantity)){
				animalList.remove(animal);
				break;
			}
			else if(animal.id.equals(deleteID) && animal.quantity >= deleteQuantity){
				animal.quantity -= deleteQuantity;
				break;
			}			
		}
    }

    // Delete All Data Function
    private static void deleteAllData(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Are you sure want to delete all data?");
        char delete;
        delete = scan.next().charAt(0);
        switch(delete){
    	        case 'y':
    	            animalList.clear();
    	            System.out.println("Your data is clear");
    	            break;
    	        case 'n':
					System.out.println("Deletion Canceled");
    	            return;
    	    }
    	}
    	
    //Show Data Function
    private static void showAllData(){
    	   
    	int i, j, size = animalList.size();
    	    
    	for(i = 0; i < size; i++){
    	    for(j = 0; j < size-i-1; j++){
    	        if(animalList.get(j).id > animalList.get(j+1).id){
    	            Collections.swap(animalList, j, j+1);
    	        }
    	    }
    	}
    	    
    	if(animalList.isEmpty()){
			System.out.println("List is Empty!");
			return;
		}
    	    
    	System.out.println("===================================================================================================");
	    System.out.println("|  ID  |      Animal Name      | Animal Type | Quantity | Animal Arrival | Animal Checking Status |");
		System.out.println("===================================================================================================");
    	    
    	for(Animal animal : animalList){
    	    System.out.printf("| %03d  | %-21s | %-11s | %-8d | %-14d | %-22s |\n", animal.id, animal.animalName, animal.typeofAnimal, animal.quantity, animal.yearofArrival, animal.checkStatus);
    	}

		System.out.println("===================================================================================================");
    	  
    }
    	
    //Exit Program Function
    public static void exitProgram(){
    	System.out.println("Thank You!");
    }
}