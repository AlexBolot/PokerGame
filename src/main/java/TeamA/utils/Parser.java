package TeamA.utils;

import TeamA.classe.Card;
import TeamA.classe.Hand;

import java.util.ArrayList;
import java.util.Scanner;

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
 . Last Modified : 27/09/17 16:16
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
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            String stringVal = tab[i].substring(0, 1);
            String color = tab[i].substring(1, 3);
            int intVal = 0;

            if (isInteger(stringVal))
            {
                intVal = Integer.parseInt(stringVal);
            }
            else
            {
                switch (stringVal)
                {
                    case "V":
                        intVal = 11;
                        break;

                    case "D":
                        intVal = 12;
                        break;

                    case "R":
                        intVal = 13;
                        break;

                    case "A":
                        intVal = 14;
                        break;

                    default:
                        intVal = 0;
                }
            }

            hand.add(new Card(intVal, color));
        }
        return hand;
    }

    private static boolean isInteger (String s)
    {
        try
        {
            //noinspection ResultOfMethodCallIgnored
            Integer.parseInt(s);
        }
        catch (NumberFormatException | NullPointerException e)
        {
            return false;
        }
        return true;
    }
}
