package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c)
 .
 . The PlusHauteCarteTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 16:38
 ...............................................................................................................................*/

public class PlusHauteCarteTest
{
    @Test
    public void compareTo () throws Exception
    {
        PlusHauteCarte obj1 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                               new Card(5, "Co"),
                                                                               new Card(8, "Tr"),
                                                                               new Card(3, "Pi"),
                                                                               new Card(4, "Pi"))));

        PlusHauteCarte obj2 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                               new Card(5, "Co"),
                                                                               new Card(7, "Tr"),
                                                                               new Card(3, "Pi"),
                                                                               new Card(4, "Pi"))));

        PlusHauteCarte obj3 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                               new Card(5, "Co"),
                                                                               new Card(8, "Tr"),
                                                                               new Card(3, "Pi"),
                                                                               new Card(4, "Pi"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }
}