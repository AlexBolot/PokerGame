package TeamA.utils;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Parser	 Class was Coded by : Alexandre BOLOT
 .
 . Last Modified : 23/09/17 14:34
 .
 . Contact : bolotalex06@gmail.com
 ...............................................................................................................................*/

import TeamA.classe.Card;
import TeamA.classe.Combination;
import TeamA.classe.Hand;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public abstract class Parser
{

    public static Hand readCards ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez 5 cartes (cad un chiffre de 1 à 10 et une lettre pour la couleur)");
        String main = sc.nextLine();
        return parseCards(main);
    }

    public static Hand parseCards (String main)
    {
        String[] tabMain;
        tabMain = main.split(" ");
        return new Hand(getCard(tabMain));
    }
    public static ArrayList<Card> getCard(String[] tab){
        Card c;
        String card;
        ArrayList<Card> hand = new ArrayList<Card>();
        for(int i=0; i<5; i++){
            card = tab[i].substring(0,1);
            c = new Card(parseInt(card), tab[i]);
            hand.add(c);
        }
        return hand;
    }
}
