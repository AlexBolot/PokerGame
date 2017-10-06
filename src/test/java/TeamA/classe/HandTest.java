package TeamA.classe;

import TeamA.classe.Combinations.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*................................................................................................................................
 . Copyright (c)
 .
 . The HandTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 06/10/17 23:42
 ...............................................................................................................................*/

@SuppressWarnings ("Duplicates")
public class HandTest
{
    //region //============= Constructor (x4) =============//
    @Test
    public void constructor_Right ()
    {
        ArrayList<Card> cards = new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                              new Card(6, "Co"),
                                                              new Card(7, "Tr"),
                                                              new Card(8, "Pi"),
                                                              new Card(9, "Pi")));

        Hand hand = new Hand(cards);

        assertEquals(cards, hand.getHand());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_EmptyList ()
    {
        Hand hand = new Hand(new ArrayList<Card>());
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_NullParam ()
    {
        Hand hand = new Hand(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void constructor_WrongSize ()
    {
        //Here the size is 6 > 5
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(new Card(9, "Ca"),
                                                           new Card(3, "Co"),
                                                           new Card(8, "Co"),
                                                           new Card(5, "Pi"),
                                                           new Card(7, "Tr"),
                                                           new Card(5, "Ca"))));
    }
    //endregion ===========================================//

    //region //============ findBestCombination ===========//
    @Test
    public void findBestCombination ()
    {
        //region PlusHauteCarte
        Hand hand0 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                            new Card(5, "Co"),
                                                            new Card(7, "Tr"),
                                                            new Card(3, "Pi"),
                                                            new Card(4, "Pi"))));
        //endregion

        //region Paire
        Hand hand1 = new Hand(new ArrayList<>(Arrays.asList(new Card(6, "Ca"),
                                                            new Card(2, "Co"),
                                                            new Card(2, "Tr"),
                                                            new Card(3, "Pi"),
                                                            new Card(5, "Pi"))));
        //endregion

        //region DoublePaire
        Hand hand2 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                            new Card(3, "Tr"),
                                                            new Card(2, "Pi"),
                                                            new Card(3, "Co"),
                                                            new Card(5, "Co"))));
        //endregion

        //region Brelan
        Hand hand3 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, "Co"),
                                                            new Card(2, "Pi"),
                                                            new Card(2, "Tr"),
                                                            new Card(3, "Tr"),
                                                            new Card(5, "Pi"))));
        //endregion

        //region Suite
        Hand hand4 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                            new Card(3, "Tr"),
                                                            new Card(4, "Ca"),
                                                            new Card(5, "Co"),
                                                            new Card(6, "Co"))));
        //endregion

        //region Couleur
        Hand hand5 = new Hand(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                            new Card(6, "Ca"),
                                                            new Card(7, "Ca"),
                                                            new Card(3, "Ca"),
                                                            new Card(5, "Ca"))));
        //endregion

        //region Full
        Hand hand6 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, "Tr"),
                                                            new Card(2, "Ca"),
                                                            new Card(2, "Co"),
                                                            new Card(3, "Pi"),
                                                            new Card(3, "Co"))));
        //endregion

        //region Carre
        Hand hand7 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, "Tr"),
                                                            new Card(2, "Ca"),
                                                            new Card(2, "Co"),
                                                            new Card(2, "Pi"),
                                                            new Card(3, "Co"))));
        //endregion

        //region QuinteFlush
        Hand hand8 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, "Co"),
                                                            new Card(3, "Co"),
                                                            new Card(4, "Co"),
                                                            new Card(5, "Co"),
                                                            new Card(6, "Co"))));
        //endregion

        assertTrue(hand0.findBestCombination() instanceof PlusHauteCarte);
        assertTrue(hand1.findBestCombination() instanceof Paire);
        assertTrue(hand2.findBestCombination() instanceof DoublePaire);
        assertTrue(hand3.findBestCombination() instanceof Brelan);
        assertTrue(hand4.findBestCombination() instanceof Suite);
        assertTrue(hand5.findBestCombination() instanceof Couleur);
        assertTrue(hand6.findBestCombination() instanceof Full);
        assertTrue(hand7.findBestCombination() instanceof Carre);
        assertTrue(hand8.findBestCombination() instanceof QuinteFlush);
    }
    //endregion ===========================================//

    //region //================= toString =================//
    @Test
    public void ToString ()
    {
        Hand hand = new Hand(new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                                                           new Card(6, "Co"),
                                                           new Card(7, "Tr"),
                                                           new Card(8, "Pi"),
                                                           new Card(9, "Pi"))));

        assertEquals("5Ca 6Co 7Tr 8Pi 9Pi", hand.toString());
    }
    //endregion ===========================================//
}