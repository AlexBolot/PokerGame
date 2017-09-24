package TeamA.utils;

import TeamA.classe.Card;
import TeamA.classe.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The ParserTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 24/09/17 20:46
 ...............................................................................................................................*/

public class ParserTest
{
    private static ArrayList<Card> allCards = new ArrayList<>();
    private Hand hand;

    @BeforeClass
    public static void beforeClass ()
    {
        for (int i = 1; i < 14; i++)
        {
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
        }
    }

    @Before
    public void before ()
    {
        ArrayList<Card> cards1 = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            int index = new Random().nextInt(allCards.size());
            cards1.add(allCards.get(index));
        }

        hand = new Hand(cards1);
    }

    @Test
    public void testReadCards () throws Exception
    {
        ByteArrayInputStream in = new ByteArrayInputStream(hand.toString().getBytes());
        System.setIn(in);

        Assert.assertEquals(hand.getHand(), Parser.readCards().getHand());
    }
}