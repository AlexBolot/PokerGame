package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
 . Last Modified : 26/09/17 16:50
 ...............................................................................................................................*/

public class SuiteTest
{
    @Test
    public void isTypeOf () throws Exception
    {
        Suite obj1 = new Suite(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                             new Card(6, "Co"),
                                                             new Card(7, "Tr"),
                                                             new Card(8, "Pi"),
                                                             new Card(9, "Pi"))));

        Suite obj2 = new Suite(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(4, "Co"),
                                                             new Card(6, "Tr"),
                                                             new Card(5, "Pi"),
                                                             new Card(3, "Pi"))));

        Suite obj3 = new Suite(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                                                             new Card(5, "Co"),
                                                             new Card(6, "Tr"),
                                                             new Card(7, "Pi"),
                                                             new Card(8, "Pi"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }

}