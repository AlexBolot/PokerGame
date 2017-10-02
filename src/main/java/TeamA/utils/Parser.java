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
    private static ArrayList<Card> typedCard = new ArrayList<>();

    public static Hand readCards ()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez 5 cartes (c'est à dire un chiffre de 2 à 10 et V=Valet, D=Dame, R=Roi, A=As et deux lettres pour la couleur TR=trèle, CO=coeur, CA=carreau, PI=Pique)");
        String main = sc.nextLine();
        return parseCards(main);
    }

    private static Hand parseCards (String main)
    {
        String[] tabMain;
        tabMain = main.split(" ");
        if (tabMain.length!=5)
        {
            System.out.println("Vous avez saisi " + tabMain.length + " Carte(s), veuillez en saisir 5");
            readCards();
        }
        return new Hand(getCard(tabMain));

    }

    private static ArrayList<Card> getCard (String[] tab)
    {
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 0; i < 5; i++)
        {
            if (tab[i].length()<3)
            {
                System.out.println("La carte a été mal saisie, veuillez réessayer.");
                readCards();
            }
            String stringVal = tab[i].substring(0,tab[i].length()-2);
            String color = tab[i].substring(tab[i].length()-2);
            int intVal = 0;

            if (isInteger(stringVal))
            {
                intVal = Integer.parseInt(stringVal);
                if (intVal>10 || intVal<2)
                {
                    System.out.println("Vous avez saisi  " + intVal + " Veuillez rentrer un nombre entre 2 et 10");
                    readCards();
                }
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
                        System.out.println(tab[i] + " est incorrecte, veuillez saisir une carte correcte. ");
                        readCards();
                }
            }
            if (!color.equals("PI") && !color.equals("CO") && !color.equals("CA") && !color.equals("TR"))
            {
                System.out.println(color + "n'est pas une couleur existante dans le Poker.");
                readCards();
            }
            Card card = new Card(intVal, color);
            if (typedCard.contains(card))
            {
                System.out.println(card + " a déjà été saisi");
                readCards();
            }
            typedCard.add(card);
            hand.add(card);
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
