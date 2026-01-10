/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class FarmingContentController 
{
    private JPanel contentPanel;
    private ArrayList<JPanel> allCards = new ArrayList<>();

    public FarmingContentController(JPanel contentPanel) 
    {
        this.contentPanel = contentPanel;

        for (Component c : contentPanel.getComponents()) 
        {
            if (c instanceof JPanel) 
            {
                allCards.add((JPanel) c);
            }
        }
    }

    public void filter(String terrain, String season, String keyword) 
    {
        ArrayList<JPanel> filtered = new ArrayList<>();

        for (JPanel card : allCards) 
        {
            String name = card.getName().toLowerCase();

            boolean terrainMatch = terrain.equals("All") || name.contains(terrain.toLowerCase());
            boolean seasonMatch = season.equals("All") || name.contains(season.toLowerCase());
            boolean keywordMatch = keyword.isEmpty() || name.contains(keyword.toLowerCase());

            if (terrainMatch && seasonMatch && keywordMatch) 
            {
                filtered.add(card);
            }
        }

        reload(filtered);
    }

    private void reload(ArrayList<JPanel> cards) 
    {
        contentPanel.removeAll();
        for (JPanel c : cards) 
        {
            contentPanel.add(c);
        }
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
