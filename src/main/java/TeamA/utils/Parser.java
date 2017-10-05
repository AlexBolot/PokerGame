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
 . Last Modified : 03/10/17 18:21
 ...............................................................................................................................*/

public abstract class Parser
{
    private static ArrayList<Card> typedCards = new ArrayList<>();

    public static Hand readCards ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "Entrez 5 cartes (c'est à dire un chiffre de 2 à 10 et V=Valet, D=Dame, R=Roi, A=As et deux lettres pour la couleur TR=trèle, CO=coeur, CA=carreau, PI=Pique)");

        String line = sc.nextLine();

        try
        {
        return parseCards(line);}
        catch (IllegalArgumentException iae)
        {
            printError(iae.getMessage());
            return readCards();
        }
    }

    private static Hand parseCards (String line)
    {
        String[] stringCardsArray;
        stringCardsArray = line.split(" ");

        if (stringCardsArray.length != 5)
            throw new IllegalArgumentException("Vous avez saisi " + stringCardsArray.length + " Carte(s), veuillez en saisir 5");
        try {
            return new Hand(getCard(stringCardsArray));
        }
        catch (IllegalArgumentException iae)
            {
                printError(iae.getMessage());
                return readCards();
            }
    }



    private static ArrayList<Card> getCard (String[] stringCardsArray)
    {
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            String stringCard = stringCardsArray[i];
            int stringCardLength = stringCard.length();

            if (stringCardLength < 3) throw new IllegalArgumentException("La carte a été mal saisie, veuillez réessayer.");

            String stringVal = stringCard.substring(0, stringCardLength - 2);
            String color = stringCard.substring(stringCardLength - 2);
            int intVal = 0;

            if (isInteger(stringVal))
            {
                intVal = Integer.parseInt(stringVal);

                if (intVal > 10 || intVal < 2)
                    throw new IllegalArgumentException("Vous avez saisi  " + intVal + " Veuillez rentrer un nombre entre 2 et 10");
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
                        throw new IllegalArgumentException(stringCard + " est incorrecte, veuillez saisir une carte correcte. ");
                }
            }

            if (!color.equals("Pi") && !color.equals("Co") && !color.equals("Ca") && !color.equals("Tr"))
                throw new IllegalArgumentException(color + "n'est pas une couleur existante dans le Poker.");

            Card card = new Card(intVal, color);

            if (typedCards.contains(card)) throw new IllegalArgumentException(card + " a déjà été saisi");

            typedCards.add(card);
            hand.add(card);
        }
        return hand;
    }

    private static void printError (String message)
    {
        while (typedCards.size()%5!=0)
        {
            typedCards.remove(typedCards.size() - 1);
        }
        System.out.println(message);
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
