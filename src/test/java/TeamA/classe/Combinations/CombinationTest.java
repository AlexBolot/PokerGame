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
 . Last Modified : 07/10/17 20:28
 ...............................................................................................................................*/

public class CombinationTest
{
    //region //============ getHighestCard (x4) ===========//
    @Test
    public void gethighestcard_Right ()
    {
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                              new Card(6, "Pi"),
                                                              new Card(8, "Pi"),
                                                              new Card(10, "Pi"),
                                                              new Card(2, "Co")));

        Combination cmb1 = new PlusHauteCarte(cards);

        Assert.assertEquals(10, cmb1.gethighestcard(cards).getValue());
    }

    @Test
    public void gethighestcard_Right_Pairs ()
    {
        //What happens when 2 cards have the same value ?

        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(10, "Ca"),
                                                              new Card(6, "Pi"),
                                                              new Card(8, "Pi"),
                                                              new Card(10, "Pi"),
                                                              new Card(2, "Co")));

        Combination cmb1 = new PlusHauteCarte(cards);

        Assert.assertEquals(10, cmb1.gethighestcard(cards).getValue());
    }

    @Test (expected = IllegalArgumentException.class)
    public void gethighestcard_EmptyList ()
    {
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(10, "Ca"),
                                                              new Card(6, "Pi"),
                                                              new Card(8, "Pi"),
                                                              new Card(10, "Pi"),
                                                              new Card(2, "Co")));

        Combination cmb1 = new PlusHauteCarte(cards);

        cmb1.gethighestcard(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void gethighestcard_NullParam ()
    {
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(10, "Ca"),
                                                              new Card(6, "Pi"),
                                                              new Card(8, "Pi"),
                                                              new Card(10, "Pi"),
                                                              new Card(2, "Co")));

        Combination cmb1 = new PlusHauteCarte(cards);

        cmb1.gethighestcard(null);
    }
    //endregion ===========================================//

    //region //============== compareTo (x2) ==============//
    @Test
    public void compareTo_Right ()
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

    @Test (expected = IllegalArgumentException.class)
    public void compareTo_NullParam ()
    {
        Combination comb1 = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                                             new Card(6, "Pi"),
                                                                             new Card(8, "Pi"),
                                                                             new Card(10, "Tr"),
                                                                             new Card(2, "Co"))));


        comb1.compareTo(null);
    }
    //endregion ===========================================//
}