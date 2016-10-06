package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-01.
 */
public class Fraction
{
    private int numerator;
    private int denominator;

    public Fraction(int n, int d) throws Exception
    {
        setNumerator(n);
        setDenominator(d);
        this.simplify();    //Simplify to lowest common denominator each time a new Fraction is created.
    }

    public boolean isNegative()
    {
        return ((double)this.numerator / (double)this.denominator) < 0;
    }

    public Fraction add(Fraction fract2) throws Exception
    {
        int num = 0;
        int den = 0;
        try
        {
            num = ((fract2.numerator * this.denominator)) + (this.numerator * fract2.denominator);
            den = this.denominator * fract2.denominator;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return new Fraction(num, den);
    }

    public Fraction subtract(Fraction fract2) throws Exception
    {
        try
        {
            Fraction frac = new Fraction(((this.getNumerator() * fract2.getDenominator()) -
                    (fract2.getNumerator() * this.getDenominator())),
                    (this.getDenominator() * fract2.getDenominator()));
            return frac;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Fraction multiply(Fraction fract2) throws Exception
    {
        try
        {
            Fraction frac = new Fraction(((this.getNumerator() * 1) *
                    (1 * this.getDenominator())),
                    (this.getDenominator() * fract2.getDenominator()));
            return frac;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public Fraction divide(Fraction fract2) throws Exception
    {
        try
        {
            Fraction frac = new Fraction((this.getNumerator() * fract2.getDenominator()), (this.getDenominator() * fract2.getNumerator()));

            return frac;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void simplify()
    {
        int num = this.getNumerator();
        int den = this.getDenominator();

        while(den != 0)
        {
            int temp = den;
            den = num % den;
            num = temp;
        }
        int gcd = num;
        this.numerator /= gcd;
        this.denominator /= gcd;
    }

    private void setNumerator(int n)
    {
        this.numerator = n;
    }

    public int getNumerator()
    {
        return this.numerator;
    }

    private void setDenominator(int d) throws Exception
    {
        try
        {
            if(d == 0)
            {
                throw new Exception("Denominator cannot be set to zero! Program will terminate.");
            }

            this.denominator = d;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public int getDenominator()
    {
        return this.denominator;
    }

    public boolean isEqualTo(Fraction fract2)
    {
        return this.getDenominator() * fract2.getNumerator() == this.getNumerator() * fract2.getDenominator();
    }

    public String toString()
    {
        return "Fraction: " + this.getNumerator() + "/" + this.getDenominator();
    }



}
