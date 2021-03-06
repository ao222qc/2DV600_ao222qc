package ao222qc_assign2.Exercise2;

import java.util.LinkedList;

/**
 * Created by Adam on 2016-09-14.
 */
public class Car extends Vehicle
{
    public Car()
    {
        space = 1;
        price = 100;
        passengerFee = 15;
        maxPassengers = 4;
        passengers = new LinkedList<Passenger>();
    }

    @Override
    protected double getSpace()
    {
        return super.getSpace();
    }

    @Override
    protected int getPrice()
    {
        return super.getPrice();
    }

    @Override
    protected int getPassengerFee()
    {
        return super.getPassengerFee();
    }

    @Override
    protected int getAmountOfPassengers()
    {
        return super.getAmountOfPassengers();
    }

    @Override
    protected LinkedList<Passenger> getPassengers()
    {
        return super.getPassengers();
    }

    @Override
    protected void addPassenger() throws IndexOutOfBoundsException
    {
        super.addPassenger();
    }


}
