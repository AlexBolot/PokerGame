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
 . Last Modified : 05/10/17 11:57
 ...............................................................................................................................*/

public class DoublePaire extends Combination
{
    private Card strongPaire;
    private Card weakPaire;

    public DoublePaire (ArrayList<Card> hand)
    {
        super(hand);

        Card tab[] = FindDoublePaire(hand);

        //noinspection ConstantConditions
        int result = tab[0].compareTo(tab[1]);

        strongPaire = result > 0 ? tab[0] : tab[1];
        weakPaire = result > 0 ? tab[1] : tab[0];

        //noinspection unchecked
        ArrayList<Card> reducedHand = (ArrayList<Card>) hand.clone();

        for (Card c : hand)
        {
            if (c.compareTo(strongPaire) == 0) reducedHand.remove(c);
            if (c.compareTo(weakPaire) == 0) reducedHand.remove(c);
        }

        this.setRestOfCards(reducedHand);
        this.setValue(2);
    }

    public static boolean isTypeOf (ArrayList<Card> cards)
    {
        return FindDoublePaire(cards) != null;
    }

    public static Card[] FindDoublePaire (ArrayList<Card> hand)
    {
        int[] tab = new int[15];
        int compteur = 0;
        Card returntab[] = new Card[2];

        // on compte les occcurences des cartes
        for (Card c : hand)
        {
            tab[c.getValue()] += 1;
        }

        // on parcoure le tableau des occurences
        for (int i = 0; i < tab.length; i++)
        {
            // si la carte est en double alors on la stock dans un tableau
            if (tab[i] == 2)
            {
                returntab[compteur] = new Card(i, "");
                compteur++;
            }
        }

        // on retoune le tab uniquement s'il contient deux paires
        return compteur == 2 ? returntab : null;
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

        PlusHauteCarte phc1 = new PlusHauteCarte(getRestOfCards());
        PlusHauteCarte phc2 = new PlusHauteCarte(doublePaire.getRestOfCards());

        return phc1.compareTo(phc2);
    }

    @Override
    public String toString ()
    {
        return this.getClass().getSimpleName() + " avec paire de " + getStrongPaire() + " et de " + getWeakPaire();
    }
}
