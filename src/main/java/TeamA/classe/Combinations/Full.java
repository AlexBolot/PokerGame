package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

import static TeamA.classe.Combinations.Brelan.FindBrelan;
import static TeamA.classe.Combinations.Paire.FindPaire;


/*................................................................................................................................
 . Copyright (c)
 .
 . The Full	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Full extends Combination
{
    private Card paire;
    private Card triplet;

    public Card getPaire() {
        return paire;
    }

    public void setPaire(Card paire) {
        this.paire = paire;
    }

    public Card getTriplet() {
        return triplet;
    }

    public void setTriplet(Card triplet) {
        this.triplet = triplet;
    }

    public Full(ArrayList<Card> hand) throws IllegalArgumentException
    {

        super(hand);
        Card[] cards = FindFull(hand);
        triplet = cards[0];
        paire = cards[1];
        if (triplet == null || paire == null)
            throw new IllegalArgumentException("Parameter does not contain a " + getClass().getSimpleName());
        setValue(6);
    }

    public static boolean isTypeOf(ArrayList<Card> cards) throws IllegalArgumentException {
        return(FindFull(cards)!=null);
    }

    public static Card[] FindFull(ArrayList<Card> cards) throws IllegalArgumentException {

        if (cards == null) throw new IllegalArgumentException("Parameter is null");
        if (cards.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + cards.size() + " != 5");

        Card card = null;
        Card cardP = null;
        Card[] tab = new Card[2];
        if (Brelan.isTypeOf(cards))
        {
            card = FindBrelan(cards);
            if(Paire.isTypeOf(cards))
            {
                cardP = FindPaire(cards);
                tab[0] = card;
                tab[1] = cardP;
                return (tab);
            }

        }
        return null;

    }

    @Override
    public int compareTo(Combination o) throws IllegalArgumentException {
        if (o == null) throw new IllegalArgumentException("Parameter is null");
        int combCompare = super.compareTo(o);
        if (combCompare != 0) return combCompare;
        Full otherFull = (Full) o;
        int bCompare = this.getTriplet().compareTo(otherFull.getTriplet());
        return bCompare;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(" au ");
        sb.append(this.getTriplet());
        sb.append(" par les ");
        sb.append(this.getPaire());
        return sb.toString();
    }
}
