package ao222qc_assign2.Exercise2;

/**
 * Created by Adam on 2016-09-14.
 */
public class FerryMain
{
    public static void main(String args[])
    {
        TransportFerry tf = new TransportFerry();

        Car c = new Car();
        c.addPassenger();
        c.addPassenger();
        Lorry l = new Lorry();
        l.addPassenger();
        l.addPassenger();
        l.addPassenger();

        tf.embark(c);
        tf.embark(l);

        System.out.println(tf.toString());

        tf.disembark();

        System.out.println(tf.toString());

        Lorry l2 = new Lorry();
        tf.embark(l2);

        System.out.println(tf.toString());
        tf.disembark();
        System.out.println(tf.toString());
    }
}
