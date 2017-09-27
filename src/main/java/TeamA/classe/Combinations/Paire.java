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
        paire=FindPaire(hand);
        setValue(1);
        hand.remove(hand.indexOf(paire));
        hand.remove(hand.indexOf(paire));
        //hand a maintenant uniquement 3 cartes dans la main vu qu'on a enlevé la paire
        //TODO En cas de paires égales on doit pouvoir trouver la main qui gagne grâce à la plus haute carte
    }
    public static boolean isTypeOf(ArrayList<Card> cards){
        if (FindPaire(cards)!=null){
            return(true);
        }
        return(false);
    }
    private static Card FindPaire(ArrayList<Card> hand){

        for (int i=0; i<5;i++){
            for(int j=i+1; j<5;j++) {
                if (hand.get(j).compareTo(hand.get(i))==0)
                {
                    return(hand.get(i));
                }

            }
        }
        return null;

    }
    public Card getPaire() {
        return paire;
    }

    public void setPaire(Card paire) {
        this.paire = paire;
    }
}
