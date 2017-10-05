package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;
import java.util.Collections;

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
 . Last Modified : 05/10/17 10:10
 ...............................................................................................................................*/

@SuppressWarnings ("unchecked")
public class PlusHauteCarte extends Combination
{
    public PlusHauteCarte (ArrayList<Card> hand)
    {
        super(hand);
        setValue(0);
    }

    @Override
    public int compareTo (Combination phc)
    {
        int result = super.compareTo(phc);

        if (result != 0) return result;

        Collections.sort(this.getRestOfCards(), Collections.<Card>reverseOrder());
        Collections.sort(phc.getRestOfCards(), Collections.<Card>reverseOrder());

        for (int i = 0; i < this.getRestOfCards().size(); i++)
        {
            Card thisCard = this.getRestOfCards().get(i);
            Card phcCard = phc.getRestOfCards().get(i);

            result = thisCard.compareTo(phcCard);

            if (result != 0) return result;
        }

        return 0;
    }
}