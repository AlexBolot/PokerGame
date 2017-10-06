package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;
import java.util.Collections;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Suite	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 21:44
 ...............................................................................................................................*/

@SuppressWarnings ("unchecked")
public class Suite extends Combination
{
    private Card start;

    public Suite (ArrayList<Card> hand) throws IllegalArgumentException
    {
        //Has to be done at first line...
        super(hand);

        Card start = FindSuite(hand);

        if (start == null) throw new IllegalArgumentException("Parameter does not contain a " + getClass().getSimpleName());

        this.start = start;
        setValue(5);
    }

    public static boolean isTypeOf (ArrayList<Card> cards) throws IllegalArgumentException
    {
        if (cards == null) throw new IllegalArgumentException("Parameter is null");
        if (cards.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + cards.size() + " != 5");

        return (FindSuite(cards) != null);
    }

    public static Card FindSuite (ArrayList<Card> cards) throws IllegalArgumentException
    {
        if (cards == null) throw new IllegalArgumentException("Parameter is null");
        if (cards.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + cards.size() + " != 5");

        Collections.sort(cards);
        int s = 0;
        for (int i = 0; i < cards.size() - 1; i++)
        {
            if (cards.get(i).getValue() + 1 == cards.get(i + 1).getValue())
            {
                s++;
            }
        }
        if (s == 4) return cards.get(0);
        if (cards.get(4).getValue() == 14)
        {
            ArrayList<Card> clone = (ArrayList<Card>) cards.clone();
            clone.get(4).setValue(1);
            return FindSuite(clone);
        }
        return null;
    }

    public Card getStart ()
    {
        return start;
    }

    public void setStart (Card start)
    {
        this.start = start;
    }

    @Override
    public int compareTo (Combination o) throws IllegalArgumentException
    {
        if (o == null) throw new IllegalArgumentException("Parameter is null");

        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;
        Suite s = (Suite) o;
        return start.compareTo(s.getStart());
    }

    @Override
    public String toString ()
    {
        return this.getClass().getSimpleName() + " qui commence à " + this.getStart();
    }
}
