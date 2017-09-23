package TeamA;

import TeamA.classe.Card;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 Hello world!
 */
public class App
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello team A!");
        System.out.println("Entrez les 5 cartes de la première main");
        String main1 = sc.nextLine();

        System.out.println("Entrez les 5 cartes de la deuxième main");
        String main2 = sc.nextLine();

        String[] tabMain1, tabMain2;
        tabMain1 = main1.split(" ");
        tabMain2 = main2.split(" ");
        String card;
        Card c;
        System.out.print("main1 : ");
        for(int i=0; i<5; i++){
            System.out.print(tabMain1[i] +"-");
            card = tabMain1[i].substring(0,1);
            c = new Card(parseInt(card), tabMain1[i]);
        }

        //System.out.println("main1 : " + main1);
        System.out.println("\nmain2 : " + main2);

    }
}
