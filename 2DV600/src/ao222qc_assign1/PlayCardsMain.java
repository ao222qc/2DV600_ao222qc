package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-01.
 */
public class PlayCardsMain
{
    public static void main(String args[])
    {
        Deck d = new Deck();

        d.shuffle();
        for(int i = 0; i < 10; i++)
        {
            System.out.println("Dealing card...\n");
            Card c = d.handsOutNextCard();
            System.out.println(c.val + " of " +  c.suit);
            System.out.println("Cards left: " + d.deckSize() + "\n");
        }

    }
}
