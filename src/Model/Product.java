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
    private int productId;
    private String productName;
    private String category;    // It can be pesticide, tools or seeds for sale
    private double price;
    private int stockQuantity;
    private String usageInstruction;
    
    // Getter Methods
    public int getProductId()
    {
        return this.productId;
    }
    public String getProductName()
    {
        return this.productName;
    }
    public String getCategory()
    {
        return this.category;
    }
    public double getPrice()
    {
        return this.price;
    }
    public int getStockQuantity()
    {
        return this.stockQuantity;
    }
    public String getUsageInstruction()
    {
        return this.usageInstruction;
    }
    
    // Setter Methods
    public void setProductId(int productId)
    {
        this.productId = productId;
    }
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void setStockQuantity(int stockQuantity)
    {
        this.stockQuantity = stockQuantity;
    }
    public void setUsageInstruction(String usageInstruction)
    {
        this.usageInstruction = usageInstruction;
    }
}
