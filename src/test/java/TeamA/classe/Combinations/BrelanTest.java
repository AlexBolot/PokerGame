package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
 . Last Modified : 26/09/17 16:39
 ...............................................................................................................................*/

public class BrelanTest
{
    private ArrayList<Card> obj1, obj2, obj3, obj4, obj5, obj6;

    @Before
    public void init () {
        obj1 = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                new Card(8, "Co"),
                new Card(8, "Tr"),
                new Card(5, "Pi"),
                new Card(4, "Pi")));

        obj2 = new ArrayList<>(Arrays.asList(new Card(6, "Ca"),
                new Card(3, "Pi"),
                new Card(6, "Co"),
                new Card(6, "Tr"),
                new Card(4, "Pi")));

        obj3 = (new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                new Card(4, "Tr"),
                new Card(8, "Co"),
                new Card(4, "Pi"),
                new Card(8, "Pi"))));
        obj4 = (new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                new Card(8, "Tr"),
                new Card(8, "Co"),
                new Card(8, "Pi"),
                new Card(8, "Pi"))));
        obj5 = (new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                new Card(8, "Tr"),
                new Card(8, "Co"),
                new Card(6, "Pi"),
                new Card(4, "Pi"))));
        obj6 = (new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                new Card(2, "Tr"),
                new Card(3, "Co"),
                new Card(2, "Pi"),
                new Card(4, "Pi"))));
    }

    @Test
    public void isTypeOf() throws Exception {

        Assert.assertTrue( Brelan.isTypeOf(obj1));
        Assert.assertTrue( Brelan.isTypeOf(obj2));
        Assert.assertTrue( Brelan.isTypeOf(obj3));
        Assert.assertFalse( Brelan.isTypeOf(obj4));
        Assert.assertFalse( Brelan.isTypeOf(obj5));
        Assert.assertFalse( Brelan.isTypeOf(obj6));
    }
}