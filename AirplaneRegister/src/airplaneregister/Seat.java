package airplaneregister;

/**
 * Node class for a seat on an airplane.
 * @author Roarke Schafer
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
    
    public boolean getReserved()
    {
        return reserved;
    }
    
    public String getSeatType()
    {
        return seatType;
    }
    
    public String getSeatId()
    {
        return seatId;
    }
    
    public String getSeatOwner()
    {
        return owner;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setName(String name)
    {
        owner = name;
    }
    
    public void setReserved()
    {
        reserved = true;
    }
}
