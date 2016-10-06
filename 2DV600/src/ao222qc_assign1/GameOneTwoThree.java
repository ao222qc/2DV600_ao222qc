package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-02.
 */
public class GameOneTwoThree
{
    public static void main(String args[])
    {
        Deck deck;
        Card c;
        int winCount = 0;
        int total = 10000;

        for(int i = 0; i < total; i++)
        {
            deck = new Deck();
            deck.shuffle();

            if(play123(deck))
            {
                winCount++;
            }
        }

        System.out.println("Winrate : "+(double)winCount/total*100);
    }

    public static boolean play123(Deck deck)
    {
        int oneTwoThree = 0;

        for(int i = 0; i < 52; i++)
        {
            if(deck.handsOutNextCard().val.ordinal() == oneTwoThree) //Ordinal values ace = 0, Two = 1, Three = 2.
                return false;
            if(oneTwoThree >= 2)
                oneTwoThree = 0;
            else
                oneTwoThree++;
        }
        return true;
    }
}
