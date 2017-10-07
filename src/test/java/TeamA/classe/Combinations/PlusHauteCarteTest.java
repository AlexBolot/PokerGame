package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
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
    private ArrayList<Card> Cards8Max;
    private ArrayList<Card> cards8Max2;
    private ArrayList<Card> cards7Max;
    private ArrayList<Card> cardsPair;
    private ArrayList<Card> cardsPairWrong;

    @Before
    public void init() {

        Cards8Max = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"),
                new Card(3, "Pi"),
                new Card(4, "Pi")));
        cards7Max = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(7, "Tr"),
                new Card(3, "Pi"),
                new Card(4, "Pi")));
        cards8Max2 = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"),
                new Card(3, "Pi"),
                new Card(4, "Pi")));
        cardsPair = new ArrayList<>(Arrays.asList(
                new Card(8, "Ca"),
                new Card(4, "Co"),
                new Card(2, "Pi"),
                new Card(5, "Tr"),
                new Card(8, "Pi")));
        cardsPairWrong = new ArrayList<>(Arrays.asList(
                new Card(8, "Ca"),
                new Card(4, "Co"),
                new Card(2, "Pi"),
                new Card(5, "Tr"),
                new Card(8, "Ca")
        ));
    }

    @Test
    public void compareTo() throws Exception {

        PlusHauteCarte max8 = new PlusHauteCarte(Cards8Max);

        PlusHauteCarte max7 = new PlusHauteCarte(cards7Max);

        PlusHauteCarte max8Bis = new PlusHauteCarte(cards8Max2);

        Paire pair = new Paire(cardsPair);

        // max8 > max7
        Assert.assertEquals(1, max8.compareTo(max7));
        // max7 < max8
        Assert.assertEquals(-1, max7.compareTo(max8));
        //pair>max8
        Assert.assertEquals(-1, max8.compareTo(pair));
        // max8 = max8Bis
        Assert.assertEquals(0, max8.compareTo(max8Bis));
    }
}