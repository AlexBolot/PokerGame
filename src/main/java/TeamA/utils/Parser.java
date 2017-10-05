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
 . Last Modified : 05/10/17 11:36
 ...............................................................................................................................*/

public abstract class Parser
{
    private static ArrayList<Card> typedCards = new ArrayList<>();

    public static Hand readCards ()
    {
        System.out.println("Entrez 5 cartes :");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        return parseCards(line);
    }

    private static Hand parseCards (String line)
    {
        String[] stringCardsArray;
        stringCardsArray = line.split(" ");

        if (stringCardsArray.length != 5)
            printErrorAndRestart("Vous avez saisi " + stringCardsArray.length + " Carte(s), veuillez en saisir 5");

        return new Hand(getCard(stringCardsArray));
    }

    private static ArrayList<Card> getCard (String[] stringCardsArray)
    {
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            String stringCard = stringCardsArray[i];
            int stringCardLength = stringCard.length();

            if (stringCardLength < 3) printErrorAndRestart("La carte a été mal saisie, veuillez réessayer.");

            String stringVal = stringCard.substring(0, stringCardLength - 2);
            String color = stringCard.substring(stringCardLength - 2);
            int intVal = 0;

            if (isInteger(stringVal))
            {
                intVal = Integer.parseInt(stringVal);

                if (intVal > 10 || intVal < 2)
                    printErrorAndRestart("Vous avez saisi  " + intVal + " Veuillez rentrer un nombre entre 2 et 10");
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
                        printErrorAndRestart(stringCard + " est incorrecte, veuillez saisir une carte correcte. ");
                }
            }

            if (!color.equals("Pi") && !color.equals("Co") && !color.equals("Ca") && !color.equals("Tr"))
                printErrorAndRestart(color + "n'est pas une couleur existante dans le Poker.");

            Card card = new Card(intVal, color);

            if (typedCards.contains(card)) printErrorAndRestart(card + " a déjà été saisi");

            typedCards.add(card);
            hand.add(card);
        }
        return hand;
    }

    private static void printErrorAndRestart (String message)
    {
        while (typedCards.size() % 5 != 0)
        {
            typedCards.remove(typedCards.size() - 1);
        }

        System.out.println(message);
        readCards();
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
