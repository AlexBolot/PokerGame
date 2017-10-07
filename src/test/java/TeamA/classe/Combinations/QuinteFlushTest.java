package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
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
    private ArrayList<Card> tooManyCards;

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
                new Card(3, "Pi"),
                new Card(5, "Tr"),
                new Card(2, "Pi")));
        tooManyCards = (ArrayList<Card>) cards5Mixed.clone();
        tooManyCards.add(new Card(3, "Tr"));
    }

    //region// Constructor //
    @Test
    public void constructor_Right() {
        QuinteFlush flush5 = new QuinteFlush(card5Order);
        assertEquals(new Card(5, "Tr"), flush5.getStart());
    }

    @Test(expected = IllegalArgumentException.class)

    public void constructor_Empty() {
        QuinteFlush flush5 = new QuinteFlush(new ArrayList<Card>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_null() {
        QuinteFlush flush5 = new QuinteFlush(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_WrongSize() {

        QuinteFlush flush5 = new QuinteFlush(tooManyCards);
    }

    //endregion//
    //region// isTypeOf  //
    @Test
    public void isTypeOf_Right() {
        assertTrue(QuinteFlush.isTypeOf(cards2));
        assertFalse(QuinteFlush.isTypeOf(cardsPair2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTypeOf_wrongSize() {
        QuinteFlush.isTypeOf(tooManyCards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTypeOf_empty() {
        QuinteFlush.isTypeOf(new ArrayList<Card>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTypeOf_null() {
        QuinteFlush.isTypeOf(null);
    }

    //endregion//  //

    // region // CompareTo //
    @Test
    public void compareTo_right() throws Exception {

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
        // flush > pair
        assertEquals(1, flush2.compareTo(new Paire(cardsPair2)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void compareTo_null() {
        QuinteFlush flush5 = new QuinteFlush(
                card5Order);
        flush5.compareTo(null);
    }


    //endregion
    //region // toString //
    public void toStringTest() {
        QuinteFlush quiteFlush = new QuinteFlush(cards5Mixed);
        assertEquals("Quite Flush qui commence à 5", quiteFlush.toString());

    }
    //endregion
}