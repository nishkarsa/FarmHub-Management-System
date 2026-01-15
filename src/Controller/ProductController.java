/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import Model.Product;

/**
 * The ProductController class manages the collection of products in the system.
 * It provides methods to add, retrieve, and update product information.
 * @author Nishkarsa
 */
public class ProductController 
{
    // // A static list to store all products.
    private static ArrayList<Product> products = new ArrayList<>();

    /**
     * Adds a new product object to the list.
     * @param p The Product object to be stored.
     */
    public static void addProduct(Product p) 
    {
        products.add(p);
    }
    
    /**
     * Retrieves the entire list of products.
     * @return An ArrayList containing all added products.
     */
    public static ArrayList<Product> getAllProducts() 
    {
        return products;
    }
    
    /**
     * Replaces an existing product at a specific position with updated information.
     * @param index The numerical position (starting from 0) of the product to change.
     * @param updated The new Product object to put in that position.
     */
    public static void updateProduct(int index, Product updated) 
    {
        // set() replaces the item at the given index
        products.set(index, updated);
    }
    
    /**
     * Finds and returns a single product based on its position in the list.
     * @param index The numerical position of the product.
     * @return The Product object found at that index.
     */
    public static Product getProduct(int index) 
    {
        return products.get(index);
    }
}
