package TeamA.classe;

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
 . Last Modified : 05/10/17 11:41
 ...............................................................................................................................*/

public class Card implements Comparable<Card>
{
    private int    value;
    private String name;

    public Card (int value, String name)
    {
        this.value = value;
        this.name = name;
    }

    public int getValue ()
    {
        return value;
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

    public int compareTo (Card card)
    {
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
                strValue = "A";
                break;

            default:
                strValue = String.valueOf(getValue());
                break;
        }


        return strValue + getName();
    }
}

