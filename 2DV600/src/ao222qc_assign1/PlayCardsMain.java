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
        for(int i = 0; i < 4; i++)
        {
            System.out.println("Dealing card...");
            Card c = d.handsOutNextCard();
            System.out.println(Card.Value.valueOf(c.getCardValue()) + " of " + Card.Suit.valueOf(c.getSuitValue()));
            System.out.println("Cards left: " + d.deckSize());
        }

    }
}
