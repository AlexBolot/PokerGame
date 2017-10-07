package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/*................................................................................................................................
 . Copyright (c)
 .
 . The BrelanTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 22:55
 ...............................................................................................................................*/

public class BrelanTest
{
    private ArrayList<Card> obj1, obj2, obj3, obj4, obj5, obj6;

    @Before
    public void init ()
    {
        obj1 = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                                             new Card(8, "Co"),
                                             new Card(8, "Tr"),
                                             new Card(5, "Pi"),
                                             new Card(4, "Pi")));

        // obj1 > obj2
        obj2 = new ArrayList<>(Arrays.asList(new Card(6, "Ca"),
                                             new Card(3, "Pi"),
                                             new Card(6, "Co"),
                                             new Card(6, "Tr"),
                                             new Card(4, "Pi")));

        // obj3 = obj1
        obj3 = (new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                                              new Card(5, "Tr"),
                                              new Card(8, "Co"),
                                              new Card(4, "Pi"),
                                              new Card(8, "Pi"))));

        // Carre
        obj4 = (new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                                              new Card(8, "Tr"),
                                              new Card(8, "Co"),
                                              new Card(8, "Pi"),
                                              new Card(8, "Pi"))));

        // DoublePaire
        obj5 = (new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                                              new Card(8, "Tr"),
                                              new Card(8, "Co"),
                                              new Card(6, "Pi"),
                                              new Card(4, "Pi"))));
        // Paire
        obj6 = (new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                                              new Card(6, "Tr"),
                                              new Card(3, "Co"),
                                              new Card(2, "Pi"),
                                              new Card(4, "Pi"))));

        // PlusHauteCarte
        obj6 = (new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                                              new Card(2, "Tr"),
                                              new Card(3, "Co"),
                                              new Card(2, "Pi"),
                                              new Card(4, "Pi"))));
    }

    @Test
    public void Brelan ()
    {
        Brelan brelan = new Brelan(obj1);

        assertEquals(2, brelan.getRestOfCards().size()); // on test si les cartes on bien était supprimé de la main
        assertFalse(brelan.getRestOfCards().contains(brelan.getTriplet())); // on s'assure que la carte triple n'est plus dans le reste
    }
    //region //============= Constructor (x5) =============//

    @Test
    public void constructor_Right ()
    {
        Brelan brelan = new Brelan(obj1);
        assertEquals(new Card(8, "Ca"), brelan.getTriplet());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_EmptyList ()
    {
        Brelan brelan = new Brelan(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_NullParam ()
    {
        Brelan brelan = new Brelan(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongSize ()
    {
        //Here the size is 6 > 5
        Brelan brelan = new Brelan(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                new Card(3, "Co"),
                new Card(8, "Co"),
                new Card(5, "Pi"),
                new Card(7, "Tr"),
                new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongCards ()
    {
        Brelan brelan = new Brelan(obj6);
    }
    //endregion ===========================================//

    //region //============== isTypeOf (x4) ===============//
    @Test
    public void isTypeOf () throws Exception
    {
        assertTrue(Brelan.isTypeOf(obj1));
        assertTrue(Brelan.isTypeOf(obj2));
        assertTrue(Brelan.isTypeOf(obj3));
        assertFalse(Brelan.isTypeOf(obj4));
        assertFalse(Brelan.isTypeOf(obj5));
        assertFalse(Brelan.isTypeOf(obj6));
    }
    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_EmptyList ()
    {
        Brelan.isTypeOf(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NotGoodSize ()
    {
        //Here the size is 6 > 5
        Brelan.isTypeOf(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                new Card(3, "Co"),
                new Card(8, "Co"),
                new Card(5, "Pi"),
                new Card(7, "Tr"),
                new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NullParam ()
    {
        Brelan.isTypeOf(null);
    }
    //endregion ===========================================//

    //region //============== compareTo (x2) ==============//
    @Test
    public void compareTo () throws Exception
    {
        Brelan brelan1 = new Brelan(obj1);
        Brelan brelan2 = new Brelan(obj2);
        Brelan brelan3 = new Brelan(obj3);

        assertEquals(1, brelan1.compareTo(brelan2));
        assertEquals(-1, brelan2.compareTo(brelan1));
        assertEquals(0, brelan1.compareTo(brelan3));
    }
    @Test (expected = IllegalArgumentException.class)
    public void compareTo_NullParam ()
    {
        Brelan brelan = new Brelan(obj1);

        brelan.compareTo(null);
    }
    //region //================= toString =================//
    @Test
    public void testToString() {
        Brelan b8 = new Brelan(obj1);
        assertEquals("Brelan de 8Ca", b8.toString());
    }
}