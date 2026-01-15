/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Farmer;
import java.awt.Component;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Controller class responsible for sorting, searching, and filtering.
 * @author Nishkarsa
 */
public class SortAndSearch 
{
    private JPanel productPanel;
    private ArrayList<JPanel> allProducts = new ArrayList<>();

    // Constructor
    public SortAndSearch(JPanel productPanel) 
    {
        this.productPanel = productPanel;
        
        // Store original products
        for (Component c : productPanel.getComponents()) 
        {
            if (c instanceof JPanel) 
            {
                allProducts.add((JPanel) c);
            }
        }
    }

    /**
     * Retrieves all current product card JPanels from the main panel.
     * @return ArrayList of JPanel components representing product cards.
     */
    private ArrayList<JPanel> getProductCards() 
    {
        ArrayList<JPanel> cards = new ArrayList<>();

        for (Component c : productPanel.getComponents()) 
        {
            if (c instanceof JPanel) {
                cards.add((JPanel) c);
            }
        }
        return cards;
    }
    
    /**
     * Helper method to extract price from a product card.
     * @param card The JPanel containing product details.
     * @return The price as a double.
     */
    private double getPrice(JPanel card) 
    {
        return findPrice(card);
    }
    
    /**
     * Recursively searches through a component's children to find a JLabel 
     * named "lblPrice" and parses its value.
     * @param comp The component to search.
     * @return The price as a double, or -1 if not found.
     */
    private double findPrice(Component comp) 
    {

        if (comp instanceof JLabel && "lblPrice".equals(comp.getName())) 
        {
            return Double.parseDouble(((JLabel) comp).getText());
        }

        if (comp instanceof JPanel) 
        {
            for (Component c : ((JPanel) comp).getComponents()) 
            {
                double value = findPrice(c);
                if (value != -1) return value;
            }
        }
        return -1;
    }

    /**
     * Clears the UI panel and repopulates it with the provided list of cards.
     * @param cards The list of JPanels to display.
     */
    private void reload(ArrayList<JPanel> cards) 
    {
        productPanel.removeAll();
        for (JPanel p : cards) 
        {
            productPanel.add(p);
        }
        productPanel.revalidate();
        productPanel.repaint();
    }

    /**
     * Sorts products alphabetically by their component name using Selection Sort.
     */
    public void sortByName() 
    {
        ArrayList<JPanel> cards = getProductCards();

        for (int i = 0; i < cards.size() - 1; i++) 
        {
            int min = i;
            for (int j = i + 1; j < cards.size(); j++) 
            {
                String n1 = cards.get(j).getName();
                String n2 = cards.get(min).getName();

                if (n1.compareToIgnoreCase(n2) < 0) 
                {
                    min = j;
                }
            }
            JPanel temp = cards.get(i);
            cards.set(i, cards.get(min));
            cards.set(min, temp);
        }

        reload(cards);
    }

    /**
     * Sorts products by price (Low to High) using Selection Sort.
     */
    public void sortByPrice() 
    {
        ArrayList<JPanel> cards = getProductCards();

        for (int i = 0; i < cards.size() - 1; i++) 
        {
            int min = i;
            for (int j = i + 1; j < cards.size(); j++) 
            {
                if (getPrice(cards.get(j)) < getPrice(cards.get(min))) 
                {
                    min = j;
                }
            }
            JPanel temp = cards.get(i);
            cards.set(i, cards.get(min));
            cards.set(min, temp);
        }

        reload(cards);
    }
    
    /**
     * Filters the original product list based on whether the name contains the keyword.
     * @param keyword The text to search for.
     */
    public void search(String keyword) 
    {
        ArrayList<JPanel> filtered = new ArrayList<>();

        for (JPanel p : allProducts) 
        {
            if (p.getName().toLowerCase().contains(keyword.toLowerCase())) 
            {
                filtered.add(p);
            }
        }

        reload(filtered);
    }

    /**
     * Logic for Selection Sort by Name.
     * Time Complexity: O(n^2)
     */
    private void selectionSortByName(ArrayList<JPanel> cards) 
    {
        for (int i = 0; i < cards.size() - 1; i++) 
        {
            int min = i;
            for (int j = i + 1; j < cards.size(); j++) 
            {
                if (cards.get(j).getName().compareToIgnoreCase(cards.get(min).getName()) < 0) 
                {
                    min = j;
                }
            }
            JPanel temp = cards.get(i);
            cards.set(i, cards.get(min));
            cards.set(min, temp);
        }
    }

    /**
     * Logic for Selection Sort by Price.
     * Time Complexity: O(n^2)
     */
    private void selectionSortByPrice(ArrayList<JPanel> cards) 
    {
        for (int i = 0; i < cards.size() - 1; i++) 
        {
            int min = i;
            for (int j = i + 1; j < cards.size(); j++) 
            {
                if (getPrice(cards.get(j)) < getPrice(cards.get(min))) 
                {
                    min = j;
                }
            }
            JPanel temp = cards.get(i);
            cards.set(i, cards.get(min));
            cards.set(min, temp);
        }
    }

    /**
     * Generic sort method that handles multiple sorting criteria.
     * @param option String identifying the sort type ("Name (A–Z)" or "Price (Low–High)").
     */
    public void sort(String option) 
    {
        ArrayList<JPanel> cards = getProductCards();

        if (option.equals("Name (A–Z)")) 
        {
            selectionSortByName(cards);
        }
        else if (option.equals("Price (Low–High)")) 
        {
            selectionSortByPrice(cards);
        }

        reload(cards);
    }
    
    /**
     * Filters products by a specific category prefix.
     * @param category The category name (or "All" to reset).
     */
    public void filterByCategory(String category) 
    {

        if (category.equals("All")) 
        {
            reload(allProducts);
            return;
        }

        ArrayList<JPanel> filtered = new ArrayList<>();

        for (JPanel p : allProducts) 
        {
            if (p.getName().toLowerCase().startsWith(category.toLowerCase())) 
            {
                filtered.add(p);
            }
        }

        reload(filtered);
    }   

    /**
     * Sorts a LinkedList of Farmer objects using Insertion Sort.
     * @param list The list of farmers to be sorted.
     */
    public static void insertionSortFarmers(LinkedList<Farmer> list) 
    {
        for (int i = 1; i < list.size(); i++) 
        {
            Farmer key = list.get(i);
            int j = i - 1;

            // Compare names alphabetically (case-insensitive)
            while (j >= 0 && list.get(j).getName().compareToIgnoreCase(key.getName()) > 0) 
            {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }
    
    /**
     * Performs a Linear Search on the product list.
     * @param keyword The string to search for.
     */
    public void linearSearch(String keyword) {
        ArrayList<JPanel> filtered = new ArrayList<>();
        String searchKey = keyword.toLowerCase();

        for (JPanel p : allProducts) {
            if (p.getName() != null && p.getName().toLowerCase().contains(searchKey)) {
                filtered.add(p);
            }
        }
        reload(filtered);
    }
    
    /**
     * Performs a Binary Search on the product list.
     * Note: The list is sorted by name before searching.
     * Time Complexity: O(log n) for the search itself.
     * @param keyword The exact string to search for (case-insensitive).
     */
    public void binarySearch(String keyword) {
        // 1. Get a copy of all products and sort them by name (requirement for binary search)
        ArrayList<JPanel> sortedList = new ArrayList<>(allProducts);
        selectionSortByName(sortedList);

        ArrayList<JPanel> result = new ArrayList<>();
        int low = 0;
        int high = sortedList.size() - 1;
        String searchKey = keyword.toLowerCase();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String midName = sortedList.get(mid).getName().toLowerCase();

            int comparison = midName.compareTo(searchKey);

            if (comparison == 0) {
                // Found the exact match
                result.add(sortedList.get(mid));
                break; 
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // Reload panel with the result (will be empty if not found)
        reload(result);
    }
}
