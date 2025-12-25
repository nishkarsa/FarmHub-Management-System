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
public class ValidationController 
{
    public static boolean isEmpty(JTextField field, String name) {
        if (field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    name + " cannot be empty",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean isEmptyPassword(JPasswordField field) {
        if (String.valueOf(field.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Password cannot be empty",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return true;
        }
        return false;
    }
}
