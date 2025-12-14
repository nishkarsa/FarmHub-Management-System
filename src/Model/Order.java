/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ACER
 */
public class Order 
{
    private int orderId;
    private Farmer farmer;
    private List<OrderItem> items;
    private double totalAmount;
    private String status;      // Pending, delivered
    private LocalDate orderDate;
}
