package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Carre	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Carre extends Combination
{
    private Card quartet;
    public Carre (ArrayList<Card> hand)
    {
        super(hand);
        quartet = Carre.FindCarre(hand);
        //noinspection unchecked
        ArrayList<Card> reducedHand = (ArrayList<Card>) hand.clone();
        for (Card c : hand)
        {
            if (c.compareTo(quartet) == 0) reducedHand.remove(c);
        }

        this.setRestOfCards(reducedHand);
        this.setValue(7);
    }
    public Card getQuartet() {
        return quartet;
    }

    public void setQuartet(Card quartet) {
        this.quartet = quartet;
    }

    public static boolean isTypeOf(ArrayList<Card> cards){
        return Carre.FindCarre(cards) != null;
    }
    public static Card FindCarre (ArrayList<Card> hand)
    {
        int[] tab = new int[15];
        Card carteCarre = null;

        for (Card c : hand)
        {
            tab[c.getValue()] += 1;
        }

        for (int i = 0; i < tab.length; i++)
        {
            if (tab[i] == 4)
            {
                carteCarre = new Card(i, "");
            }
        }
        return carteCarre;
    }
    @Override
    public int compareTo (Combination o)
    {
        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;

        Carre carre = (Carre) o;

        valueCompare = getQuartet().compareTo(carre.getQuartet());
        if (valueCompare != 0) return valueCompare;

        PlusHauteCarte phc1 = new PlusHauteCarte(getRestOfCards());
        PlusHauteCarte phc2 = new PlusHauteCarte(carre.getRestOfCards());

        return phc1.compareTo(phc2);
    }
}
