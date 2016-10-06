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
    public ArrayList<Card> deck = new ArrayList<Card>(52);

    public Deck()
    {
        //outer loop for colours of card, spades, hearts etc represented by ordinal of enum.
        for(int i = 0; i < 4; i++)
        {
            //inner loop for value of card, also here represented by ordinal of enum.
            for(int k = 0; k < 13; k++)
            {
                deck.add(new Card(i, k));
            }
        }
    }

    public List<Card> getDeck()
    {
        return deck;
    }

    public void shuffle()
    {
        if(deck.size() < 52)
        {
            System.out.println("No");
            System.exit(0);
        }

        Collections.shuffle(deck);
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
