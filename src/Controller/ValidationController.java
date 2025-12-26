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
        if (field.getText().trim().isEmpty() || field.getText().equals(name)) {
            JOptionPane.showMessageDialog(null, name + " cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean isEmptyPassword(JPasswordField field) {
        if (String.valueOf(field.getPassword()).trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return true;
        }
        return false;
    }

    // New: Validate if the string is a valid number (Integer or Double)
    public static boolean isNumeric(JTextField field, String name) {
        try {
            Double.parseDouble(field.getText().trim());
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, name + " must be a valid number", "Validation Error", JOptionPane.ERROR_MESSAGE);
            field.requestFocus();
            return false;
        }
    }
}
