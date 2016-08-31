package ao222qc_assign1;

/**
 * Created by Adam on 2016-08-31.
 */
public class Point
{
    int x;
    int y;

    public static void main(String args[])
    {
        Point p1 = new Point();
        Point p2 = new Point(3, 4);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        if (p1.isEqualTo(p2))              // False!
            System.out.println("The two points are equal");

        double dist = p1.distanceTo(p2);
        System.out.println("Point Distance: "+dist);

        p2.move(5,-2);         // ==> (8,2)
        p1.moveToXY(8,2);      // ==> (8,2)

        if (p1.isEqualTo(p2))              // True!
            System.out.println("The two points are equal");
    }

    public Point()
    {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public boolean isEqualTo(Point point2)
    {
        return this.x == point2.x && this.y == point2.y;
    }

    public void move(int x, int y)
    {
        this.x += x;
        this.y += y;
    }

    public void moveToXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Point point2)
    {
        int xDiff = this.x - point2.x;
        xDiff = xDiff*xDiff;
        int yDiff = this.y - point2.y;
        yDiff = yDiff*yDiff;
        return Math.sqrt(xDiff + yDiff);
    }

    public String toString()
    {
        return "(" + this.x + "," + this.y +")";
    }
}
