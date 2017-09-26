package TeamA.classe;

import TeamA.classe.Combinations.PlusHauteCarte;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static TeamA.TestingUtils.getAllCards;

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
 . Last Modified : 26/09/17 16:52
 ...............................................................................................................................*/

@SuppressWarnings ("Duplicates")
public class HandTest
{
    private        ArrayList<Card> cards    = new ArrayList<>();
    private Hand hand;

    @Before
    public void before ()
    {
        cards.clear();

        for (int i = 0; i < 5; i++)
        {
            int index = new Random().nextInt(getAllCards().size());
            cards.add(getAllCards().get(index));
        }

        hand = new Hand(cards);
    }

    @Test
    public void getHand () throws Exception
    {
        Assert.assertEquals(cards, hand.getHand());
    }

    @Test
    public void setHand () throws Exception
    {
        ArrayList<Card> newCards = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            int index = new Random().nextInt(getAllCards().size());
            newCards.add(getAllCards().get(index));
        }

        hand.setHand(newCards);

        Assert.assertEquals(newCards, hand.getHand());
    }

    @Test
    public void findBestCombination () throws Exception
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
        Hand hand2 = new Hand(new ArrayList<>(Arrays.asList(new Card(2, ""),
                                                            new Card(3, ""),
                                                            new Card(2, ""),
                                                            new Card(3, ""),
                                                            new Card(5, ""))));
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

        Assert.assertTrue(hand0.findBestCombination() instanceof PlusHauteCarte);

        //Will be used in future release
        /*Assert.assertTrue(hand1.findBestCombination() instanceof Paire);
        Assert.assertTrue(hand2.findBestCombination() instanceof DoublePaire);
        Assert.assertTrue(hand3.findBestCombination() instanceof Brelan);
        Assert.assertTrue(hand4.findBestCombination() instanceof Suite);
        Assert.assertTrue(hand5.findBestCombination() instanceof Couleur);
        Assert.assertTrue(hand6.findBestCombination() instanceof Full);
        Assert.assertTrue(hand7.findBestCombination() instanceof Carre);
        Assert.assertTrue(hand8.findBestCombination() instanceof QuinteFlush);*/
    }

    @Test
    public void toStringTest () throws Exception
    {
        StringBuilder str = new StringBuilder();

        for (Card c : hand.getHand())
        {
            str.append(c).append(" ");
        }

        Assert.assertEquals(str.toString(), hand.toString());
    }
}