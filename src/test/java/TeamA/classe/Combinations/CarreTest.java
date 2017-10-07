package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/*................................................................................................................................
 . Copyright (c)
 .
 . The CarreTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 22:55
 ...............................................................................................................................*/

public class CarreTest
{
    private ArrayList<Card> obj1, obj2, obj3, obj4, obj5, obj6;

    @Before
    public void init ()
    {
        obj1 = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                new Card(8, "Co"),
                new Card(8, "Tr"),
                new Card(8, "Pi"),
                new Card(4, "Pi")));

        obj2 = new ArrayList<>(Arrays.asList(new Card(6, "Ca"),
                new Card(3, "Pi"),
                new Card(6, "Co"),
                new Card(6, "Tr"),
                new Card(6, "Pi")));

        obj3 = (new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                new Card(8, "Tr"),
                new Card(8, "Co"),
                new Card(4, "Pi"),
                new Card(8, "Pi"))));

        obj4 = (new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                new Card(8, "Tr"),
                new Card(4, "Co"),
                new Card(8, "Pi"),
                new Card(8, "Pi"))));

        obj5 = (new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                new Card(8, "Tr"),
                new Card(8, "Co"),
                new Card(6, "Pi"),
                new Card(4, "Pi"))));

        obj6 = (new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                new Card(6, "Tr"),
                new Card(3, "Co"),
                new Card(2, "Pi"),
                new Card(4, "Pi"))));

    }
    @Test
    public void Carre ()
    {
        Carre carre = new Carre(obj1);

        assertEquals(1, carre.getRestOfCards().size()); // on test si les cartes on bien était supprimé de la main
        assertFalse(carre.getRestOfCards().contains(carre.getQuartet())); // on s'assure que la carte quartet n'est plus dans le reste
    }
    @Test
    public void constructor_Right ()
    {
        Carre carre = new Carre(obj1);
        assertEquals(new Card(8, "Ca"), carre.getQuartet());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_EmptyList ()
    {
        Carre carre = new Carre(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_NullParam ()
    {
        Carre carre = new Carre(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongSize ()
    {
        //Here the size is 6 > 5
        Carre carre = new Carre(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                new Card(3, "Co"),
                new Card(8, "Co"),
                new Card(5, "Pi"),
                new Card(7, "Tr"),
                new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongCards ()
    {
        Carre carre = new Carre(obj5);
    }
    //endregion ===========================================//

    //region //============== isTypeOf (x4) ===============//
    @Test
    public void isTypeOf () throws Exception
    {
        Assert.assertTrue(Carre.isTypeOf(obj1));
        Assert.assertTrue(Carre.isTypeOf(obj2));
        Assert.assertTrue(Carre.isTypeOf(obj3));
        Assert.assertFalse(Carre.isTypeOf(obj4));
        Assert.assertFalse(Carre.isTypeOf(obj5));
        Assert.assertFalse(Carre.isTypeOf(obj6));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_EmptyList ()
    {
        Carre.isTypeOf(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NotGoodSize ()
    {
        //Here the size is 6 > 5
        Carre.isTypeOf(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                new Card(3, "Co"),
                new Card(8, "Co"),
                new Card(5, "Pi"),
                new Card(7, "Tr"),
                new Card(5, "Ca"))));
    }

    @Test (expected = IllegalArgumentException.class)
    public void isTypeOf_NullParam ()
    {
        Carre.isTypeOf(null);
    }
    //endregion ===========================================//

    //region //============== compareTo (x2) ==============//
    @Test
    public void compareTo() throws Exception{
        Carre Carre1 = new Carre(obj1);
        Carre Carre2 = new Carre(obj2);
        Carre Carre3 = new Carre(obj3);

        assertEquals(1, Carre1.compareTo(Carre2));
        assertEquals(-1, Carre2.compareTo(Carre1));
        assertEquals(0, Carre3.compareTo(Carre1));
    }
    @Test (expected = IllegalArgumentException.class)
    public void compareTo_NullParam ()
    {
       Carre carre = new Carre(obj1);

        carre.compareTo(null);
    }


    //region //================= toString =================//
    @Test
    public void testToString() {
        Carre b8 = new Carre(obj1);
        assertEquals("Carre de 8Ca", b8.toString());
    }

}