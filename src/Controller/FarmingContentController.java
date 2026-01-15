/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * The FarmingContentController manages the display of farming cards.
 * It uses Merge Sort to organize filtered results.
 * @author Nishkarsa
 */
public class FarmingContentController 
{
    private JPanel contentPanel;
    private ArrayList<JPanel> allCards = new ArrayList<>();
    
    // Constructor
    public FarmingContentController(JPanel contentPanel) 
    {
        this.contentPanel = contentPanel;

        // Collect all panel components from the main display area
        for (Component c : contentPanel.getComponents()) 
        {
            if (c instanceof JPanel) 
            {
                allCards.add((JPanel) c);
            }
        }
    }

    /**
     * Filters cards using Merge Sort.
     * @param terrain type of geographical region.
     * @param season four seasons (winter, summer, spring, Autumn).
     * @param keyword name of farming technique.
     */
    public void filter(String terrain, String season, String keyword) 
    {
        ArrayList<JPanel> filtered = new ArrayList<>();

        for (int i = 0; i < allCards.size(); i++) 
        {
            JPanel card = allCards.get(i);
            String name = card.getName().toLowerCase();

            // Check if requirements are met
            boolean terrainMatch = terrain.equals("All") || name.contains(terrain.toLowerCase());
            boolean seasonMatch = season.equals("All") || name.contains(season.toLowerCase());
            
            // Replacing .isEmpty() with .length() check for beginners
            boolean keywordMatch = (keyword.length() == 0) || name.contains(keyword.toLowerCase());

            if (terrainMatch && seasonMatch && keywordMatch) 
            {
                filtered.add(card);
            }
        }

        // Convert the filtered list into an Array to use the Merge Sort logic
        JPanel[] filteredArray = filtered.toArray(new JPanel[0]);
        
        // Only sort if there is more than one item
        if (filteredArray.length > 1) 
        {
            mergeSort(filteredArray);
        }

        // Pass the array to the updated reload method
        reload(filteredArray);
    }

    /**
     * Breaks the array into smaller halves recursively.
     * * @param a The array of JPanels currently being divided and sorted.
     */
    private void mergeSort(JPanel[] a) 
    {
        if (a.length <= 1) 
        {
            return;
        }

        // Step 1: Create two new arrays to hold the halves
        JPanel[] first = new JPanel[a.length / 2];
        JPanel[] second = new JPanel[a.length - first.length];

        // Step 2: Copy the first half into the 'first' array
        for (int i = 0; i < first.length; i++) 
        {
            first[i] = a[i];
        }

        // Step 3: Copy the second half into the 'second' array
        for (int i = 0; i < second.length; i++) 
        {
            second[i] = a[first.length + i];
        }

        // Recursively sort both halves
        mergeSort(first);
        mergeSort(second);

        // Merge the two sorted halves back together
        merge(first, second, a);
    }
    
    /**
     * Compares elements from two arrays and merges them into a single sorted array.
     * @param first  The first sorted half-array.
     * @param second The second sorted half-array.
     * @param result The original array where the sorted elements are placed.
     */
    private void merge(JPanel[] first, JPanel[] second, JPanel[] result) {
        int iFirst = 0; // Pointer for the first array
        int iSecond = 0; // Pointer for the second array
        int j = 0; // Pointer for the result array

        // While both arrays have items, compare them
        while (iFirst < first.length && iSecond < second.length) 
        {
            // Compare names alphabetically (A-Z)
            if (first[iFirst].getName().compareToIgnoreCase(second[iSecond].getName()) < 0) 
            {
                result[j] = first[iFirst];
                iFirst++;
            } 
            else 
            {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // Copy any leftover elements from the first array
        while (iFirst < first.length) 
        {
            result[j] = first[iFirst];
            iFirst++; 
            j++;
        }
        
        // Copy any leftover elements from the second array
        while (iSecond < second.length) 
        {
            result[j] = second[iSecond];
            iSecond++; 
            j++;
        }
    }
    
    /**
     * Updates the UI by removing old cards and adding the newly filtered/sorted ones.
     * @param cards The array of JPanels that have been filtered and sorted.
     */
    private void reload(JPanel[] cards) 
    {
        // Clear the current display
        contentPanel.removeAll();

        // Add the sorted cards back to the panel
        for (int i = 0; i < cards.length; i++) 
        {
            contentPanel.add(cards[i]);
        }

        // Tell Swing to refresh the screen layout
        contentPanel.revalidate();
        contentPanel.repaint();
    }
}
