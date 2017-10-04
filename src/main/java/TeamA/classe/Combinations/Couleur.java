package TeamA.classe.Combinations;

import TeamA.classe.Card;

import java.util.ArrayList;
import java.util.HashMap;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Couleur	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

public class Couleur extends Combination
{
    private String color;
    public Couleur (ArrayList<Card> hand)
    {
        super(hand);
        this.color = Couleur.FindColor(hand);
        this.setValue(5);
    }
    public String getColor(){
        return color;
    }
    public static boolean isTypeOf(ArrayList<Card> hand){
        return Couleur.FindColor(hand) != null;
    }
    public static String FindColor(ArrayList<Card> hand){
        String color = hand.get(1).getName();
        for(Card c : hand){
            if(color != c.getName()){
                return null;
            }
        }
        return color;
    }
    @Override
    public int compareTo (Combination o)
    {
        int valueCompare = super.compareTo(o);
        if (valueCompare != 0) return valueCompare;

        Couleur couleur = (Couleur) o;

        PlusHauteCarte phc1 = new PlusHauteCarte(getRestOfCards());
        PlusHauteCarte phc2 = new PlusHauteCarte(couleur.getRestOfCards());

        return phc1.compareTo(phc2);
    }
}
