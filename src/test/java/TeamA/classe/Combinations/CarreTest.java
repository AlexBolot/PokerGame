package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
 . Last Modified : 26/09/17 16:42
 ...............................................................................................................................*/

public class CarreTest
{
    @Test
    public void isTypeOf () throws Exception
    {
        Carre obj1 = new Carre(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(4, "Co"),
                                                             new Card(4, "Tr"),
                                                             new Card(4, "Pi"),
                                                             new Card(4, "Pi"))));

        Carre obj2 = new Carre(new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                                                             new Card(3, "Co"),
                                                             new Card(4, "Tr"),
                                                             new Card(3, "Pi"),
                                                             new Card(3, "Pi"))));

        Carre obj3 = new Carre(new ArrayList<>(Arrays.asList(new Card(4, "Ca"),
                                                             new Card(4, "Tr"),
                                                             new Card(2, "Co"),
                                                             new Card(4, "Pi"),
                                                             new Card(4, "Pi"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }

}