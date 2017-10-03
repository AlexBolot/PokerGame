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
 . Last Modified : 03/10/17 19:04
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

        System.out.println("Main 1 : " + hand1.toString());
        System.out.println("Main 2 : " + hand2.toString());

        switch (hand1.findBestCombination().compareTo(hand2.findBestCombination()))
        {
            case 1:
                System.out.println("La main 1 est gagnante avec " + hand1.findBestCombination().getClass().getSimpleName());
                break;

            case -1:
                System.out.println("La main 2 est gagnante avec " + hand2.findBestCombination().getClass().getSimpleName());
                break;

            case 0:
                System.out.println("Egalité avec " + hand1.findBestCombination().getClass().getSimpleName());
                break;

            default:
                System.out.println("Something went wrong");
        }
    }
}
