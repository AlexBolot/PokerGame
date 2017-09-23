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
 . Last Modified : 24/09/17 01:19
 ...............................................................................................................................*/

public class ParserTest
{
    private static ArrayList<Card> allCards = new ArrayList<>();
    private Hand hand1;
    private Hand hand2;

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

        hand1 = new Hand(cards1);

        ArrayList<Card> cards2 = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            int index = new Random().nextInt(allCards.size());
            cards2.add(allCards.get(index));
        }

        hand2 = new Hand(cards2);
    }

    @Test
    public void testReadCards () throws Exception
    {
        StringBuilder str = new StringBuilder();

        for (Card c : hand1.getHand())
        {
            str.append(c).append(" ");
        }

        str.deleteCharAt(str.length() - 1);

        ByteArrayInputStream in = new ByteArrayInputStream(str.toString().getBytes());
        System.setIn(in);

        Assert.assertEquals(hand1.getHand(), Parser.readCards().getHand());
    }
}