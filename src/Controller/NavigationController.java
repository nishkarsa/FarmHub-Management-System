/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.CardLayout;
import javax.swing.*;

/**
 * Serves as a mediator for switching views within the application.
 * Abstracts the complexity of CardLayout, allowing other components to trigger
 * navigation by name without needing direct access to the parent panel's layout.
 * @author Nishkarsa
 */
public class NavigationController 
{
    // The parent container that holds multiple "cards" (panels)
    private JPanel cardPanel;

    /**
     * Initializes the controller with a reference to the main display panel.
     * @param cardPanel The JPanel configured with a CardLayout.
     */
    public NavigationController(JPanel cardPanel) 
    {
        this.cardPanel = cardPanel;
    }
    
    /**
     * Switches the visible component in the container based on its unique name.
     * This method retrieves the CardLayout and invokes the show() command.
     * * @param cardName The unique identifier string assigned to a panel.
     */
    public void show(String cardName) {
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        cl.show(cardPanel, cardName);
    }
}
