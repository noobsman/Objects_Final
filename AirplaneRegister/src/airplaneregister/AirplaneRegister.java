/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airplaneregister;

import java.util.Random;

/**
 * Airline Reservation Main program.
 * @author Roarke Schafer
 */
public class AirplaneRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random(); 
  
//(int maxSeats, String model, String flightDepart, String flightArrive)
        Flight flight = new Flight(100,"BigPlane","0:00","0:00");
        
        flight.createSeatingClass("Test class", 3, 20);
        flight.createSeatingClass("Best class", 4, 20);
        for(int i = 0; i <  18; i++)
        {
            flight.flightSeatingChart.get(0).ceateSeat(rand.nextInt(100));
        }
        flight.flightSeatingChart.get(0).reserveSeat("A3", "Roarke Schafer");
        flight.flightSeatingChart.get(0).reserveSeat("C1", "Roarke Schafer");
        flight.flightSeatingChart.get(0).reserveSeat("F2", "Roarke Schafer");
        for(int i = 0; i <  20; i++)
        {
            flight.flightSeatingChart.get(1).ceateSeat(rand.nextInt(100) + 100);
        }
        flight.flightSeatingChart.get(1).reserveSeat("C3", "Roarke Schafer");
        flight.flightSeatingChart.get(1).reserveSeat("C1", "Roarke Schafer");
        flight.flightSeatingChart.get(1).reserveSeat("E2", "Roarke Schafer");
        flight.flightSeatingChart.get(1).reserveSeat("E3", "Roarke Schafer");
        flight.flightSeatingChart.get(1).reserveSeat("D1", "Roarke Schafer");
        flight.flightSeatingChart.get(1).reserveSeat("A2", "Roarke Schafer");
        flight.flightSeatingChart.get(1).reserveSeat("A4", "Roarke Schafer");
        
        flight.flightSeatingChart.get(0).printClassData();
        flight.flightSeatingChart.get(1).printClassData();
        flight.flightSeatingChart.get(0).printRowPicture();
        flight.flightSeatingChart.get(1).printRowPicture();
    }
}
