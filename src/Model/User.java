/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ACER
 */
public abstract class User 
{
    protected int userId;
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    protected String role;
    
    public User()
    {
        
    }
    // Getter Methods
    public int getUserId()
    {
        return this.userId;
    }
    public String getName()
    {
        return this.name;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getPassword()
    {
        return this.password;
    }
    public String getPhone()
    {
        return this.phone;
    }
    public String getRole()
    {
        return this.role;
    }
    
    // Setter Moethods
    public void setUserId(int userId)
    {
        this.userId = userId;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    public void setRole(String role)
    {
        this.role = role;
    }
}
