/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class Farmer extends User
{
    private String location;
    private String farmType;    // Farm type can be crop, livestock or mixed
    
    // Constructor
    public Farmer()
    {
        this.role = "Farmer";
    }
    
    // Getter Methods
    public String getLocation()
    {
        return this.location;
    }
    public String getFarmType()
    {
        return this.farmType;
    }
    
    // Setter Methods
    public void setLocation(String location)
    {
        this.location = location;
    }
    public void setFarmType(String farmType)
    {
        this.farmType = farmType;
    }
}
