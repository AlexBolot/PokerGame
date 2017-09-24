package TeamA.classe.Combinations;

import TeamA.classe.Card;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.operations.Plus;

import java.util.ArrayList;

/*................................................................................................................................
 . Copyright (c)
 .
 . The Combination	 Class was Coded by : Team_A
 .
 . Members :
 . -> Alexandre Bolot
 . -> Mathieu Paillart
 . -> Grégoire Peltier
 . -> Théos Mariani
 .
 . Last Modified : 23/09/17 16:42
 ...............................................................................................................................*/

abstract public class Combination implements Comparable<Combination> {
    private ArrayList<Card> hand = new ArrayList<Card>();
    private String name;
    private int value;

    public Combination(ArrayList<Card> hand){
        this.hand = hand;

        // TODO trouver la meilleure combinaison
        //this.name =
        //this.value = value;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Card gethighestcard(ArrayList<Card> cards){
        Card highest = cards.get(0);
        for ( Card C : cards )
        {
           if (C.compareTo(highest)==1)
           {
               highest = C;
           }
        }
        return(highest);
    }

    @Override
    public int compareTo(Combination o) {
        int result;
        result = Integer.compare(this.value,o.value);
        if (result!=0){
            return(result);
        }
        if (o instanceof PlusHauteCarte && this instanceof PlusHauteCarte){
            return(((PlusHauteCarte) this).compareTo((PlusHauteCarte) o));

        }
    return(-2);

    }
}
