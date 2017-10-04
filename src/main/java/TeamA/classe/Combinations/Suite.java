package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;
import java.util.Collections;

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
        start=FindSuite(hand);
        setValue(5);
    }
    public static boolean isTypeOf(ArrayList<Card> cards){

        return(FindSuite(cards)!=null);
    }
    public static Card FindSuite(ArrayList<Card> cards) {
        Collections.sort(cards);
        int s=0;
        for (int i = 0; i < 4; i++) {

            if (cards.get(i).getValue()+1==cards.get(i+1).getValue()){
                s++;
            }
        }
        if (cards.get(4).getValue() == 14) {
            ArrayList<Card> clone = (ArrayList<Card>) cards.clone();
            clone.get(4).setValue(1);
            return FindSuite(clone);
        }
        return s == 4 ? cards.get(0) : null;
    }


    @Override
    public int compareTo(Combination o) {
        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;
        Suite s = (Suite) o;
        return start.compareTo(s.getStart());
    }
}
