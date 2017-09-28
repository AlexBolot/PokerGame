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
 . Last Modified : 26/09/17 08:45
 ...............................................................................................................................*/

public class TestingUtils
{
    private static ArrayList<Card> allCards = new ArrayList<>();
    private static Random          random   = new Random();

    public static ArrayList<Card> getAllCards ()
    {
        allCards.clear();

        for (int i = 1; i < 14; i++)
        {
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
            allCards.add(new Card(i, ""));
        }

        return allCards;
    }

    public static int getRandomInt (int bound)
    {
        return random.nextInt(bound);
    }
}