/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fruitlab211;

import java.util.Scanner;

/**
 *
 * @author dotha
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FruitManager fruitManager = new FruitManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Please choose an option (1/2/3/4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Fruit Id: ");
                    int fruitId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Fruit Name: ");
                    String fruitName = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); 
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Origin: ");
                    String origin = scanner.nextLine();
                    fruitManager.createFruit(fruitId, fruitName, price, quantity, origin);
                    System.out.print("Do you want to continue (Y/N)? ");
                    String continueChoice = scanner.nextLine();
                    if (!continueChoice.equalsIgnoreCase("Y")) {
                        break;
                    }
                    break;
                case 2:
                    fruitManager.viewOrders();
                    break;
                case 3:
                    fruitManager.shop();
                    break;
                case 4:
                    System.out.println("Exiting program. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a valid option (1/2/3/4).");
            }
        }
    }
}
