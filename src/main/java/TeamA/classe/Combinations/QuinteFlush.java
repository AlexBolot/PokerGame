package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

import static TeamA.classe.Combinations.Suite.FindSuite;

/*................................................................................................................................
 . Copyright (c)
 .
 . The QuinteFlush	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 21:45
 ...............................................................................................................................*/

public class QuinteFlush extends Combination
{
    private Card start;


    public QuinteFlush(ArrayList<Card> hand) throws IllegalArgumentException
    {
        super(hand);
        start=FindQuinteFlush(hand);
        if (start == null)
            throw new IllegalArgumentException("Parameter does not contain a " + getClass().getSimpleName());
        setValue(8);
    }

    public static Card FindQuinteFlush(ArrayList<Card> cards) throws IllegalArgumentException {
        if (cards == null) throw new IllegalArgumentException("Parameter is null");
        if (cards.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + cards.size() + " != 5");

        if (Couleur.isTypeOf(cards)) {
            if (Suite.isTypeOf(cards)) {
                return (FindSuite(cards));
            }
        }
        return null;
    }
    public static boolean isTypeOf(ArrayList<Card> cards){
        return(FindQuinteFlush(cards)!=null);
    }

    @Override
    public int compareTo(Combination o) throws IllegalArgumentException {
        if (o == null) throw new IllegalArgumentException("Parameter is null");
        int comCompare = super.compareTo(o);
        if (comCompare != 0) return comCompare;
        return this.getStart().compareTo(((QuinteFlush) o).getStart());
    }

    public Card getStart() {
        return start;
    }

    public void setStart(Card start) {
        this.start = start;
    }
    @Override
    public String toString () {
        return this.getClass().getSimpleName() + " qui commence à " + this.getStart();
    }
}
