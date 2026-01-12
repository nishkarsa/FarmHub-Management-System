/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.LinkedList;
import java.util.Queue;
import Model.Farmer;

/**
 *
 * @author ACER
 */
public class DeletedFarmerQueue 
{
    private static Queue<Farmer> deletedFarmers = new LinkedList<>();

    public static void addDeletedFarmer(Farmer f) 
    {
        deletedFarmers.offer(f);   // enqueue
    }

    public static Queue<Farmer> getDeletedFarmers() 
    {
        return deletedFarmers;
    }
    
    public static Farmer restoreFarmer() 
    {
        return deletedFarmers.poll();   // FIFO restore
    }

}
