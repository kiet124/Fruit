/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fruitlab211;

/**
 *
 * @author dotha
 */
public class Fruit {
    private int fruitId;
    private final String fruitName;
    private final double price;
    private int quantity;
    private final String origin;

    public Fruit(int fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    public int getFruitId() {
        return fruitId;
    }

    public String getFruitName() {
        return fruitName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Quantity is sold out and cannot be ordered.");
        }
    }
}
