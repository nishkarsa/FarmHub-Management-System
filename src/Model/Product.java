/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */

public class Product 
{
    private String name;
    private double price;
    private String category;   // Tool / Pesticide
    private String imagePath;

    public Product(String name, double price, String category, String imagePath) 
    {
        this.name = name;
        this.price = price;
        this.category = category;
        this.imagePath = imagePath;
    }

    // getters & setters
    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) 
    {
        this.name = name; 
    }

    public double getPrice() 
    {
        return price; 
    }
    public void setPrice(double price) 
    {
        this.price = price; 
    }

    public String getCategory() 
    {
        return category; 
    }
    public void setCategory(String category) 
    {
        this.category = category; 
    }

    public String getImagePath() 
    {
        return imagePath; 
    }
    public void setImagePath(String imagePath) 
    {
        this.imagePath = imagePath; 
    }
}

