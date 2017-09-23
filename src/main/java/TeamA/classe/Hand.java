package TeamA.classe;

import TeamA.classe.Combinations.Combination;
import TeamA.classe.Combinations.PlusHauteCarte;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Hand	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Hand {
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Hand(ArrayList<Card> hand){
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
    public Combination findBestCombination ()
    {
        return new PlusHauteCarte(hand);
    }
    public String toString(){
        String affHand = "";
        for(Card c : hand){
            affHand += c.getName()+'_';
        }
        return affHand;
    }

}
