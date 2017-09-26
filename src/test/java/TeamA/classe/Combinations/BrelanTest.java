package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
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
    @Test
    public void isTypeOf () throws Exception
    {
        Brelan obj1 = new Brelan(new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                                                               new Card(8, "Co"),
                                                               new Card(8, "Tr"),
                                                               new Card(5, "Pi"),
                                                               new Card(4, "Pi"))));

        Brelan obj2 = new Brelan(new ArrayList<>(Arrays.asList(new Card(6, "Ca"),
                                                               new Card(3, "Pi"),
                                                               new Card(6, "Co"),
                                                               new Card(6, "Tr"),
                                                               new Card(4, "Pi"))));

        Brelan obj3 = new Brelan(new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                                                               new Card(8, "Tr"),
                                                               new Card(8, "Co"),
                                                               new Card(8, "Pi"),
                                                               new Card(4, "Pi"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }

}