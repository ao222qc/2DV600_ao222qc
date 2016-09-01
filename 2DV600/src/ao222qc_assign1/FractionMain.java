package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-01.
 */
public class FractionMain
{
    public static void main(String args[]) throws Exception
    {
        Fraction frac = new Fraction(2,6);
        Fraction frac2 = new Fraction(2, 4);
        System.out.println(frac.toString());
        System.out.println(frac2.toString());
        System.out.println("Equal?: "+frac.isEqualTo(frac2));

        Fraction addedFrac = frac.add(frac2);
        System.out.println("Addition: "+addedFrac.toString());
        System.out.println("Negative: "+addedFrac.isNegative());
        Fraction subFrac = frac.subtract(frac2);
        System.out.println("Subtraction: "+subFrac.toString());
        System.out.println("Negative: "+subFrac.isNegative());
        Fraction multiplyFrac = frac.multiply(frac2);
        System.out.println("Multiplication: "+multiplyFrac.toString());
        Fraction divideFrac = frac.divide(frac2);
        System.out.println("Division: "+divideFrac.toString());
    }
}
