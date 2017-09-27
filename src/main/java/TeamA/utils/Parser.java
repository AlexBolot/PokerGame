package TeamA.utils;

import TeamA.classe.Card;
import TeamA.classe.Hand;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Parser	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 26/09/17 17:16
 ...............................................................................................................................*/

public abstract class Parser
{

    public static Hand readCards ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez 5 cartes (cad un chiffre de 2 à 10");// et une lettre pour la couleur)");
        String main = sc.nextLine();
        return parseCards(main);
    }

    private static Hand parseCards (String main)
    {
        String[] tabMain;
        tabMain = main.split(" ");
        return new Hand(getCard(tabMain));
    }

    private static ArrayList<Card> getCard (String[] tab)
    {
        Card c;
        String card;
        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            card = tab[i];
            c = new Card(parseInt(card), "");

            //Will be used in next release.
            //card = tab[i].substring(0, 1);
            //c = new Card(parseInt(card), tab[i].substring(1,3));
            hand.add(c);
        }
        return hand;
    }
}
