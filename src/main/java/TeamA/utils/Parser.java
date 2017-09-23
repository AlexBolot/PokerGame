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
        String card;
        Card c;
        ArrayList<Card> hand = new ArrayList<Card>();
        Combination Combination1, Combination2;

        tabMain1 = main1.split(" ");
        tabMain2 = main2.split(" ");

        // creation des objets Card et des objets combinations
        System.out.print("main1 : ");
        for(int i=0; i<5; i++){
            System.out.print(tabMain1[i] +"-");
            card = tabMain1[i].substring(0,1);
            c = new Card(parseInt(card), tabMain1[i]);
            hand.add(c);
        }
        Combination1 = new Combination(hand);

        for(int i=0; i<5; i++){
            System.out.print(tabMain2[i]+"-");
            card = tabMain2[i].substring(0,1);
            c = new Card(parseInt(card), tabMain2[i]);
            hand.add(c);
        }
        Combination1 = new Combination(hand);
        System.out.println("\nmain2 : " + main2);
    }
}
