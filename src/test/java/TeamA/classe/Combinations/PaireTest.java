package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

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
 . Last Modified : 02/10/17 23:41
 ...............................................................................................................................*/

public class PaireTest
{
    private ArrayList<Card> cards8Pair;
    private ArrayList<Card> cards7pair;
    private ArrayList<Card> cards8pairMixed;
    private ArrayList<Card> cardsNoPair;

    @Before
    public void init ()
    {
        cards8Pair = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                                                   new Card(8, "Co"),
                                                   new Card(5, "Tr"),
                                                   new Card(2, "Pi"),
                                                   new Card(4, "Pi")));

        //Obj2 < Obj1
        cards7pair = new ArrayList<>(Arrays.asList(new Card(3, "Ca"),
                                                   new Card(5, "Co"),
                                                   new Card(7, "Tr"),
                                                   new Card(7, "Pi"),
                                                   new Card(4, "Pi")));

        //Obj3 = Obj1
        cards8pairMixed = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                                                        new Card(4, "Co"),
                                                        new Card(2, "Pi"),
                                                        new Card(5, "Tr"),
                                                        new Card(8, "Pi")));

        //PlusHauteCarte
        cardsNoPair = new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                    new Card(5, "Co"),
                                                    new Card(8, "Tr"),
                                                    new Card(4, "Pi"),
                                                    new Card(3, "Pi")));
    }

    @Test
    public void Pair ()
    {
        //Right test for the pair constructeur
        Paire pair = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                             new Card(5, "Co"),
                                                             new Card(8, "Tr"),
                                                             new Card(4, "Tr"),
                                                             new Card(4, "Pi"))));

        assertEquals(0, new Card(4, "Tr").compareTo(pair.getPaire()));
        assertEquals(Arrays.asList(new Card(2, "Ca"), new Card(5, "Co"), new Card(8, "Tr")), pair.getRestOfCards());
    }

    @Test
    public void isTypeOf () throws Exception
    {
        assertTrue(Paire.isTypeOf(cards8Pair)); //DoublePaire
        assertFalse(Paire.isTypeOf(cardsNoPair)); //PlusHauteCarte
    }

    @Test
    public void compareTo () throws Exception
    {
        Paire paire1 = new Paire(cards8Pair);
        Paire paire2 = new Paire(cards7pair);
        Paire paire1Bis = new Paire(cards8pairMixed);

        assertEquals(0, paire1.compareTo(paire1Bis));
        assertEquals(-1, paire2.compareTo(paire1));
        assertEquals(1, paire1Bis.compareTo(paire2));
    }
}