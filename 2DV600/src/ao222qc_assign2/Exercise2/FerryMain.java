package ao222qc_assign2.Exercise2;

/**
 * Created by Adam on 2016-09-14.
 */
public class FerryMain
{
    public static void main(String args[])
    {
        TransportFerry tf = new TransportFerry();

        for(int i = 0; i < 200; i++)
        {
            tf.embark(new Bicycle());
        }

        System.out.println(tf.toString());
    }
}
