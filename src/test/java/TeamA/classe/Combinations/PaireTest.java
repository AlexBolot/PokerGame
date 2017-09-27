package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c)
 .
 . The PaireTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 16:39
 ...............................................................................................................................*/

public class PaireTest
{
    @Test
    public void isTypeOf () throws Exception
    {
        Paire obj1 = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(5, "Co"),
                                                             new Card(8, "Tr"),
                                                             new Card(4, "Pi"),
                                                             new Card(4, "Pi"))));

        Paire obj2 = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(7, "Co"),
                                                             new Card(7, "Tr"),
                                                             new Card(3, "Pi"),
                                                             new Card(4, "Pi"))));

        Paire obj3 = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(8, "Tr"),
                                                             new Card(5, "Co"),
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