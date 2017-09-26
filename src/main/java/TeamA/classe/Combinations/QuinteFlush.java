package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

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
 . Last Modified : 26/09/17 16:52
 ...............................................................................................................................*/

public class QuinteFlush extends Combination
{
    public QuinteFlush (ArrayList<Card> hand)
    {
        super(hand);
    }
    public static boolean isTypeOf(ArrayList<Card> cards){
        return(false);
    }
}
