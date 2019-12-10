/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneregister;

import java.util.ArrayList;
/**
 * Seating class used to separate other seating classes with there own seats.
 * @author Roarke Schafer
 * @assignment CSCI3307 Final Project
 * @date 12/8/2019
 */
public class SeatingClass {
    private static String[] rows = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",""};
    private String className;
    private int flightNumberOfReserved;
    private ArrayList<Seat> seatingChart;
    private int column;
    private int capacity;
    
    /**
     * Default constructor for SeatingClass
     */
    SeatingClass()
    {
        className = "";
        flightNumberOfReserved = 0;
        seatingChart = new ArrayList<>();
        column = 0;
        capacity = 0;
    }
    
    /**
     * Main constructor for creating a SeatingClass
     * @param name
     * @param column
     * @param maxCapacity 
     */
    SeatingClass(String name, int column, int maxCapacity)
    {
        this.className = name;
        flightNumberOfReserved = 0;
        seatingChart = new ArrayList<>();
        this.column = column;
        this.capacity = maxCapacity;
    }
    /**
     * Creates a new Seat and adds it to the seating class list.
     * @param price 
     */
    public void ceateSeat(double price)
    {
        if(seatingChart.isEmpty())
        {
            seatingChart.add(new Seat(className,rows[0]+"1",price));
        }
        else if(seatingChart.size() >= capacity)
        {
            System.err.println("Error Seat was not created because this seat class: "+ className +" is full of " + capacity + " seats");
        }
        else
        {
            String mapingId = seatingChart.get(seatingChart.size()-1).getSeatId(); 
            if(mapingId.contains(String.valueOf(column)))
            {
                seatingChart.add(new Seat(className,getNextRow(mapingId)+"1",price));
            }
            else
            {
                seatingChart.add(new Seat(className,Character.toString(mapingId.charAt(0)) +
                Integer.toString((Integer.parseInt(mapingId.substring(1)) + 1)),price));
            }
        } 
    }  
    
    /**
     * returns the next row name.
     * @param Id
     * @return 
     */
    private String getNextRow(String Id)
    {
        for (int i = 0; i < rows.length; i++)
        {
            if(rows[i] == null ? Character.toString(Id.charAt(0)) == null : rows[i].equals(Character.toString(Id.charAt(0))))
            {
                return rows[++i];
            }
        }
        return null;
    }
    
    /**
     * reserves a seat if not reserved under the name.
     * @param Id
     * @param name 
     */
    public void reserveSeat(String Id, String name)
    {
        Seat seat = getSeat(Id);
        if(seat.getReserved())
        {
            System.out.println("Seat with Id: " + Id + " is already reserved.");
        }
        else
        {
            flightNumberOfReserved++;
            seat.setReserved();
            seat.setName(name);
            System.out.println("Congratulations " + name + " you have reserved seat " + Id + " in " + seat.getSeatType());
        }
    }
    
    /**
     * Returns a seat of Id or Owner Name.
     * @param id
     * @return
     */
    public Seat getSeat(String id)
    {
        for (int i = 0; i < seatingChart.size(); i++) {
            Seat seat = seatingChart.get(i);
            if(seat.getSeatId() == null ? id == null : seat.getSeatId().equals(id) || seat.getSeatOwner().equals(id))
            {
                return seat;
            }
        }
        System.err.println("Error Seat with Id: " + id + " was not found. Return Null.");
        return null;
    }
    
    /**
     * returns the max capacity of the seating class.
     * @return 
     */
    public int getCapacityAmount()
    {
        return capacity;
    }
    
    /**
     * returns the number of seats reserved under the seating class.
     * @return 
     */
    public int getReservedAmount()
    {
        return flightNumberOfReserved;
    }
    
    /**
     * returns the name of the seating class.
     * @return 
     */
    public String getSeatingClass()
    {
        return className;
    }
    
    /**
     * prints out data of a single seat.
     * @param seat 
     */
    public void printSeatData(Seat seat)
    {
        if(seat.getReserved())
        {
            System.out.println( "Seat Id:(" + seat.getSeatId() + ") Seat class: (" + seat.getSeatType() + ") is Reserved to: " + seat.getSeatOwner());
        }
        else
        {
            System.out.print( "Seat Id: (" + seat.getSeatId() + ") Seat class: (" + seat.getSeatType() + ") is not Reserved and is $");
            System.out.printf("%.2f", seat.getPrice());
            System.out.println();
        }
    }
    
    /**
     * prints out data of all the seats on in this seating class.
     */
    public void printClassData()
    {
        System.out.println();
        System.out.println(className + " DATA:__________");
        for (int i = 0; i < seatingChart.size(); i++) {
            Seat seat = seatingChart.get(i);
            printSeatData(seat);
        }
    }
    
    /**
     * Prints out a grid picture of the plane seats into columns of seat Id.
     */
    public void printRowPicture()
    {
        String currentRow = "";
        for (int i = 0; i < seatingChart.size(); i++) {
            Seat seat = seatingChart.get(i);
            if(Character.toString(seat.getSeatId().charAt(0)) == null ? currentRow != null : !Character.toString(seat.getSeatId().charAt(0)).equals(currentRow))
            {
                if (seat.getReserved())
                {
                currentRow = Character.toString(seat.getSeatId().charAt(0));
                System.out.println();
                System.out.print("*" + seat.getSeatId());
                }
                else
                {
                currentRow = Character.toString(seat.getSeatId().charAt(0));
                System.out.println();
                System.out.print(" " + seat.getSeatId());
                }
            }
            else
            {
                if (seat.getReserved())
                {
                System.out.print("  *" + seat.getSeatId());
                }
                else
                {
                    System.out.print("   " + seat.getSeatId());   
                }
            }
        }
        System.out.println();
    }
}
