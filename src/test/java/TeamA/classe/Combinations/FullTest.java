package TeamA.classe.Combinations;

import TeamA.classe.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*................................................................................................................................
 . Copyright (c)
 .
 . The FullTest	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 16:50
 ...............................................................................................................................*/

public class FullTest
{


    private ArrayList<Card> cardsB8P5mixed;
    private ArrayList<Card> cardsB8P5;
    private ArrayList<Card> cardsB5p7;

    @Before
    public void init()
    {

        cardsB8P5mixed = new ArrayList<>(Arrays.asList(new Card(8, "Ca"),
                new Card(8, "Co"),
                new Card(5, "Tr"),
                new Card(5, "Pi"),
                new Card(8, "Pi")));
        cardsB8P5 = new ArrayList<>(Arrays.asList(new Card(5, "Ca"),
                new Card(5, "Co"),
                new Card(8, "Tr"),
                new Card(8, "Pi"),
                new Card(8, "Pi")));
        cardsB5p7 = new ArrayList<>(Arrays.asList(new Card(7, "Ca"),
                new Card(5, "Co"),
                new Card(7, "Tr"),
                new Card(5, "Pi"),
                new Card(7, "Pi")));
        ;
    }

    @Test
    public void compareTo() throws Exception {
        Full b5p7 = new Full(cardsB5p7);
        Full b8p5 = new Full(cardsB8P5);
        Full b8p5mixed = new Full(cardsB8P5mixed);

        assertEquals(-1, b5p7.compareTo(b8p5));
        assertEquals(0, b8p5mixed.compareTo(b8p5));
        assertEquals(1, b8p5.compareTo(b5p7));


    }

    @Test
    public void isTypeOf() throws Exception {

        Full obj1 = new Full(cardsB8P5);

        Full obj2 = new Full(cardsB5p7);

        Full obj3 = new Full(cardsB8P5mixed);

        // obj1 > obj2
        assertEquals(1, obj1.compareTo(obj2));
        // obj2 < obj1
        assertEquals(-1, obj2.compareTo(obj1));
        // obj1 = obj3
        assertEquals(0, obj1.compareTo(obj3));
    }

}