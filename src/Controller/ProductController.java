/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import Model.*;

/**
 *
 * @author ACER
 */
public class ProductController 
{
    private static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Product p) 
    {
        products.add(p);
    }

    public static ArrayList<Product> getAllProducts() 
    {
        return products;
    }

    public static void updateProduct(int index, Product updated) 
    {
        products.set(index, updated);
    }

    public static Product getProduct(int index) 
    {
        return products.get(index);
    }
}
