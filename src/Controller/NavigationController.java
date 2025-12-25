/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.CardLayout;
import javax.swing.*;

/**
 *
 * @author ACER
 */
public class NavigationController 
{
    private JPanel cardPanel;

    public NavigationController(JPanel cardPanel) {
        this.cardPanel = cardPanel;
    }

    public void show(String cardName) {
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, cardName);
    }
}
