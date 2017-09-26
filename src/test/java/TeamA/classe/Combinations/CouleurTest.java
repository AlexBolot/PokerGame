package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

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
    @Test
    public void isTypeOf () throws Exception
    {
        Couleur obj1 = new Couleur(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                 new Card(5, "Ca"),
                                                                 new Card(8, "Ca"),
                                                                 new Card(3, "Ca"),
                                                                 new Card(4, "Ca"))));

        Couleur obj2 = new Couleur(new ArrayList<>(Arrays.asList(new Card(2, "Pi"),
                                                                 new Card(5, "Pi"),
                                                                 new Card(7, "Pi"),
                                                                 new Card(3, "Pi"),
                                                                 new Card(4, "Pi"))));

        Couleur obj3 = new Couleur(new ArrayList<>(Arrays.asList(new Card(2, "Tr"),
                                                                 new Card(5, "Tr"),
                                                                 new Card(8, "Tr"),
                                                                 new Card(3, "Tr"),
                                                                 new Card(4, "Tr"))));

        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }

}