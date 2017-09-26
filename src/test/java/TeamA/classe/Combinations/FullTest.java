package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FullTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 16:50
 ...............................................................................................................................*/

public class FullTest
{
    @Test
    public void isTypeOf () throws Exception
    {
        Full obj1 = new Full(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                           new Card(5, "Co"),
                                                           new Card(8, "Tr"),
                                                           new Card(8, "Pi"),
                                                           new Card(8, "Pi"))));

        Full obj2 = new Full(new ArrayList<>(Arrays.asList(new Card(7, "Ca"),
                                                           new Card(5, "Co"),
                                                           new Card(7, "Tr"),
                                                           new Card(5, "Pi"),
                                                           new Card(7, "Pi"))));

        Full obj3 = new Full(new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                                                           new Card(8, "Co"),
                                                           new Card(5, "Tr"),
                                                           new Card(5, "Pi"),
                                                           new Card(8, "Pi"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }

}