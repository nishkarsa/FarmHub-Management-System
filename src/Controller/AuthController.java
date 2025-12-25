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

    public void login(JComboBox<String> role,
                      JTextField username,
                      JPasswordField password) {

        if (ValidationController.isEmpty(username, "Username")) return;
        if (ValidationController.isEmptyPassword(password)) return;

        String selectedRole = role.getSelectedItem().toString();

        // Temporary logic
        if (selectedRole.equals("Admin")) {
            nav.show("admin");
        } else {
            nav.show("farmer");
        }
    }

    public void registerFarmer(JTextField name,
                               JTextField username,
                               JPasswordField password,
                               JTextField contact) {

        if (ValidationController.isEmpty(name, "Full Name")) return;
        if (ValidationController.isEmpty(username, "Username")) return;
        if (ValidationController.isEmptyPassword(password)) return;
        if (ValidationController.isEmpty(contact, "Contact")) return;

        // Save logic later
        nav.show("login");
    }
}
