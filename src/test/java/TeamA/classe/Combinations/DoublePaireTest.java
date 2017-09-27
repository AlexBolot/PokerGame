package TeamA.classe.Combinations;

import TeamA.classe.Card;
import TeamA.classe.Hand;
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
        ArrayList<Card> obj1 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(8, "Co"),
                                                             new Card(8, "Tr"),
                                                             new Card(2, "Pi"),
                                                             new Card(4, "Pi")));

        ArrayList<Card> obj2 = new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                                                             new Card(3, "Co"),
                                                             new Card(7, "Tr"),
                                                             new Card(7, "Pi"),
                                                             new Card(4, "Pi")));

        ArrayList<Card> obj3 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(4, "Co"),
                                                             new Card(8, "Tr"),
                                                             new Card(2, "Pi"),
                                                             new Card(7, "Pi")));

        ArrayList<Card> obj4 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                new Card(2, "Co"),
                                                                new Card(1, "Tr"),
                                                                new Card(2, "Pi"),
                                                                new Card(7, "Pi")));

        ArrayList<Card> obj5 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                new Card(4, "Co"),
                                                                new Card(8, "Tr"),
                                                                new Card(2, "Pi"),
                                                                new Card(2, "Pi")));

        Assert.assertEquals(true, DoublePaire.isTypeOf(obj1));
        Assert.assertEquals(true, DoublePaire.isTypeOf(obj2));
        Assert.assertEquals(false, DoublePaire.isTypeOf(obj3));
        Assert.assertEquals(false, DoublePaire.isTypeOf(obj4));
        Assert.assertEquals(false, DoublePaire.isTypeOf(obj5));
    }


}