package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Before;
import org.junit.Ignore;
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
 . Last Modified : 29/09/17 14:48
 ...............................................................................................................................*/

public class PaireTest
{
    private ArrayList<Card> cards8Pair, cards7pair, cards8pairMixed, cardsNoPair, obj5, obj6;

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
    public void testPair() {
        //Right test for the pair constructeur
        Paire pair = new Paire(
                new ArrayList<>(Arrays.asList(
                        new Card(2, "Ca"),
                        new Card(5, "Co"),
                        new Card(8, "Tr"),
                        new Card(4, "Pi"),
                        new Card(4, "Tr")
                )));
        assertEquals(new Card(4, "Pi"), pair.getPaire());
        assertEquals(Arrays.asList(
                new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr")), pair.getHand());


    }

    //todo: question : est-ce que ce test devrais pas être dans "combinationTest"
    // Oui, cette méthode de test n'est pas au bon endroit. Grégoire devra la retirer.

    @Ignore ("A besoin d'une combinaisont plus puissante de Pair correctement Instancié")
    @Test
    public void compareToComb () throws Exception
    {
        Paire pair = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"), new Card(5, "Co"), new Card(8, "Tr"))));
        pair.setPaire(new Card(4, "Pi"));

        PlusHauteCarte highCard = new PlusHauteCarte(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                                   new Card(5, "Co"),
                                                                                   new Card(8, "Tr"),
                                                                                   new Card(4, "Pi"),
                                                                                   new Card(4, "Pi"))));

        QuinteFlush quinteFlush = new QuinteFlush(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                                                                                new Card(5, "Co"),
                                                                                new Card(8, "Tr"),
                                                                                new Card(4, "Pi"),
                                                                                new Card(4, "Pi"))));
        assertEquals(-1, pair.compareTo(quinteFlush));

        assertEquals(1, pair.compareTo(highCard));
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