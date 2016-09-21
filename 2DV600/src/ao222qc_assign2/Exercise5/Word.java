package ao222qc_assign2.Exercise5;

/**
 * Created by Adam on 2016-09-21.
 */
public class Word implements Comparable<Word> {
    private String word;

    public Word(String str)
    {
        word = str;
    }
    public String toString()
    {
        return word;
    }
    /* Override Object methods */
    @Override
    public int hashCode()
    {
        //"compute a hash value for word"
        int hc = 0;
        String tempWord = word.toLowerCase();
        for(int i = 0; i< tempWord.length(); i++)
        {
            char c = tempWord.charAt(i);
            hc += Character.getNumericValue(c);
        }
        return hc;
    }
    @Override
    public boolean equals(Object other)
    {
        //"true if two words are equal"
        //Check hashcodes????
        Word otherWord;
        if(other instanceof Word)
        {
             otherWord = (Word)other;
             return this.word.toLowerCase().equals(otherWord.word.toLowerCase());
        }
        return this.word.toLowerCase().equals(other.toString().toLowerCase());
    }
    /* Implement Comparable */
    @Override
    public int compareTo(Word w)
    {
        //"compares two words lexicographically"
        return this.word.compareToIgnoreCase(w.word);
    }
}
