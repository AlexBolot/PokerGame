package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Paire	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Paire extends Combination
{
    private Card paire;
    public Paire (ArrayList<Card> hand)
    {
        super(hand);
        setValue(1);
    }
    public static boolean isTypeOf(ArrayList<Card> cards){
        for (int i=0; i<5;i++){
            for(int j=i+1; j<5;j++) {
                if (cards.get(j).compareTo(cards.get(i))==0)
                {
                    return(true);
                }

            }
        }
        return(false);
    }

    public Card getPaire() {
        return paire;
    }

    public void setPaire(Card paire) {
        this.paire = paire;
    }

    @Override
    public int compareTo(Combination otherComb) {
        int valueCompare = super.compareTo(otherComb);
        if(valueCompare!=0){
            return valueCompare;
        }
        Paire otherPair = (Paire) otherComb;
        int cardCompare = this.paire.compareTo(otherPair.paire);
        if(cardCompare != 0){
            return cardCompare;
        }
        PlusHauteCarte reste = new PlusHauteCarte(this.getHand());
        PlusHauteCarte autreReste = new PlusHauteCarte(otherPair.getHand());
        return reste.compareTo(autreReste);
    }
}
