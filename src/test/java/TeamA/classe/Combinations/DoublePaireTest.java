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
 . Last Modified : 06/10/17 22:56
 ...............................................................................................................................*/

public class DoublePaireTest
{
    private ArrayList<Card> obj1, obj2, obj3, obj4, obj5, obj6;

    @Before
    public void init ()
    {
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
    public void isTypeOf ()
    {
        assertTrue(DoublePaire.isTypeOf(obj1)); // double paire
        assertFalse(DoublePaire.isTypeOf(obj4)); // paire
        assertFalse(DoublePaire.isTypeOf(obj5)); // brelan
        assertFalse(DoublePaire.isTypeOf(obj6)); // carré
    }

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

    @Test
    public void testToString ()
    {
        DoublePaire doublePaire = new DoublePaire(obj1);
        assertEquals("DoublePaire avec paire de 8Ca et de 2Ca", doublePaire.toString());
    }
}