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

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public abstract class Parser
{

    public static void readCards ()
    {
        //Initialisation des variables
        Scanner sc = new Scanner(System.in);


        System.out.println("Entrez les 5 cartes de la première main");
        String main1 = sc.nextLine();
        System.out.println("Entrez les 5 cartes de la deuxième main");
        String main2 = sc.nextLine();

        parseCards(main1, main2);

    }

    public static void parseCards (String main1, String main2)
    {
        //Initialisation des variables
        String[] tabMain1, tabMain2;
        ArrayList<Card> hand1, hand2;

        tabMain1 = main1.split(" ");
        tabMain2 = main2.split(" ");

        // creation des objets Card et des objets combinations
        System.out.print("main1 : ");

        hand1 = getCard(tabMain1);
        hand2 = getCard(tabMain2);
    }
    public static ArrayList<Card> getCard(String[] tab){
        Card c;
        String card;
        ArrayList<Card> hand = new ArrayList<Card>();
        for(int i=0; i<5; i++){
            System.out.print(tab[i] +"-");
            card = tab[i].substring(0,1);
            c = new Card(parseInt(card), tab[i]);
            hand.add(c);
        }
        return hand;
    }
}
