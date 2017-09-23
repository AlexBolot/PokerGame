package TeamA;

import TeamA.classe.Hand;

import static TeamA.utils.Parser.readCards;

/*................................................................................................................................
 . Copyright (c)
 .
 . The App	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

/**
 Hello world!
 */
public class App
{
    public static void main (String[] args)
    {

        System.out.println("Hello team A!");
        Hand hand1, hand2;
        hand1 = readCards();
        hand2 = readCards();

        // TODO afficher qu'elle main a la carte la plus haute

        System.out.println(hand1.toString());
        System.out.println(hand2.toString());


    }
}
