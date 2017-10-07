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
 . The DoublePaireTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 07/10/17 21:45
 ...............................................................................................................................*/

public class DoublePaireTest
{
    private ArrayList<Card> obj1, obj2, obj3, obj4, obj5, obj6, obj7;

    @Before
    public void init () {
        obj1 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(8, "Co"),
                new Card(8, "Tr"),
                new Card(2, "Pi"),
                new Card(4, "Pi")));

        //Obj2 < Obj1
        obj2 = new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                new Card(3, "Co"),
                new Card(7, "Tr"),
                new Card(7, "Pi"),
                new Card(4, "Pi")));

        //Obj3 = Obj1
        obj3 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(4, "Co"),
                new Card(2, "Pi"),
                new Card(8, "Tr"),
                new Card(8, "Pi")));

        //Simple Paire
        obj4 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(4, "Co"),
                new Card(8, "Tr"),
                new Card(2, "Pi"),
                new Card(7, "Pi")));

        //Brelan
        obj5 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(4, "Co"),
                new Card(8, "Tr"),
                new Card(2, "Pi"),
                new Card(2, "Pi")));

        // Carré
        obj6 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(2, "Co"),
                new Card(2, "Tr"),
                new Card(2, "Pi"),
                new Card(7, "Pi")));

        obj7 = new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                new Card(4, "Co"),
                new Card(4, "Co"),
                new Card(8, "Pi"),
                new Card(8, "Pi")));
    }

    @Test
    public void DoublePaire ()
    {
        DoublePaire dp = new DoublePaire(obj1);

        assertEquals(1, dp.getRestOfCards().size()); // on test si les cartes on bien était supprimé de la main
        assertFalse(dp.getRestOfCards().contains(dp.getStrongPaire())); // on s'assure que la paire forte n'est plus dans le reste
        assertFalse(dp.getRestOfCards().contains(dp.getWeakPaire())); // on s'assure que la paire faible n'est plus dans la main
    }
    @Test
    public void constructor_Right ()
    {
        DoublePaire doublepaire = new DoublePaire(obj1);
        assertEquals(new Card(8, "Ca"), doublepaire.getStrongPaire());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_EmptyList ()
    {
        DoublePaire doublePaire = new DoublePaire(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_NullParam ()
    {
        DoublePaire doublePaire = new DoublePaire(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongSize ()
    {
        //Here the size is 6 > 5
        DoublePaire doublePaire = new DoublePaire(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                new Card(3, "Co"),
                new Card(8, "Co"),
                new Card(5, "Pi"),
                new Card(7, "Tr"),
                new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongCards ()
    {
       DoublePaire doublepaire = new DoublePaire(obj5);
    }
    //endregion ===========================================//

    //region //============== isTypeOf (x4) ===============//

    @Test
    public void isTypeOf ()
    {
        assertTrue(DoublePaire.isTypeOf(obj1)); // double paire
        assertFalse(DoublePaire.isTypeOf(obj4)); // paire
        assertFalse(DoublePaire.isTypeOf(obj5)); // brelan
        assertFalse(DoublePaire.isTypeOf(obj6)); // carré
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_EmptyList ()
    {
        DoublePaire.isTypeOf(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NotGoodSize ()
    {
        //Here the size is 6 > 5
        DoublePaire.isTypeOf(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                new Card(3, "Co"),
                new Card(8, "Co"),
                new Card(5, "Pi"),
                new Card(7, "Tr"),
                new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NullParam ()
    {
        DoublePaire.isTypeOf(null);
    }
    //endregion ===========================================//

    //region //============== compareTo (x2) ==============//
    @Test
    public void compareTo ()
    {
        DoublePaire dp1 = new DoublePaire(obj1);
        DoublePaire dp2 = new DoublePaire(obj2);
        DoublePaire dp3 = new DoublePaire(obj3);

        assertEquals(1, dp1.compareTo(dp2));
        assertEquals(-1, dp2.compareTo(dp1));
        assertEquals(0, dp1.compareTo(dp3));
    }
    @Test (expected = IllegalArgumentException.class)
    public void compareTo_NullParam ()
    {
        DoublePaire doublePaire = new DoublePaire(obj1);

        doublePaire.compareTo(null);
    }
    //endregion ===========================================//

    //region //================= toString =================//
    @Test
    public void testToString ()
    {
        DoublePaire doublePaire = new DoublePaire(obj1);
        assertEquals("DoublePaire avec paire de 8 et de 2", doublePaire.toString());
    }
    //endregion ===========================================//
}