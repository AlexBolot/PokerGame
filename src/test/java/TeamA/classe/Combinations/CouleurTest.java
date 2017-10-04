package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The CouleurTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 16:46
 ...............................................................................................................................*/

public class CouleurTest
{
    private ArrayList<Card> obj1, obj2, obj3, obj4, obj5, obj6;

    @Before
    public void init ()
    {
        obj1 = new ArrayList<>(Arrays.asList(new Card(7, "Co"),
                new Card(8, "Co"),
                new Card(8, "Co"),
                new Card(5, "Co"),
                new Card(4, "Co")));

        // obj1 > obj2
        obj2 = new ArrayList<>(Arrays.asList(new Card(6, "Ca"),
                new Card(3, "Ca"),
                new Card(6, "Ca"),
                new Card(6, "Ca"),
                new Card(4, "Ca")));

        // obj3 = obj1
        obj3 = (new ArrayList<>(Arrays.asList(new Card(7, "Tr"),
                new Card(8, "Tr"),
                new Card(8, "Tr"),
                new Card(5, "Tr"),
                new Card(4, "Tr"))));

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
    public void isTypeOf () throws Exception
    {
        assertTrue(Couleur.isTypeOf(obj1));
        assertTrue(Couleur.isTypeOf(obj2));
        assertTrue(Couleur.isTypeOf(obj3));
        assertFalse(Couleur.isTypeOf(obj4));
        assertFalse(Couleur.isTypeOf(obj5));
        assertFalse(Couleur.isTypeOf(obj6));
    }
    @Test
    public void compareTo () throws Exception
    {
        Couleur couleur1 = new Couleur(obj1);
        Couleur couleur2 = new Couleur(obj2);
        Couleur couleur3 = new Couleur(obj3);

        assertEquals(1, couleur1.compareTo(couleur2));
        assertEquals(-1, couleur2.compareTo(couleur1));
        assertEquals(0, couleur1.compareTo(couleur3));
    }
}