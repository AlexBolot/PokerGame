package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
 . Last Modified : 26/09/17 16:46
 ...............................................................................................................................*/

public class DoublePaireTest
{
    @Test
    public void isTypeOf () throws Exception
    {
        DoublePaire obj1 = new DoublePaire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                         new Card(2, "Co"),
                                                                         new Card(8, "Tr"),
                                                                         new Card(8, "Pi"),
                                                                         new Card(4, "Pi"))));

        DoublePaire obj2 = new DoublePaire(new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                                                                         new Card(3, "Co"),
                                                                         new Card(7, "Tr"),
                                                                         new Card(7, "Pi"),
                                                                         new Card(4, "Pi"))));

        DoublePaire obj3 = new DoublePaire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                         new Card(4, "Co"),
                                                                         new Card(8, "Tr"),
                                                                         new Card(2, "Pi"),
                                                                         new Card(8, "Pi"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }

}