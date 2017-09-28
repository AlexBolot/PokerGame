package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;
import java.util.HashMap;

/*................................................................................................................................
 . Copyright (c)
 .
 . The DoublePaire	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class DoublePaire extends Combination
{
    private Card strongPaire;
    private Card weakPaire;
    public DoublePaire (ArrayList<Card> hand)
    {
        super(hand);
    }

    public Card getStrongPaire() {
        return strongPaire;
    }

    public void setStrongPaire(Card strongPaire) {
        this.strongPaire = strongPaire;
    }

    public Card getWeakPaire() {
        return weakPaire;
    }

    public void setWeakPaire(Card weakPaire) {
        this.weakPaire = weakPaire;
    }

    public static boolean isTypeOf(ArrayList<Card> cards){
        int tab[] = new int[14], compteur = 0;
        for( Card c : cards){
            tab[c.getValue()] += 1;
        }
        for(int occurence : tab){
            if(occurence == 2)
                compteur++;
        }
        if(compteur == 2)
            return true;
        else
            return false;
    }
}