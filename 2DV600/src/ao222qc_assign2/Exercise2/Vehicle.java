package ao222qc_assign2.Exercise2;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * Created by Adam on 2016-09-14.
 */
public abstract class Vehicle
{
    protected double space;
    protected int price;
    protected int passengerFee;
    protected int maxPassengers;
    protected LinkedList<Passenger> passengers;// = new LinkedList<Passenger>();
    protected double getSpace() {return space;}
    protected int getPrice() {return price;}
    protected int getPassengerFee() {return passengerFee;}
    protected int getAmountOfPassengers() {return passengers.size();}
    protected LinkedList<Passenger> getPassengers() {return passengers;}

    protected void addPassenger() throws IndexOutOfBoundsException
    {
        try
        {
            if (passengers.size() < maxPassengers)
            {
                passengers.add(new Passenger(passengerFee));
            }
            else
            {
                throw new IndexOutOfBoundsException("The vehicle cannot fit anymore passengers.");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
