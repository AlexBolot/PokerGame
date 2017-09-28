package TeamA.classe.Combinations;

import TeamA.classe.Card;
import com.sun.org.apache.xpath.internal.operations.Plus;
import org.junit.Assert;
import org.junit.Ignore;
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

public class PaireTest {
    //todo: question : est-ce que ce test devrais pas être dans "combinationTest"
    @Ignore("A besoin d'une combinaisont plus puissante de Pair correctement Instancié")
    @Test
    public void compareToComb() throws Exception {
        Paire pair = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"))));
        pair.setPaire(new Card(4, "Pi"));

        PlusHauteCarte highCard = new PlusHauteCarte(new ArrayList<>(Arrays.asList(
                new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"),
                new Card(4, "Pi"),
                new Card(4, "Pi")
        )));

        QuinteFlush quinteFlush = new QuinteFlush(new ArrayList<>(Arrays.asList(
                new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"),
                new Card(4, "Pi"),
                new Card(4, "Pi")
        )));
        Assert.assertEquals(-1, pair.compareTo(quinteFlush));

        Assert.assertEquals(1, pair.compareTo(highCard));
    }

    @Test
    public void compareToPair() throws Exception {
        //todo: rework to match the new constructor

        Paire pair4 = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"))));
        pair4.setPaire(new Card(4, "Pi"));

        Paire pair7 = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(3, "Pi"),
                new Card(4, "Pi"))));
        pair7.setPaire(new Card(7, "Co"));

        Paire pair4Pi = new Paire(new ArrayList<>(Arrays.asList(new Card(2, "Ca"),
                new Card(8, "Tr"),
                new Card(5, "Co"))));
        pair4Pi.setPaire(new Card(4, "Pi"));

        // pair4 == pair4Pi , should return 0
        Assert.assertEquals(0, pair4.compareTo(pair4Pi));
        Assert.assertEquals(0, pair4.compareTo(pair4));
        // pair4 <pair7     , should return -1
        Assert.assertEquals(-1, pair4.compareTo(pair7));
        // pair4 >pair7     , should return 1
        Assert.assertEquals(1, pair7.compareTo(pair4));

    }

    @Ignore("broken")
    @Test
    public void isTypeOf() throws Exception {
        Paire obj1 = new Paire(new ArrayList<>(Arrays.asList(
                new Card(2, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"),
                new Card(4, "Pi"),
                new Card(4, "Pi")
        )));

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
        //fixme : les cartes ne sont pas correctement construite
        // obj1 > obj2
        Assert.assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        Assert.assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        Assert.assertEquals(0, obj1.compareTo(obj3));
    }

}