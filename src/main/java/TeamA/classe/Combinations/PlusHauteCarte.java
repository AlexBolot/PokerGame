package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The PlusHauteCarte	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 02/10/17 23:48
 ...............................................................................................................................*/

public class PlusHauteCarte extends Combination {
   public int compareTo(PlusHauteCarte phc) {
       //fixme : plus haute carte doit pouvoir se comparer a d'autre combinaisons, faire un appel du super.compareto

       int result;
       ArrayList<Card> reste1 = (ArrayList<Card>) this.getRestOfCards().clone();
       ArrayList<Card> reste2 = (ArrayList<Card>) phc.getRestOfCards().clone();

        while (reste1.size()>0 && reste2.size()>0) {
            result = gethighestcard(reste1).compareTo(gethighestcard(reste2));
            if (result!=0) {
                return (result);
            }
            reste1.remove(reste1.indexOf(gethighestcard(reste1)));
            reste2.remove(reste2.indexOf(gethighestcard(reste2)));
        }
        return(0);
   }

    public PlusHauteCarte(ArrayList<Card> hand) {
        super(hand);
        setValue(0);
    }


}