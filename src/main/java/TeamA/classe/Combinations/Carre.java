package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Carre	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Carre extends Combination
{
    public Card getQuartet() {
        return quartet;
    }

    public void setQuartet(Card quartet) {
        this.quartet = quartet;
    }

    private Card quartet;
    public Carre (ArrayList<Card> hand)
    {
        super(hand);
    }
    public static boolean isTypeOf(ArrayList<Card> cards){
        return(false);
    }
}
