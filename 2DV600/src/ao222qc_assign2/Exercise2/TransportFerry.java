package ao222qc_assign2.Exercise2;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 * Created by Adam on 2016-09-14.
 */
public class TransportFerry implements Ferry
{
    List<Vehicle> vehicleList = new LinkedList<Vehicle>();
    List<Passenger> passengerList = new LinkedList<Passenger>();
    private double actualVehicleSpace = 0.0;
    private final int MAX_PASSENGERS = 200;
    private final int MAX_SPACE = 40;


    @Override
    public int countPassengers()
    {
        int usedPassengerSpace = 0;
        for(Passenger p : passengerList)
        {
            usedPassengerSpace+=1;
        }
        return usedPassengerSpace;
    }

    @Override
    public int countVehicleSpace()
    {
        double usedSpace = 0;

        for(Vehicle v : vehicleList)
        {
            usedSpace += v.getSpace();
        }
        System.out.println(usedSpace);
        return (int)Math.ceil(usedSpace);
    }

    public double countActualVehicleSpace()
    {
        double usedSpace = 0;
        for(Vehicle v : vehicleList)
        {
            usedSpace += v.getSpace();
        }
        usedSpace = (double) Math.round(usedSpace * 100) / 100;
        actualVehicleSpace = usedSpace;
        return actualVehicleSpace;
    }

    @Override
    public int countMoney()
    {
        int moneyEarned = 0;

        for(Passenger p : passengerList)
        {
            moneyEarned += p.getFerryFee();
        }
        for(Vehicle v : vehicleList)
        {
            moneyEarned += v.getPrice();
        }
        return moneyEarned;
    }

    @Override
    public void embark(Vehicle v)
    {
        if(hasSpaceFor(v))
        {
            vehicleList.add(v);
            for(Passenger p : v.getPassengers())
            {
                embark(p);
            }
        }
        else
        {
            System.out.println("There is no space for this vehicle.");
        }
    }

    @Override
    public void embark(Passenger p)
    {
        if(hasRoomFor(p))
        {
            passengerList.add(p);
        }
    }

    @Override
    public void disembark()
    {

    }

    @Override
    public boolean hasSpaceFor(Vehicle v)
    {
        return countActualVehicleSpace()+v.getSpace() <= MAX_SPACE;
    }

    @Override
    public boolean hasRoomFor(Passenger p)
    {
        return countPassengers() < MAX_PASSENGERS;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------\n");
        sb.append("Welcome to the transport ferry!\n");
        sb.append("We currently have " + countPassengers() + " passengers onboard!\n");
        sb.append("Boarded vehicles are currently taking up " + countActualVehicleSpace() + " random units of measurement!\n");
        sb.append("We've made "+ countMoney() + " kr from this trip!\n");
        return sb.toString();
    }

    @Override
    public Iterator<Vehicle> iterator()
    {
        return vehicleList.iterator();
    }
}
