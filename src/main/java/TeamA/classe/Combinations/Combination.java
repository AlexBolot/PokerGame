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
 . Last Modified : 07/10/17 20:12
 ...............................................................................................................................*/

abstract public class Combination implements Comparable<Combination>
{
    private ArrayList<Card> restOfCards = new ArrayList<>();
    private int value;

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

    public Card gethighestcard (ArrayList<Card> cards) throws IllegalArgumentException
    {
        if (cards == null) throw new IllegalArgumentException("Parameter is null");
        if (cards.isEmpty()) throw new IllegalArgumentException("List given in parameter is empty");

        Card highest = cards.get(0);

        for (Card C : cards)
        {
            if (C.compareTo(highest) > 0) highest = C;
        }

        return (highest);
    }

    @Override
    public int compareTo (Combination o) throws IllegalArgumentException
    {
        if (o == null) throw new IllegalArgumentException("Parameter is null");

        return Integer.compare(getValue(), o.getValue());
    }
}
