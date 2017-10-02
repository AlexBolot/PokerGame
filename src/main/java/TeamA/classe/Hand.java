package TeamA.classe;

import TeamA.classe.Combinations.Combination;
import TeamA.classe.Combinations.DoublePaire;
import TeamA.classe.Combinations.Paire;
import TeamA.classe.Combinations.PlusHauteCarte;

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
 . Last Modified : 02/10/17 23:03
 ...............................................................................................................................*/

public class Hand
{
    private ArrayList<Card> hand = new ArrayList<>();

    public Hand (ArrayList<Card> hand)
    {
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

        return affHand.toString();
    }

}
