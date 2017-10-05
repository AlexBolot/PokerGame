package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Brelan	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 03/10/17 18:23
 ...............................................................................................................................*/

public class Brelan extends Combination
{
    private Card triplet;

    public Brelan (ArrayList<Card> hand)
    {
        super(hand);
        triplet = FindBrelan(hand);

        //noinspection unchecked
        ArrayList<Card> reducedHand = (ArrayList<Card>) hand.clone();
        for (Card c : hand)
        {
            if (c.compareTo(triplet) == 0) reducedHand.remove(c);
        }

        this.setRestOfCards(reducedHand);
        this.setValue(3);
    }

    public static Card FindBrelan (ArrayList<Card> hand)
    {
        int[] tab = new int[15];
        Card carteBrelan = null;

        for (Card c : hand)
        {
            tab[c.getValue()] += 1;
        }

        for (int i = 0; i < tab.length; i++)
        {
            if (tab[i] == 3)
            {
                carteBrelan = new Card(i, "");
            }
        }
        return carteBrelan;
    }

    public Card getTriplet ()
    {
        return triplet;
    }

    public static boolean isTypeOf (ArrayList<Card> cards)
    {
        return FindBrelan(cards) != null;
    }

    public void setTriplet (Card triplet)
    {
        this.triplet = triplet;
    }

    @Override
    public int compareTo (Combination o)
    {
        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;

        Brelan brelan = (Brelan) o;

        valueCompare = getTriplet().compareTo(brelan.getTriplet());
        if (valueCompare != 0) return valueCompare;

        PlusHauteCarte phc1 = new PlusHauteCarte(getRestOfCards());
        PlusHauteCarte phc2 = new PlusHauteCarte(brelan.getRestOfCards());

        return phc1.compareTo(phc2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(" de ");
        sb.append(this.getTriplet().getValue());
        return sb.toString();
    }
}
