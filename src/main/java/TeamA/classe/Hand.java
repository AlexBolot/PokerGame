package TeamA.classe;

import TeamA.classe.Combinations.*;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Hand	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 23:20
 ...............................................................................................................................*/

public class Hand
{
    private ArrayList<Card> hand = new ArrayList<>();

    public Hand (ArrayList<Card> hand) throws IllegalArgumentException
    {
        if (hand == null) throw new IllegalArgumentException("Parameter is null");
        if (hand.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + hand.size() + " != 5");

        this.hand = hand;
    }

    public ArrayList<Card> getHand ()
    {
        return hand;
    }

    public void setHand (ArrayList<Card> hand)
    {
        this.hand = hand;
    }

    public Combination findBestCombination ()
    {
        if (QuinteFlush.isTypeOf(hand)) return new QuinteFlush(hand);
        if (Carre.isTypeOf(hand)) return new Carre(hand);
        if (Full.isTypeOf(hand)) return new Full(hand);
        if (Couleur.isTypeOf(hand)) return new Couleur(hand);
        if (Suite.isTypeOf(hand)) return new Suite(hand);
        if (Brelan.isTypeOf(hand)) return new Brelan(hand);
        if (DoublePaire.isTypeOf(hand)) return new DoublePaire(hand);
        if (Paire.isTypeOf(hand)) return (new Paire(hand));

        return new PlusHauteCarte(hand);
    }

    public String toString ()
    {
        StringBuilder affHand = new StringBuilder();

        for (Card c : hand)
        {
            affHand.append(c).append(" ");
        }

        affHand.deleteCharAt(affHand.length() - 1);

        return affHand.toString();
    }
}
