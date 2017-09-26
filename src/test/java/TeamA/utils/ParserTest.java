package TeamA.utils;

import TeamA.classe.Card;
import TeamA.classe.Hand;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Random;

import static TeamA.TestingUtils.getAllCards;

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
 . Last Modified : 26/09/17 08:43
 ...............................................................................................................................*/

public class ParserTest
{
    private Hand hand;

    @Before
    public void before ()
    {
        ArrayList<Card> cards1 = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            int index = new Random().nextInt(getAllCards().size());
            cards1.add(getAllCards().get(index));
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