package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/*................................................................................................................................
 . Copyright (c)
 .
 . The CombinationTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 17:13
 ...............................................................................................................................*/

public class CombinationTest
{
    @Test
    public void gethighestcard () throws Exception
    {
        Card highestCard = new Card(10, "Pi");

        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                              new Card(6, "Pi"),
                                                              new Card(8, "Pi"),
                                                              highestCard,
                                                              new Card(2, "Co")));

        Combination cmb1 = new PlusHauteCarte(cards);

        Assert.assertEquals(highestCard, cmb1.gethighestcard(cards));
    }

    @Test
    public void compareTo () throws Exception
    {
        Combination comb1 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                                             new Card(6, "Pi"),
                                                                             new Card(8, "Pi"),
                                                                             new Card(10, "Tr"),
                                                                             new Card(2, "Co"))));

        Combination comb2 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                                             new Card(10, "Tr"),
                                                                             new Card(8, "Pi"),
                                                                             new Card(6, "Pi"),
                                                                             new Card(2, "Co"))));

        Combination comb3 = new Paire(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                                    new Card(5, "Tr"),
                                                                    new Card(8, "Pi"),
                                                                    new Card(6, "Pi"),
                                                                    new Card(2, "Co"))));

        // comb1 = comb2 car same cards and same Combination
        Assert.assertEquals(0, comb1.compareTo(comb2));

        // comb1 < comb2 car comb2 is Paire
        Assert.assertEquals(-1, comb1.compareTo(comb3));
    }
}