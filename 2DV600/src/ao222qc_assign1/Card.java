package ao222qc_assign1;

/**
 * Created by Adam on 2016-09-01.
 */

import java.util.Map;
import java.util.HashMap;

public class Card
{
    public enum Suit
    {
        Clubs, Diamonds, Hearts, Spades;
        public static final Suit values[] = values();
    }

    public enum Value
    {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King;
        public static final Value values[] = values();
    }

    public Suit suit;
    public Value val;


    public Card(int colourVal, int cardVal)
    {
        this.suit = Suit.values[colourVal];
        this.val = Value.values[cardVal];
    }
}
