package TeamA.classe;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

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
 . Last Modified : 24/09/17 22:03
 ...............................................................................................................................*/

@SuppressWarnings ("Duplicates")
public class CardTest
{
    private static ArrayList<Card> allCards = new ArrayList<>();
    private        Random          random   = new Random();

    @BeforeClass
    public static void beforeClass () throws Exception
    {
        for (int i = 1; i < 14; i++)
        {
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
        }
    }

    @Test
    public void compareTo () throws Exception
    {
        Card c1 = allCards.get(random.nextInt(allCards.size()));
        Card c2 = allCards.get(random.nextInt(allCards.size()));

        assertEquals(Integer.compare(c1.getValue(), c2.getValue()), c1.compareTo(c2));
    }

    @Test
    public void equals () throws Exception
    {
        int index = random.nextInt(allCards.size());

        Card c1 = allCards.get(index);
        Card c2 = allCards.get(index);
        Card c3 = new Card(c1.getValue() + 1, c1.getName());

        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
    }

    @Test
    public void toStringTest () throws Exception
    {
        Card c1 = allCards.get(random.nextInt(allCards.size()));

        assertEquals(c1.getValue() + c1.getName(), c1.toString());
    }
}