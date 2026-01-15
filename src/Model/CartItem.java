/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Represents an individual item within a shopping cart.
 * This class stores product details.
 * @author Nishkarsa
 */
public class CartItem 
{
    public String name;
    public double price;
    public int quantity;
    
    // Constructor
    public CartItem(String name, double price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getter
    public double getTotal()
    {
        return price * quantity;
    }
}
