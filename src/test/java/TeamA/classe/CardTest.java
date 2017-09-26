package TeamA.classe;

import org.junit.Test;

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
 . Last Modified : 26/09/17 08:45
 ...............................................................................................................................*/

@SuppressWarnings ("Duplicates")
public class CardTest
{
    @Test
    public void compareTo () throws Exception
    {
        Card c1 = getAllCards().get(getRandomInt(getAllCards().size()));
        Card c2 = getAllCards().get(getRandomInt(getAllCards().size()));

        assertEquals(Integer.compare(c1.getValue(), c2.getValue()), c1.compareTo(c2));
    }

    @Test
    public void equals () throws Exception
    {
        int index = getRandomInt(getAllCards().size());

        Card c1 = getAllCards().get(index);
        Card c2 = getAllCards().get(index);
        Card c3 = new Card(c1.getValue() + 1, c1.getName());

        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
    }

    @Test
    public void toStringTest () throws Exception
    {
        Card c1 = getAllCards().get(getRandomInt(getAllCards().size()));

        assertEquals(c1.getValue() + c1.getName(), c1.toString());
    }
}