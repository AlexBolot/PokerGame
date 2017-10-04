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
    public Card getStart() {
        return start;
    }

    public void setStart(Card start) {
        this.start = start;
    }

    private Card start;
    public QuinteFlush (ArrayList<Card> hand)
    {
        super(hand);
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
}
