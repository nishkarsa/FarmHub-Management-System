/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.*;

/**
 /**
 * The AuthController class manages the security gate of the application.
 * It validates user input from the login form and uses the NavigationController
 * to switch between different views (Admin or Farmer) based on successful login.
 * @author Nishkarsa
 */
public class AuthController 
{
    private NavigationController nav;

    // Constructor
    public AuthController(NavigationController nav) 
    {
        this.nav = nav;
    }

    /**
    * Handles user authentication based on role, username, and password.
    * Navigates to the appropriate panel if credentials are valid.
    * * @param role the JComboBox containing user roles (Admin/Farmer)
    * @param username the JTextField containing the entered username
    * @param password the JPasswordField containing the entered password
    */
    public void login(JComboBox<String> role, JTextField username, JPasswordField password) 
    {
        // Validation for empty fields
        if (username.getText().trim().equals("") || username.getText().equals("Username")) 
        {
            JOptionPane.showMessageDialog(null, "Username cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            username.requestFocus();
            return;
        }
    
        String pass = new String(password.getPassword());
        if (pass.equals("") || pass.equals("Password")) 
        {
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            password.requestFocus();
            return;
        }

        String selectedRole = role.getSelectedItem().toString();
        String user = username.getText().trim();

        // Credential Logic
        if (selectedRole.equals("Admin")) 
        {
            if (user.equals("admin") && pass.equals("admin")) 
            {
                nav.show("card3"); // Show Admin Panel
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Invalid Admin Credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }   
        } 
        else if (selectedRole.equals("Farmer")) 
        {
            if (user.equals("farmer") && pass.equals("farmer")) 
            {
                nav.show("card4"); // Show Farmer Panel
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Invalid Farmer Credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
