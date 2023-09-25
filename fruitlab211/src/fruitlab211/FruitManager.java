/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitlab211;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author dotha
 */
public class FruitManager {
    private final ArrayList<Fruit> fruits = new ArrayList<>();
    private final Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

    public void createFruit(int fruitId, String fruitName, double price, int quantity, String origin) {
        Fruit fruit = new Fruit(fruitId, fruitName, price, quantity, origin);
        fruits.add(fruit);
    }

    public void viewOrders() {
        for (String customer : orders.keySet()) {
            ArrayList<Fruit> customerOrder = orders.get(customer);
            System.out.println("Customer: " + customer);
            double totalAmount = 0.0;
            for (Fruit fruit : customerOrder) {
                System.out.println("Product | Quantity | Price | Amount");
                System.out.println(fruit.getFruitName() + "\t" + fruit.getQuantity() + "\t" +
                        fruit.getPrice() + "$\t" + (fruit.getQuantity() * fruit.getPrice()) + "$");
                totalAmount += fruit.getQuantity() * fruit.getPrice();
            }
            System.out.println("Total: " + totalAmount + "$\n");
        }
    }

  public void shop() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("List of Fruit:");
    System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |");
    int itemNumber = 1;
    for (Fruit fruit : fruits) {
        System.out.println("\t" + itemNumber + "\t" + fruit.getFruitName() + "\t" + fruit.getOrigin() +
                "\t" + fruit.getPrice() + "$");
        itemNumber++;
    }

    System.out.print("Select an item: ");
    int selectedItem = scanner.nextInt();
    scanner.nextLine(); 

    if (selectedItem < 1 || selectedItem > fruits.size()) {
        System.out.println("Invalid selection. Please choose a valid item.");
        return; 
    }

    Fruit selectedFruit = fruits.get(selectedItem - 1);

    System.out.print("Please input quantity: ");
    int quantity = scanner.nextInt();
    scanner.nextLine(); 

    if (quantity <= 0) {
        System.out.println("Invalid quantity. Please enter a positive quantity.");
        return; 
    }

    double amount = selectedFruit.getPrice() * quantity;
    System.out.println("Product | Quantity | Price | Amount");
    System.out.println(selectedFruit.getFruitName() + "\t" + quantity + "\t" +
            selectedFruit.getPrice() + "$\t" + amount + "$");

    System.out.print("Do you want to order now (Y/N): ");
    String orderChoice = scanner.nextLine();
    if (orderChoice.equalsIgnoreCase("Y")) {
        System.out.print("Input your name: ");
        String customerName = scanner.nextLine();

        ArrayList<Fruit> customerOrder = orders.getOrDefault(customerName, new ArrayList<>());
        customerOrder.add(new Fruit(selectedFruit.getFruitId(), selectedFruit.getFruitName(),
                selectedFruit.getPrice(), quantity, selectedFruit.getOrigin()));
        orders.put(customerName, customerOrder);

        
        selectedFruit.setQuantity(selectedFruit.getQuantity() - quantity);

        System.out.println("Order placed successfully!");
    }
}

}