/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Component;
import javax.swing.JLabel;
/**
 *
 * @author ACER
 */
public class SelectionSort 
{
    private JPanel productPanel;
    
    private ArrayList<JPanel> allProducts = new ArrayList<>();


    public SelectionSort(JPanel productPanel) 
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

    // Read all product cards
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

    private double getPrice(JPanel card) 
    {
        return findPrice(card);
    }

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

    // Reload sorted products
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

    // Selection Sort by Name
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

    // Selection Sort by Price
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

    
}
