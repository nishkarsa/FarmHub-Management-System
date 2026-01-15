/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.LinkedList;
import Model.Farmer;

/**
 * The FarmerController class manages the primary list of farmers in the system.
 * It provides methods to view all farmers, update their information and delete them.
 * @author Nishkarsa
 */
public class FarmerController 
{
    // A shared list that stores all our Farmer objects
    private static LinkedList<Farmer> farmers = new LinkedList<>();
    
    static 
    {
        farmers.add(new Farmer(1,"Ram Gurung","9861545669","K athmandu","Active"));
        farmers.add(new Farmer(2,"Lokesh","9701259845","Lalitpur","Active"));
        farmers.add(new Farmer(3,"Hari Bahadur","9805649922","Bhaktapur","Inactive"));
        farmers.add(new Farmer(4,"Gita Sharma","9815874136","Pokhara","Active"));
        farmers.add(new Farmer(5,"Ramesh Pathak","9701210590","Chitwan","Inactive"));
        farmers.add(new Farmer(6,"Maya Limbu","9879850125","Butwal","Active"));
        farmers.add(new Farmer(7,"Bishal Karki","9732102587","Biratnagar","Active"));
        farmers.add(new Farmer(8,"Nabin Tamang","9801257401","Dharan","Inactive"));
        farmers.add(new Farmer(9,"Asha Shrestha","9879540136","Hetauda","Active"));
        farmers.add(new Farmer(10,"Kiran Lamsal","9841289601","Nepalgunj","Inactive"));
    }

    /**
     * @return the full list of farmers to be displayed in a table.
     */
    public static LinkedList<Farmer> getAllFarmers() 
    {
        return farmers;
    }

    /**
     * Finds a farmer by their position in the list and changes their status.
     * @param index the row number/position in the list
     * @param status the new status (active/inactive)
     */
    public static void updateStatus(int index, String status) 
    {
        // First, we get the specific farmer object using the index
        Farmer f = farmers.get(index);
        // Then, we update that farmer's status
        f.setStatus(status);
    }
    
    /**
     * Removes a farmer from the main list and moves them to the Deleted Queue.
     * @param index the position of the farmer to remove
     */
    public static void deleteFarmer(int index) 
    {
        // Check if the index is valid (within the list boundaries)
        if (index >= 0 && index < farmers.size()) 
        {
            // remove() deletes the item and gives it back to us so we can save it elsewhere
            Farmer removed = farmers.remove(index);
            
            // We pass the removed farmer to our 'recycle bin' class
            DeletedFarmerQueue.addDeletedFarmer(removed); 
        }
    }
    
    /**
     * Adds a farmer object back into the main list.
     * @param f the farmer object
     */
    public static void restoreFarmer(Farmer f) 
    {
        farmers.add(f);   // add back to active list
    }
    
    /**
     * Creates a new Farmer object and adds it to our list.
     * @param name full name of new registered farmer.
     * @param phone contact number of new farmer.
     * @param address address of new farmer.
     */
    public static void addFarmer(String name, String phone, String address) 
    {
        // auto incrementing ID for new farmer
        int nextId = farmers.size() + 1; 
        
        // Create the new object with a default "Active" status
        Farmer newFarmer = new Farmer(nextId, name, phone, address, "Active");
        
        // Add it to the list
        farmers.add(newFarmer);
}
}
