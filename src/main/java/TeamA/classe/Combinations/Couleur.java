package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Couleur	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 07/10/17 21:49
 ...............................................................................................................................*/

public class Couleur extends Combination
{
    private String color;

    public Couleur (ArrayList<Card> hand) throws IllegalArgumentException
    {
        //Has to be done at first line...
        super(hand);
        String color = FindColor(hand);
        if (color == null) throw new IllegalArgumentException("Parameter does not contain a " + getClass().getSimpleName());
        this.color = color;
        this.setValue(5);
    }

    public static boolean isTypeOf (ArrayList<Card> hand) throws IllegalArgumentException
    {
        if (hand == null) throw new IllegalArgumentException("Parameter is null");
        if (hand.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + hand.size() + " != 5");

        return Couleur.FindColor(hand) != null;
    }

    public static String FindColor (ArrayList<Card> hand) throws IllegalArgumentException
    {
        if (hand == null) throw new IllegalArgumentException("Parameter is null");
        if (hand.size() != 5) throw new IllegalArgumentException("Invalid size of param : " + hand.size() + " != 5");

        String color = hand.get(1).getName();
        for (Card c : hand)
        {
            if (!color.equals(c.getName()))
            {
                return null;
            }
        }
        return color;
    }

    public String getColor ()
    {
        return color;
    }

    @Override
    public int compareTo (Combination o) throws IllegalArgumentException
    {
        if (o == null) throw new IllegalArgumentException("Parameter is null");
        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;

        Couleur couleur = (Couleur) o;

        PlusHauteCarte phc1 = new PlusHauteCarte(getRestOfCards());
        PlusHauteCarte phc2 = new PlusHauteCarte(couleur.getRestOfCards());

        return phc1.compareTo(phc2);
    }

    @Override
    public String toString ()
    {
        return this.getClass().getSimpleName() + " avec carte haute : " + gethighestcard(getRestOfCards()).getStringValue();
    }
}
