package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The QuinteFlushTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 17:03
 ...............................................................................................................................*/

public class QuinteFlushTest {
    private ArrayList<Card> card5Order;
    private ArrayList<Card> cards2;
    private ArrayList<Card> cards5Mixed;
    private ArrayList<Card> cardsPair2;

    @Before
    public void init() {

        card5Order = new ArrayList<>(
                Arrays.asList(
                        new Card(5, "Tr"),
                        new Card(6, "Tr"),
                        new Card(7, "Tr"),
                        new Card(8, "Tr"),
                        new Card(9, "Tr")));

        cards2 = new ArrayList<>(Arrays.asList(new Card(2, "Co"),
                new Card(4, "Co"),
                new Card(6, "Co"),
                new Card(5, "Co"),
                new Card(3, "Co")));
        cards5Mixed = new ArrayList<>(Arrays.asList(new Card(9, "Co"),
                new Card(5, "Co"),
                new Card(6, "Co"),
                new Card(7, "Co"),
                new Card(8, "Co")));
        cardsPair2 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(4, "Co"),
                new Card(2, "Pi"),
                new Card(5, "Tr"),
                new Card(2, "Pi")));

    }

    @Test
    public void testIsTypeOf() {

        assertTrue(QuinteFlush.isTypeOf(cards2));
        assertFalse(QuinteFlush.isTypeOf(cardsPair2));
    }

    @Test
    public void testCompareTo() throws Exception {

        QuinteFlush flush5 = new QuinteFlush(
                card5Order);
        QuinteFlush flush2 = new QuinteFlush(cards2);

        QuinteFlush flush5Co = new QuinteFlush(cards5Mixed);
        // flush5 > flush2
        Assert.assertEquals(1, flush5.compareTo(flush2));
        // flush2 < flush5
        Assert.assertEquals(-1, flush2.compareTo(flush5));
        // flush5 = flush5Co
        Assert.assertEquals(0, flush5.compareTo(flush5Co));
    }
}