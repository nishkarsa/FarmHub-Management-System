/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.util.Stack;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.CartItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the shopping cart operations using a Stack data structure.
 * Handles adding items, removing items (undo), and calculating totals.
 * @author Nishkarsa
 */
public class CartController 
{
    private List<CartItem> cartList = new ArrayList<>();
    private JTable cartTable;

    public CartController(JTable cartTable) 
    {
        this.cartTable = cartTable;
    }

    /**
     * Adds a product to the cart. If the product already exists, it increases 
     * the quantity; otherwise, it pushes a new item onto the stack.
     * * @param name the name of the product
     * @param price the price of the product
     */
    public void addToCart(String name, double price) 
    {
        // Check if the item already exists in our list
        for (int i = 0; i < cartList.size(); i++) 
        {
            CartItem item = cartList.get(i);
            if (item.name.equals(name)) 
            {
                item.quantity = item.quantity + 1;
                refreshTable();
                return;
            }
        }

        // for new item we add it to the stack
        cartList.add(new CartItem(name, price, 1));
        refreshTable();
    }

    /**
     * Removes the most recently added item from the cart (Undo functionality).
     */
    public void removeLastItem() 
    {
        // Check for underflow
        if (cartList.size() > 0) 
        {
            // Remove the item at the very last index (size - 1) LIFO
            int lastIndex = cartList.size() - 1;
            cartList.remove(lastIndex);
            refreshTable();
        }
    }

    /**
     * Updates the JTable display to match the current data in our list.
     */
    private void refreshTable() 
    {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        // Clear all existing rows in the table
        model.setRowCount(0);

        // Loop through the list and add each item to the table UI
        for (int i = 0; i < cartList.size(); i++) 
        {
            CartItem item = cartList.get(i);
            model.addRow(new Object[]{
                item.name,
                item.price,
                item.quantity,
                item.getTotal()
            });
        }
    }

    /**
     * adds all item price in the stack
     */
    public double getTotalPrice() 
    {
        double sum = 0;
        for (int i = 0; i < cartList.size(); i++) 
        {
            sum = sum + cartList.get(i).getTotal();
        }
        return sum;
    }
    
    /**
     * calculates VAT from the total price
     */
    public double getVAT() 
    {
    return getTotalPrice() * 0.13;
    }

    /**
     * subtracts VAT from the total price
     */
    public double getTotalWithoutVAT() 
    {
        return getTotalPrice() - getVAT();
    }

    /**
     * Checks if the cart has no items.
     */
    public boolean isCartEmpty() 
    {
        // If size is 0, it means the cart is empty
        if (cartList.size() == 0) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    /**
     * Removes all items from the list.
     */
    public void clearCart() 
    {
        cartList.clear();
        refreshTable();
    }
}


