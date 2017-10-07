package TeamA;

import TeamA.classe.Combinations.Combination;
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
 . Last Modified : 07/10/17 22:01
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

        System.out.println(getInputFormat());
        hand1 = readCards();
        hand2 = readCards();

        //5Pi 9Tr 9Pi DPi DTr
        //4Pi 3Pi 8Co RTr VCo

        System.out.println("\n");
        System.out.println("Main 1 : " + hand1.toString());
        System.out.println("Main 2 : " + hand2.toString());

        Combination comb1 = hand1.findBestCombination();
        Combination comb2 = hand2.findBestCombination();

        switch (comb1.compareTo(comb2))
        {
            case 1:
                System.out.println("La main 1 est gagnante avec " + comb1.toString());
                break;

            case -1:
                System.out.println("La main 2 est gagnante avec " + comb2.toString());
                break;

            case 0:
                System.out.println("Egalité avec " + comb1.getClass().getSimpleName());
                break;

            default:
                System.out.println("Something went wrong");
        }
    }

    private static String getInputFormat ()
    {
        StringBuilder str = new StringBuilder();

        str.append("Format : chiffre de 2 à 10 ou V (valet), D (dame), R (roi), A (as)");
        str.append("\n");
        str.append("suivi par 2 lettres : Ca (carreau), Co (coeur), Tr (trèfle), Pi (pique)");
        str.append("\n");
        str.append("\n");
        return str.toString();
    }
}
