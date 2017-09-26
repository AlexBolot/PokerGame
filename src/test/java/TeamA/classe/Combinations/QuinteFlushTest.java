package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c)
 .
 . The QuinteFlushTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 17:03
 ...............................................................................................................................*/

public class QuinteFlushTest
{
    @Test
    public void isTypeOf () throws Exception
    {
        QuinteFlush obj1 = new QuinteFlush(new ArrayList<>(Arrays.asList(new Card(5, "Tr"),
                                                                         new Card(6, "Tr"),
                                                                         new Card(7, "Tr"),
                                                                         new Card(8, "Tr"),
                                                                         new Card(9, "Tr"))));

        QuinteFlush obj2 = new QuinteFlush(new ArrayList<>(Arrays.asList(new Card(2, "Co"),
                                                                         new Card(4, "Co"),
                                                                         new Card(6, "Co"),
                                                                         new Card(5, "Co"),
                                                                         new Card(3, "Co"))));

        QuinteFlush obj3 = new QuinteFlush(new ArrayList<>(Arrays.asList(new Card(9, "Co"),
                                                                         new Card(5, "Co"),
                                                                         new Card(6, "Co"),
                                                                         new Card(7, "Co"),
                                                                         new Card(8, "Co"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }
}