package TeamA;

import TeamA.classe.Card;

import java.util.ArrayList;
import java.util.Random;

/*................................................................................................................................
 . Copyright (c)
 .
 . The TestingUtils	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 04/10/17 14:39
 ...............................................................................................................................*/

public class TestingUtils
{
    private static ArrayList<Card> allCards = new ArrayList<>();
    private static Random          random   = new Random();

    public static ArrayList<Card> getAllCards ()
    {
        allCards.clear();

        for (int i = 2; i < 11; i++)
        {
            allCards.add(new Card(i, "Tr"));
            allCards.add(new Card(i, "Pi"));
            allCards.add(new Card(i, "Ca"));
            allCards.add(new Card(i, "Co"));
        }

        return allCards;
    }

    public static int getRandomInt (int bound)
    {
        return random.nextInt(bound);
    }
}
