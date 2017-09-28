package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

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
 . Last Modified : 28/09/17 10:57
 ...............................................................................................................................*/

public class DoublePaire extends Combination
{
    private Card strongPaire;
    private Card weakPaire;

    public DoublePaire (ArrayList<Card> hand)
    {
        super(hand);
    }

    public static Card[] FindDoublePaire (ArrayList<Card> hand){
        int tab[] = new int[14], compteur = 0;
        Card returntab[] = new Card[2];

        for( Card c : hand){ // on compte les occcurences des cartes
            tab[c.getValue()] += 1;
        }
        for(int i=0; i<tab.length; i++){ // on parcoure le tableau des occurences
            if(tab[i] == 2) { // si la carte est en double alors on la stock dans un tableau
                returntab[compteur] = new Card(i, "");
                compteur++;
            }
        }
        if (compteur == 2) // on retoune le tab uniquement s'il contient deux paires
            return returntab;
        else return null;
    }

    public Card getStrongPaire ()
    {
        return strongPaire;
    }

    public void setStrongPaire (Card strongPaire)
    {
        this.strongPaire = strongPaire;
    }

    public Card getWeakPaire ()
    {
        return weakPaire;
    }

    public static boolean isTypeOf (ArrayList<Card> cards)
    {
        if (DoublePaire.FindDoublePaire(cards) != null) return true;
        else return false;
    }

    public void setWeakPaire (Card weakPaire)
    {
        this.weakPaire = weakPaire;
    }

    @Override
    public int compareTo (Combination o)
    {
        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;

        DoublePaire doublePaire = (DoublePaire) o;

        valueCompare = getStrongPaire().compareTo(doublePaire.getStrongPaire());
        if (valueCompare != 0) return valueCompare;

        valueCompare = getWeakPaire().compareTo(doublePaire.getWeakPaire());
        if (valueCompare != 0) return valueCompare;

        PlusHauteCarte phc1 = new PlusHauteCarte(getHand());
        PlusHauteCarte phc2 = new PlusHauteCarte(doublePaire.getHand());

        return phc1.compareTo(phc2);
    }
}
