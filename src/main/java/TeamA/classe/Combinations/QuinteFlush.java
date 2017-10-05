package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

import static TeamA.classe.Combinations.Suite.FindSuite;

/*................................................................................................................................
 . Copyright (c)
 .
 . The QuiteFlush	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class QuinteFlush extends Combination
{
    private Card start;

    public Card getStart() {
        return start;
    }

    public void setStart(Card start) {
        this.start = start;
    }
    public QuinteFlush (ArrayList<Card> hand)
    {
        super(hand);
        start=FindQuinteFlush(hand);
        setValue(8);
    }
    public static Card FindQuinteFlush(ArrayList<Card> cards) {
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
    public int compareTo(Combination o) {
        int comCompare = super.compareTo(o);
        if (comCompare != 0) return comCompare;
        return this.getStart().compareTo(((QuinteFlush) o).getStart());
    }
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        sb.append(" de ");
        sb.append(this.getStart());
        return sb.toString();
    }
}
