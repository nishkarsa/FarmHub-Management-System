/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public class Farmer
{
    private int id;
    private String name;
    private String phone;
    private String address;
    private String status;   // Active / Inactive

    public Farmer(int id, String name, String phone, String address, String status) 
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
    }

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
