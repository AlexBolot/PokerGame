package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The SuiteTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 21:44
 ...............................................................................................................................*/

public class SuiteTest
{
    private ArrayList<Card> cards5start;
    private ArrayList<Card> cards2Start;
    private ArrayList<Card> cards5startMixed;
    private ArrayList<Card> cards2Pair;
    private ArrayList<Card> cards10Carree;
    private ArrayList<Card> cardsAstart;

    @Before
    public void init ()
    {
        cards5start = new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                    new Card(6, "Co"),
                                                    new Card(7, "Tr"),
                                                    new Card(8, "Pi"),
                                                    new Card(9, "Pi")));

        cardsAstart = new ArrayList<>(Arrays.asList(new Card(14, "Ca"),
                                                    new Card(2, "Co"),
                                                    new Card(3, "Tr"),
                                                    new Card(4, "Pi"),
                                                    new Card(5, "Pi")));

        cards2Start = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                    new Card(4, "Co"),
                                                    new Card(6, "Tr"),
                                                    new Card(5, "Pi"),
                                                    new Card(3, "Pi")));

        cards5startMixed = new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                                                         new Card(5, "Co"),
                                                         new Card(6, "Tr"),
                                                         new Card(7, "Pi"),
                                                         new Card(8, "Pi")));

        cards2Pair = new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                                                   new Card(11, "Co"),
                                                   new Card(6, "Tr"),
                                                   new Card(2, "Pi"),
                                                   new Card(2, "Pi")));

        cards10Carree = new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                                                      new Card(10, "Co"),
                                                      new Card(10, "Tr"),
                                                      new Card(10, "Pi"),
                                                      new Card(10, "Ca")));
    }

    //region //============= Constructor (x5) =============//
    @Test
    public void constructor_Right ()
    {
        Suite suite = new Suite(cards5start);
        assertEquals(new Card(5, "Ca"), suite.getStart());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_EmptyList ()
    {
        Suite suite = new Suite(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_NullParam ()
    {
        Suite suite = new Suite(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongSize ()
    {
        //Here the size is 6 > 5
        Suite suite = new Suite(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                                                              new Card(3, "Co"),
                                                              new Card(8, "Co"),
                                                              new Card(5, "Pi"),
                                                              new Card(7, "Tr"),
                                                              new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongCards ()
    {
        Suite suite = new Suite(cards2Pair);
    }
    //endregion ===========================================//

    //region //============== isTypeOf (x4) ===============//
    @Test
    public void isTypeOf_Right ()
    {
        //Test Right
        assertFalse(Suite.isTypeOf(cards10Carree));
        assertTrue(Suite.isTypeOf(cards5start));
        assertTrue(Suite.isTypeOf(cards5startMixed));
        assertTrue(Suite.isTypeOf(cardsAstart));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_EmptyList ()
    {
        Suite.isTypeOf(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NotGoodSize ()
    {
        //Here the size is 6 > 5
        Suite.isTypeOf(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                                                     new Card(3, "Co"),
                                                     new Card(8, "Co"),
                                                     new Card(5, "Pi"),
                                                     new Card(7, "Tr"),
                                                     new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NullParam ()
    {
        Suite.isTypeOf(null);
    }
    //endregion ===========================================//

    //region //============== compareTo (x2) ==============//
    @Test
    public void compareTo_Right () throws Exception
    {
        Suite suite5Start = new Suite(cards5start);
        Suite suite2Start = new Suite(cards2Start);
        Suite suite5Mixed = new Suite(cards5startMixed);
        Suite suiteA = new Suite(cardsAstart);
        Paire paire = new Paire(cards2Pair);
        Carre carre = new Carre(cards10Carree);

        // suite5Start > suite2Start
        Assert.assertEquals(1, suite5Start.compareTo(suiteA));
        // suite2Start < suite5Start
        Assert.assertEquals(-1, suite2Start.compareTo(suite5Start));
        // Suite5Start = Suite5Mixed
        Assert.assertEquals(0, suite5Start.compareTo(suite5Mixed));
        // paire < suite2start
        Assert.assertEquals(1, suite2Start.compareTo(paire));
        //carre >suite5mixed
        Assert.assertEquals(-1, suite5Mixed.compareTo(carre));
    }

    @Test (expected = IllegalArgumentException.class)
    public void compareTo_NullParam ()
    {
        Suite suite5Start = new Suite(cards5start);

        suite5Start.compareTo(null);
    }


    //region //================= toString =================//
    @Test
    public void ToString ()
    {
        Suite suite = new Suite(cards5start);

        assertEquals("Suite qui commence à 5Ca", suite.toString());
    }
    //endregion ===========================================//
}