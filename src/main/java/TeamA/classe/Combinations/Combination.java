package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Combination	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 05/10/17 11:52
 ...............................................................................................................................*/

abstract public class Combination implements Comparable<Combination>
{
    private ArrayList<Card> restOfCards = new ArrayList<>();
    private int    value;

    public Combination (ArrayList<Card> restOfCards)
    {
        this.restOfCards = restOfCards;
    }

    public ArrayList<Card> getRestOfCards ()
    {
        return restOfCards;
    }

    public void setRestOfCards (ArrayList<Card> restOfCards)
    {
        this.restOfCards = restOfCards;
    }

    public int getValue ()
    {
        return value;
    }

    public void setValue (int value)
    {
        this.value = value;
    }

    public Card gethighestcard (ArrayList<Card> cards)
    {
        Card highest = cards.get(0);

        for (Card C : cards)
        {
            if (C.compareTo(highest) > 0) highest = C;
        }

        return (highest);
    }

    @Override
    public int compareTo (Combination o)
    {
        return Integer.compare(getValue(), o.getValue());
    }
}
