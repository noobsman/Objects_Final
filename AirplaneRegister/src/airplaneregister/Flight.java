/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneregister;

import java.util.ArrayList;

/**
 * The Flight Class holds array of seats and model of plane.
 * @author Roarke Scahfer
 * @assignment CSCI3307 Final Project
 * @date 12/8/2019
 */
public class Flight {

    private String model;
    private final String flightDepart;
    private final String flightArrive;
    private int flightNumberOfReserved;
    public ArrayList<SeatingClass> flightSeatingChart;
    int maxCapacity;
    
    
    /**
     * Flight Default Constructor.
     */
    Flight()
    {
        model = "";
        flightDepart = "";
        flightArrive = "";
        flightNumberOfReserved = 0;
        maxCapacity = 0;
    }
    
    Flight(int maxSeats, String model, String flightDepart, String flightArrive)
    {
        this.maxCapacity = maxSeats;
        this.model = model;
        this.flightDepart = flightDepart;
        this.flightArrive = flightArrive;
        this.flightNumberOfReserved = 0;
        flightSeatingChart = new ArrayList<>();
    }
    
    /**
     * Creates a new seating class for the flight.
     * @param className
     * @param columns
     * @param capacity 
     */
    public void createSeatingClass(String className, int columns, int capacity)
    {
        int currentCapacity = 0;
        for (int i = 0; i < flightSeatingChart.size(); i++) 
        {
           SeatingClass seatClass = flightSeatingChart.get(i);
           currentCapacity += seatClass.getCapacityAmount();
        }
        
        if(maxCapacity >= currentCapacity+capacity)
        {
            flightSeatingChart.add(new SeatingClass(className, columns, capacity));
        }
        else
        {
           System.out.println("Error: max capacity of the aircraft is " + maxCapacity + ". With a current currentCapacity of " + currentCapacity + ". \nAdding a new seating class containing " + capacity + " seats would overflow the plane!");
        }
    }
    
    public int getReservedAmount()
    {
        return flightNumberOfReserved;
    }
}
