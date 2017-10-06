package TeamA.classe;

import org.junit.Test;

import java.util.Arrays;

import static TeamA.TestingUtils.getAllCards;
import static TeamA.TestingUtils.getRandomInt;
import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The CardTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 22:23
 ...............................................................................................................................*/

public class CardTest
{
    //region //============= Constructor (x4) =============//
    @Test
    public void constructor_Right ()
    {
        int randVal = getRandomInt(14) + 1;
        String randColor = Arrays.asList("Co", "Ca", "Tr", "Pi").get(getRandomInt(4));

        Card c = new Card(randVal, randColor);

        assertEquals(randVal, c.getValue());
        assertEquals(randColor, c.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_InferiorValue ()
    {
        String randColor = Arrays.asList("Co", "Ca", "Tr", "Pi").get(getRandomInt(4));

        Card c = new Card(1, randColor);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_SuperiorValue ()
    {
        String randColor = Arrays.asList("Co", "Ca", "Tr", "Pi").get(getRandomInt(4));

        // 14 is the highest : the As card
        Card c = new Card(15, randColor);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_InvalidColor ()
    {
        int randVal = getRandomInt(14) + 1;

        // 14 is the highest : the As card
        Card c = new Card(randVal, "Bo");
    }
    //endregion ===========================================//

    //region //============== compareTo (x2) ==============//
    @Test
    public void compareTo_Right ()
    {
        Card c1 = getAllCards().get(getRandomInt(getAllCards().size()));
        Card c2 = getAllCards().get(getRandomInt(getAllCards().size()));

        assertEquals(Integer.compare(c1.getValue(), c2.getValue()), c1.compareTo(c2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void compareTo_NullParam ()
    {
        Card c1 = getAllCards().get(getRandomInt(getAllCards().size()));

        c1.compareTo(null);
    }
    //endregion ===========================================//

    //region //=============== equals (x2) ================//
    @Test
    public void equals_Right ()
    {
        int index = getRandomInt(getAllCards().size());

        Card c1 = getAllCards().get(index);
        Card c2 = getAllCards().get(index);

        Card c3 = new Card(5, "Ca");
        Card c4 = new Card(5, "Pi");
        Card c5 = new Card(6, "Tr");

        //Comparing 2 identical cards picked randomly
        assertTrue(c1.equals(c2));

        //Comparing 2 cards of same value but different color
        assertFalse(c3.equals(c4));

        //Comparing 2 cards of different value but same color
        assertFalse(c3.equals(c5));
    }

    @Test
    public void equals_NullParam ()
    {
        Card c1 = getAllCards().get(getRandomInt(getAllCards().size()));

        assertFalse(c1.equals(null));
    }
    //endregion ===========================================//

    //region //================= toString =================//
    @Test
    public void ToString ()
    {
        Card c1 = getAllCards().get(getRandomInt(getAllCards().size()));

        assertEquals(c1.getValue() + c1.getName(), c1.toString());
    }
    //endregion ===========================================//
}