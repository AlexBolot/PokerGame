package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Paire	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 02/10/17 23:48
 ...............................................................................................................................*/

public class Paire extends Combination
{
    private Card paire;

    public Paire (ArrayList<Card> hand)
    {
        super(hand);
        paire = FindPaire(hand);

        //noinspection unchecked
        ArrayList<Card> reducedHand = (ArrayList<Card>) hand.clone();

        for (Card c : hand)
        {
            if (c.compareTo(paire) == 0) reducedHand.remove(c);
        }

        this.setRestOfCards(reducedHand);
        this.setValue(1);
    }

    public static boolean isTypeOf (ArrayList<Card> cards)
    {
        return FindPaire(cards) != null;
    }

    private static Card FindPaire (ArrayList<Card> hand)
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = i + 1; j < 5; j++)
            {
                if (hand.get(j).compareTo(hand.get(i)) == 0) return (hand.get(i));
            }
        }

        return null;
    }

    public Card getPaire ()
    {
        return paire;
    }

    public void setPaire (Card paire)
    {
        this.paire = paire;
    }

    @Override
    public int compareTo (Combination otherComb)
    {
        int valueCompare = super.compareTo(otherComb);

        if (valueCompare != 0) return valueCompare;

        Paire otherPair = (Paire) otherComb;
        int cardCompare = this.paire.compareTo(otherPair.paire);

        if (cardCompare != 0) return cardCompare;

        PlusHauteCarte reste = new PlusHauteCarte(this.getRestOfCards());
        PlusHauteCarte autreReste = new PlusHauteCarte(otherPair.getRestOfCards());

        return reste.compareTo(autreReste);
    }
}
