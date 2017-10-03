package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Suite	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Suite extends Combination
{
    private Card start;

    public Card getStart() {
        return start;
    }

    public void setStart(Card start) {
        this.start = start;
    }

    public Suite (ArrayList<Card> hand)
    {
        super(hand);
    }
    public static boolean isTypeOf(ArrayList<Card> cards){
        return(false);
    }

    @Override
    public int compareTo(Combination o) {
        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;
        Suite s = (Suite) o;
        return start.compareTo(s.getStart());
    }
}
