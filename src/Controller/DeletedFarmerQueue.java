/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.LinkedList;
import java.util.Queue;
import Model.Farmer;

/**
 * The DeletedFarmerQueue class acts as a temporary storage (recycle bin)
 * It follows the "First-In, First-Out" (FIFO) principle, Queue
 * @author Nishkarsa
 */
public class DeletedFarmerQueue 
{
    private static LinkedList<Farmer> deletedFarmers = new LinkedList<>();

    /**
     * Adds a farmer to the end of the deleted list.
     * This is like a farmer joining the back of a line.
     * @param f the Farmer object to be stored
     */
    public static void addDeletedFarmer(Farmer f) 
    {
        // addLast puts the item at the very end of the list
        deletedFarmers.addLast(f);
    }

    /**
     * @return the LinkedList containing all deleted farmers
     */
    public static Queue<Farmer> getDeletedFarmers() 
    {
        return deletedFarmers;
    }
    
    /**
     * Removes and returns the farmer from the front of the list.
     * This allows us to restore the farmer who has been waiting the longest.
     * @return the Farmer object at the front, or null if the list is empty
     */
    public static Farmer restoreFarmer() 
    {
        // Check for underflow
        if (deletedFarmers.size() > 0) 
        {
            // removeFirst takes the person from the front of the line FIFO
            return deletedFarmers.removeFirst();
        }
        
        // Return null if there are no farmers to restore
        return null;
    }
    
    /**
     * Checks if there are no farmers in the deleted list.
     * @return true if the size is 0, false otherwise
     */
    public static boolean isEmpty() 
    {
        if (deletedFarmers.size() == 0) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
}
