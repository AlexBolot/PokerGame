package TeamA.classe.Combinations;

import TeamA.classe.Card;
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
 . The FullTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 07/10/17 21:45
 ...............................................................................................................................*/

public class FullTest
{


    private ArrayList<Card> cardsB8P5mixed;
    private ArrayList<Card> cardsB8P5;
    private ArrayList<Card> cardsB7p5;
    private ArrayList<Card> tooManyCards;
    private ArrayList<Card> cardsPair;
    private ArrayList<Card> cardsBrelan;
    private ArrayList<Card> cardsQuinteFlush;

    @Before
    public void init() {

        cardsB8P5mixed = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                new Card(8, "Co"),
                new Card(5, "Tr"),
                new Card(5, "Pi"),
                new Card(8, "Pi")));
        cardsB8P5 = new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"),
                new Card(8, "Pi"),
                new Card(8, "Pi")));
        cardsB7p5 = new ArrayList<>(Arrays.asList(new Card(7, "Ca"),
                new Card(5, "Co"),
                new Card(7, "Tr"),
                new Card(5, "Pi"),
                new Card(7, "Pi")));
        ;
        cardsPair = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                new Card(4, "Co"),
                new Card(2, "Pi"),
                new Card(5, "Tr"),
                new Card(8, "Pi")));
        cardsBrelan = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(5, "Tr"),
                new Card(5, "Pi"),
                new Card(3, "Pi")));
        cardsQuinteFlush = new ArrayList<>(
                Arrays.asList(
                        new Card(5, "Tr"),
                        new Card(6, "Tr"),
                        new Card(7, "Tr"),
                        new Card(8, "Tr"),
                        new Card(9, "Tr")));

        tooManyCards = (ArrayList<Card>) cardsB7p5.clone();
        tooManyCards.add(new Card(3, "Tr"));

    }

    //region// Constructor //
    @Test
    public void constructor_Right() {
        Full flush5 = new Full(cardsB7p5);
        assertEquals(new Card(7, "Ca"), flush5.getTriplet());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_Empty() {
        Full full = new Full(new ArrayList<Card>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_null() {
        Full full = new Full(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_WrongSize() {

        Full full = new Full(tooManyCards);
    }

    //endregion//


    // region // CompareTo //
    @Test
    public void compareTo_right() throws Exception {

        Full b5p7 = new Full(cardsB7p5);
        Full b8p5 = new Full(cardsB8P5);
        Full b8p5mixed = new Full(cardsB8P5mixed);
        Paire pair = new Paire(cardsPair);
        QuinteFlush quinteFlush = new QuinteFlush(cardsQuinteFlush);

        //b5p7 < b8p5
        assertEquals(-1, b5p7.compareTo(b8p5));
        //b8p5 = b8p5
        assertEquals(0, b8p5mixed.compareTo(b8p5));
        //b8p5 > b5p7
        assertEquals(1, b8p5.compareTo(b5p7));
        // full > paire
        assertEquals(1, b5p7.compareTo(pair));
        //full< QuiteFlush
        assertEquals(-1, b5p7.compareTo(quinteFlush));

    }

    @Test(expected = IllegalArgumentException.class)
    public void compareTo_null() {
        QuinteFlush flush5 = new QuinteFlush(
                cardsB8P5);
        flush5.compareTo(null);
    }


    //region// isTypeOf  //
    @Test
    public void isTypeOf_Right() {
        assertTrue(Full.isTypeOf(cardsB7p5));
        assertFalse(Full.isTypeOf(cardsPair));
        assertFalse(Full.isTypeOf(cardsBrelan));
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTypeOf_wrongSize() {
        Full.isTypeOf(tooManyCards);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTypeOf_empty() {
        Full.isTypeOf(new ArrayList<Card>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void isTypeOf_null() {
        Full.isTypeOf(null);
    }

    //endregion//  //

    @Test
    public void testToString() {
        Full f8p5 = new Full(cardsB8P5);
        assertEquals("Full au 8 par les 5", f8p5.toString());
    }
}