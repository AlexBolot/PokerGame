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
 . Last Modified : 26/09/17 08:54
 ...............................................................................................................................*/

public class PlusHauteCarteTest
{
    @Test
    public void compareTo () throws Exception
    {
        PlusHauteCarte phc1 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                               new Card(5, "Co"),
                                                                               new Card(8, "Tr"),
                                                                               new Card(3, "Pi"),
                                                                               new Card(4, "Pi"))));

        PlusHauteCarte phc2 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                               new Card(5, "Co"),
                                                                               new Card(7, "Tr"),
                                                                               new Card(3, "Pi"),
                                                                               new Card(4, "Pi"))));

        PlusHauteCarte phc3 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                               new Card(5, "Co"),
                                                                               new Card(8, "Tr"),
                                                                               new Card(3, "Pi"),
                                                                               new Card(4, "Pi"))));

        Assert.assertEquals(1, phc1.compareTo(phc2));
        Assert.assertEquals(-1, phc2.compareTo(phc1));
        Assert.assertEquals(0, phc1.compareTo(phc3));
    }
}