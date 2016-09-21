package ao222qc_assign2.Exercise2;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Adam on 2016-09-14.
 */
public interface Ferry extends Iterable<Vehicle>
{
    int countPassengers();             // Number of passengers on board
    int countVehicleSpace();           // Used vehicle space. One car is 1.
    int countMoney();                  // Earned money
    void embark(Vehicle v);            // Embark vehicle, warning if not enough space
    void embark(Passenger p);          // Embark passenger, warning if not enough room
    void disembark();                  // Clear (empty) ferry. The money earned remains,
                                       // i.e., is not reset to zero
    boolean hasSpaceFor(Vehicle v);    // true if we can embark vehicle v
    boolean hasRoomFor(Passenger p);   // true if we can embark passenger p
    String toString();                 // Nice looking ferry status print out
}
