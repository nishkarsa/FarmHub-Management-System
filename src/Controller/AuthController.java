/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.*;

/**
 *
 * @author ACER
 */
public class AuthController 
{
    private NavigationController nav;

    public AuthController(NavigationController nav) {
        this.nav = nav;
    }

    public void login(JComboBox<String> role, JTextField username, JPasswordField password) {
        // 1. Validation
        if (ValidationController.isEmpty(username, "Username")) return;
        if (ValidationController.isEmptyPassword(password)) return;

        String selectedRole = role.getSelectedItem().toString();
        String user = username.getText().trim();
        String pass = new String(password.getPassword());

        // 2. Logic (Replace with Database check later)
        if (selectedRole.equals("Admin")) {
            // These strings MUST match the "Card Name" property in NetBeans Design tab
            nav.show("card3"); // This is AdminPanel in your provided Main.java
        } else if (selectedRole.equals("Farmer")) {
            nav.show("card4"); // This is FarmerPanel in your provided Main.java
        }
    }

    public void registerFarmer(JTextField name, JTextField username, JPasswordField password, JTextField contact) {
        if (ValidationController.isEmpty(name, "Full Name")) return;
        if (ValidationController.isEmpty(username, "Username")) return;
        if (ValidationController.isEmptyPassword(password)) return;
        if (ValidationController.isEmpty(contact, "Contact")) return;

        // Save logic here...
        
        JOptionPane.showMessageDialog(null, "Registration Successful!");
        nav.show("card6"); // Navigate back to the Auth/Login container
    }
}
