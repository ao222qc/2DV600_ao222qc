package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-01.
 */
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private static List<Card> deck = new ArrayList<Card>(52);

    public Deck()
    {
        Card card;
        int arrIndex = 0;

        for(int k = 1; k <= 4; k++)
        {
            for (int i = 1; i <= 13; i++)
            {
                deck.add(new Card(k, i));
                arrIndex++;
            }
        }
    }

    public List<Card> getDeck()
    {
        return deck;
    }

    public void shuffle()
    {
        if(Deck.deck.size() < 52)
        {
            System.out.println("No");
            System.exit(0);
        }
        Collections.shuffle(Deck.deck);
    }

    public Card handsOutNextCard()
    {
        Card selectedCard = deck.get(0);
        deck.remove(0);
        return selectedCard;
    }

    public int deckSize()
    {
        return deck.size();
    }
}
