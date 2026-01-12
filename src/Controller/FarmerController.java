/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.LinkedList;
import Model.*;

/**
 *
 * @author ACER
 */
public class FarmerController 
{
    private static LinkedList<Farmer> farmers = new LinkedList<>();

    static 
    {
        farmers.add(new Farmer(1,"Ram Gurung","9861545669","Kathmandu","Active"));
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

    public static LinkedList<Farmer> getAllFarmers() 
    {
        return farmers;
    }

    public static void updateStatus(int index, String status) 
    {
        farmers.get(index).setStatus(status);
    }

    public static void deleteFarmer(int index) 
    {
        Farmer removed = farmers.remove(index);
        DeletedFarmerQueue.addDeletedFarmer(removed);  // send to history
    }
    
    public static void restoreFarmer(Farmer f) 
    {
        farmers.add(f);   // add back to active list
    }
}
