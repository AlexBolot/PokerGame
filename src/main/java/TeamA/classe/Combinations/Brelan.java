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
 . Last Modified : 23/09/17 16:42
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

    public Card getTriplet() {
        return triplet;
    }

    public void setTriplet(Card triplet) {
        this.triplet = triplet;
    }

    public static boolean isTypeOf (ArrayList<Card> cards)
    {
        return FindBrelan(cards) != null;
    }

    public static Card FindBrelan(ArrayList<Card> hand){
        int[] tab = new int[14];
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
}
