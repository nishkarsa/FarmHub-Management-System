/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.util.Stack;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Model.*;
/**
 *
 * @author ACER
 */
public class CartController 
{
    private Stack<CartItem> cartStack = new Stack<>();
    private JTable cartTable;

    public CartController(JTable cartTable) {
        this.cartTable = cartTable;
    }

    // Add item to cart
    public void addToCart(String name, double price) {

        // Check if item already exists → increase quantity
        for (CartItem item : cartStack) {
            if (item.name.equals(name)) {
                item.quantity++;
                refreshTable();
                return;
            }
        }

        // Otherwise push new item
        cartStack.push(new CartItem(name, price, 1));
        refreshTable();
    }

    // Remove last added item (Undo)
    public void removeLastItem() {
        if (!cartStack.isEmpty()) {
            cartStack.pop();
            refreshTable();
        }
    }

    // Load stack into JTable
    private void refreshTable() {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.setRowCount(0);

        for (CartItem item : cartStack) {
            model.addRow(new Object[]{
                item.name,
                item.price,
                item.quantity,
                item.getTotal()
            });
        }
    }

    // Get Total Price
    public double getTotalPrice() 
    {
        double sum = 0;
        for (CartItem item : cartStack) 
        {
            sum += item.getTotal();
        }
        return sum;
    }
    
    public double getVAT() 
    {
    return getTotalPrice() * 0.13;
    }

    public double getTotalWithoutVAT() 
    {
        return getTotalPrice() - getVAT();
    }

    public boolean isCartEmpty() 
    {
        return cartStack.isEmpty();
    }
    
    public void clearCart() 
    {
        cartStack.clear();
        refreshTable();
    }
}


