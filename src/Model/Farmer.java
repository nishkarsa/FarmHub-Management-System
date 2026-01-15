/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Represents a Farmer entity within the system.
 * This class stores farmer profile information.
 * @author Nishkarsa
 */
public class Farmer
{
    private final int id;
    private final String name;
    private final String phone;
    private final String address;
    private String status = "Active";   // Active / Inactive

    // Constructor
    public Farmer(int id, String name, String phone, String address, String status) 
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

    // Getter / Setter
    public int getId() 
    {
        return id; 
    }
    public String getName() 
    {
        return name; 
    }
    public String getPhone() 
    {
        return phone; 
    }
    public String getAddress() 
    {
        return address; 
    }
    public String getStatus() 
    {
        return status; 
    }

    public void setStatus(String status) 
    {
        this.status = status; 
    }
}
