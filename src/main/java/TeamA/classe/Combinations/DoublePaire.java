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
        if(DoublePaire.FindDoublePaire(cards)!=null)
            return true;
        else
            return false;
    }
    public static Card[] FindDoublePaire(ArrayList<Card> hand){
        int tab[] = new int[14], compteur = 0;
        Card returntab[] = new Card[2];

        for( Card c : hand){ // on compte les occcurences des cartes
            tab[c.getValue()] += 1;
        }
        for(int i=0; i<tab.length; i++){ // on parcoure le tableau des occurences
            if(tab[i] == 2) { // si la carte est en double alors on la stock dans un tableau
                returntab[compteur] = new Card(i,"");
                compteur++;
            }
        }
        if (compteur == 2) // on retoune le tab uniquement s'il contient deux paires
            return returntab;
        else
            return null;
    }
}
