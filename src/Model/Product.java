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
    private String category;   // Tool / Pesticide
    private long price;

    public Product(String name, String category, long price) 
    {
        this.name = name;
        this.category = category;
        this.price = price;
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
    public void setPrice(long price) 
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
}

