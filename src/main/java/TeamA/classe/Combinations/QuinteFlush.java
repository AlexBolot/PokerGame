package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

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
    }
    public static boolean isTypeOf(ArrayList<Card> cards){
        return(false);
    }

    @Override
    public int compareTo(Combination o) {
        int comCompare = super.compareTo(o);
        if (comCompare != 0) return comCompare;
        return this.getStart().compareTo(((QuinteFlush) o).getStart());
    }
}
