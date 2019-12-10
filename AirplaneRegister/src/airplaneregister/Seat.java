package airplaneregister;

/**
 * Node class for a seat on an airplane.
 * @author Roarke Schafer
 * @assignment CSCI3307 Final Project
 * @date 12/8/2019
 */

public class Seat {
    private String seatType;
    private String seatId;
    
    private boolean reserved;
    private String owner;
   
    private double price;
    /**
     * Default Constructor for Seat class.
     */
    Seat()
    {
        seatType = "";
        seatId = "";
        reserved = false;
        owner = "";
        price = 0;
    }
    
    /**
     * Constructor for creating seat class.
     * @param type
     * @param Id 
     */
    Seat(String type, String Id, double price)
    {
        seatType = type;
        seatId = Id;
        reserved = false;
        owner = "";
        this.price = price;
    }
    
    /**
     * Main constructor for creating a Seat class.
     * @param type
     * @param Id
     * @param price 
     */
    Seat(int type, String Id, double price)
    { 
        switch(type)
        {
            case 0:
                seatType = "First Class";
            break;
            case 1:
                seatType = "Business Class";
            break;
            case 2:
                seatType = "Premium Economy";
            break;
            case 3:
                seatType = "Economy Class";
            break;
            default:
                seatType = "First Class";
        }
        seatId = Id;
        reserved = false;
        owner = "";
        this.price = price;
    }
    
    /**
     * returns boolean true if seat is reserved.
     * @return 
     */
    public boolean getReserved()
    {
        return reserved;
    }
    
    /**
     * returns the SeatingClass type of the seat.
     * @return 
     */
    public String getSeatType()
    {
        return seatType;
    }
    
    /**
     * returns the Id connected to the seat.
     * @return 
     */
    public String getSeatId()
    {
        return seatId;
    }
    
    /**
     * returns the name of the owner of the seat.
     * @return 
     */
    public String getSeatOwner()
    {
        return owner;
    }
    
    /**
     * returns the price of the seat.
     * @return 
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * sets the price of the seat.
     * @param price 
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    /**
     * sets the name of the seat.
     * @param name 
     */
    public void setName(String name)
    {
        owner = name;
    }
    
    /**
     * changes the seat to reserved.
     */
    public void setReserved()
    {
        reserved = true;
    }
}
