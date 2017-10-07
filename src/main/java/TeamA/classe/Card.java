package TeamA.classe;

import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Card	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 07/10/17 21:48
 ...............................................................................................................................*/

public class Card implements Comparable<Card>
{
    private int    value;
    private String name;

    public Card (int value, String name) throws IllegalArgumentException
    {
        if (value < 2 || value > 14) throw new IllegalArgumentException("Value is not in the correct bounds (min 2, max 14)");
        if (!Arrays.asList("Ca", "Co", "Tr", "Pi").contains(name)) throw new IllegalArgumentException(
                "Color of the card is not valid (not in {Ca, Co, Tr, Pi}");

        this.value = value;
        this.name = name;
    }

    public int getValue ()
    {
        return value;
    }

    public String getStringValue ()
    {
        String s = toString();

        return s.substring(0, s.length() - 2);
    }

    public void setValue (int value)
    {
        this.value = value;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public int compareTo (Card card) throws IllegalArgumentException
    {
        if (card == null) throw new IllegalArgumentException("Parameter is null");

        return Integer.compare(this.value, card.value);
    }

    @Override
    public boolean equals (Object obj)
    {
        if (obj == null || !(obj instanceof Card)) return false;

        Card cmpCard = (Card) obj;

        return this.getValue() == cmpCard.getValue() && this.getName().equals(cmpCard.getName());
    }

    @Override
    public String toString ()
    {
        String strValue;
        switch (getValue())
        {
            case 11:
                strValue = "V";
                break;

            case 12:
                strValue = "D";
                break;

            case 13:
                strValue = "R";
                break;

            case 14:
            case 1: //Dans le cas d'une suite As,2,3,4,5 l'As vaut 1 pour les comparaisons.
                strValue = "A";
                break;

            default:
                strValue = String.valueOf(getValue());
                break;
        }


        return strValue + getName();
    }
}

