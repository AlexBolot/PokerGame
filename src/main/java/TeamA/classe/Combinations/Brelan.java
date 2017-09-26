package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Brelan	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Brelan extends Combination
{
    private Card triplet;
    public Brelan (ArrayList<Card> hand)
    {
        super(hand);
    }

    public Card getTriplet() {
        return triplet;
    }

    public void setTriplet(Card triplet) {
        this.triplet = triplet;
    }

    public static boolean isTypeOf(ArrayList<Card> cards){
        return(false);
    }
}
